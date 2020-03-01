package com.hui.cloud.uc.controller;

import com.hui.cloud.auth.api.AuthClient;
import com.hui.cloud.auth.dto.AuthTokenDTO;
import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.LoginRequestDTO;
import com.hui.cloud.uc.entity.User;
import com.hui.cloud.uc.exception.SysUserException;
import com.hui.cloud.uc.service.UserService;
import com.hui.cloud.uc.vo.LoginUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>LoginController</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/1 11:01.
 *
 * @author Gary.Hu
 */
@RestController
public class LoginController {

    private UserService userService;

    private AuthClient authClient;

    @Autowired
    public LoginController(UserService userService, AuthClient authClient) {
        this.userService = userService;
        this.authClient = authClient;
    }


    /**
     * 用户登录
     * 登录接口需要在请求头添加 Authorization
     * 传递格式  clietnId:clientscert (Base64转格式)=> Base Basic dXNlcmNlbnRlci1zZXJ2aWNlOjEyMzQ1Ng==
     * @param authorization
     * @param loginRequestDTO
     * @return
     */
    @PostMapping(value = "/user/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO login(@RequestHeader(value = "Authorization") String authorization,
                            @RequestBody LoginRequestDTO loginRequestDTO) {
        User sysUser = userService.getUserByName(loginRequestDTO.getUserName());
        if(null==sysUser){
            throw new SysUserException("该用户不存在");
        }
        AuthTokenDTO authTokenDTO= authClient.getToken(authorization, loginRequestDTO.getUserName(), loginRequestDTO.getPassword(), "password");

        LoginUserVO loginUserVO = new LoginUserVO();
        BeanUtils.copyProperties(authTokenDTO,loginUserVO);
        BeanUtils.copyProperties(sysUser, loginUserVO);
        return ResponseVO.ok(loginUserVO);
    }
}

package com.hui.cloud.uc.user.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.user.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/user/sys-resource")
public class SysResourceController {

    private SysResourceService sysResourceService;

    @Autowired
    public SysResourceController(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }

    @GetMapping("")
    public ResponseVO listResources(Integer pageNum,Integer pageSize){

        return ResponseVO.ok();
    }
}


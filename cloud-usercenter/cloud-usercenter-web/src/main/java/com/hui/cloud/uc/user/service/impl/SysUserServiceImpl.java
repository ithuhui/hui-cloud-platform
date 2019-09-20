package com.hui.cloud.uc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.user.mapper.SysUserMapper;
import com.hui.cloud.uc.user.model.entity.SysUser;
import com.hui.cloud.uc.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    @Override
    public SysUser getUserByName(String userName) {
        LambdaQueryWrapper<SysUser> queryWrapper =
                Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, userName);
        return sysUserMapper.selectOne(queryWrapper);
    }

    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysUser> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysUser> page = new Page<>(pageNum,pageSize);
        List<SysUser> sysUsers = sysUserMapper.selectPage(page, null).getRecords();
        return sysUsers;
    }

}

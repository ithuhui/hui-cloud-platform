package com.hui.cloud.uc.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.user.model.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysRole> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    List<SysRole> listByUserId(Long userId);

    /**
     * 查询组角色
     * @param groupId
     * @return
     */
    List<SysRole> listByGroupId(Long groupId);

}

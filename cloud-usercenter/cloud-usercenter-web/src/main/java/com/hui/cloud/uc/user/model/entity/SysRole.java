package com.hui.cloud.uc.user.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_uc_sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID=1L;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.NONE)
    private Long roleId;

    /**
     * 角色代码
     */
    @TableField("role_code")
    private String roleCode;

    /**
     * 角色名字
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT_UPDATE)
    private String createUser;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private LocalDateTime modifyTime;

    /**
     * 修改用户
     */
    @TableField(value = "modify_user", fill = FieldFill.UPDATE)
    private String modifyUser;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}

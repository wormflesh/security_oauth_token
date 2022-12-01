package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wormflesh
 * @since 2022-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("wf_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色唯一标识符
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色状态，1为正常，0为不可用
     */
    @TableField("role_status")
    private Boolean roleStatus;

    /**
     * 角色描述
     */
    @TableField("role_description")
    private String roleDescription;


}

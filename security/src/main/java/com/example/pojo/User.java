package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("wf_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("user_id")
    private Long userId;

    /**
     * 用户的注册名称
     */
    @TableField("user_login")
    private String userLogin;

    /**
     * 用户的密码
     */
    @TableField("user_pass")
    private String userPass;

    /**
     * 用户的昵称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 用户的邮箱
     */
    @TableField("user_email")
    private String userEmail;

    /**
     * 用户注册时间
     */
    @TableField("user_registered")
    private LocalDateTime userRegistered;

    /**
     * 用户状态，1为正常，0为封禁
     */
    @TableField("user_status")
    private Boolean userStatus;

    /**
     * 用户头像的url地址
     */
    @TableField("user_profile_url")
    private String userProfileUrl;


}

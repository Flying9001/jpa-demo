package com.ljq.demo.jpa.model.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * REST示例-用户表参数接收类
 *
 * @author junqiang.lu
 * @date 2019-12-19 16:58:31
 */
@Data
public class RestUserDeleteVO extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 用户 id
     * */
    @NotNull(message = "用户 id 不能为空")
    @Min(value = 1, message = "用户 id 至少为 1")
    private Long id;
    /**
     * 用户名
     * */
    @NotNull(message = "用户名 不能为空")
    private String userName;
    /**
     * 密码
     * */
    @NotNull(message = "密码 不能为空")
    private String passcode;
    /**
     * 邮箱
     * */
    @NotNull(message = "邮箱 不能为空")
    private String email;
    /**
     * 用户状态,0:所有,不区分状态,1:正常(默认),2:禁止登陆
     * */
    @NotNull(message = "用户状态,0:所有,不区分状态,1:正常(默认),2:禁止登陆 不能为空")
    @Min(value = 1, message = "用户状态,0:所有,不区分状态,1:正常(默认),2:禁止登陆 至少为 1")
    private Integer userStatus;


}

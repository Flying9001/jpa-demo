package com.ljq.demo.jpa.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * REST示例-用户表参数接收类
 *
 * @author junqiang.lu
 * @date 2019-12-19 16:58:31
 */
@Data
@ApiModel(value = "更新用户信息", description = "更新用户信息")
public class RestUserUpdateParam extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 用户 id
     * */
    @NotNull(message = "请输入用户ID")
    @Min(value = 1, message = "用户ID输入错误")
    @ApiModelProperty(value = "用户 id", name = "id", required = true, example = "0")
    private Long id;
    /**
     * 用户名
     * */
    @Length(max = 30, message = "用户名不能超过 30 字符")
    @ApiModelProperty(value = "用户名,选填,若传值,不能超过 30 字符", name = "userName")
    private String userName;
    /**
     * 密码
     * */
    @Length(max = 80, message = "密码不能超过 80 字符")
    @ApiModelProperty(value = "密码,选填,若传值,不能超过 80 字符", name = "passcode")
    private String passcode;
    /**
     * 邮箱
     * */
    @Length(max = 50, message = "邮箱不能超过 50 字符")
    @ApiModelProperty(value = "邮箱,选填,若传值,不能超过 50 字符", name = "email")
    private String email;

}

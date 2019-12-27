package com.ljq.demo.jpa.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * REST示例-用户表参数接收类
 *
 * @author junqiang.lu
 * @date 2019-12-19 16:58:31
 */
@Data
@ApiModel(value = "新增用户", description = "新增用户")
public class RestUserSaveParam extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     * */
    @NotNull(message = "用户名不能为空")
    @Length(max = 30, message = "用户名不能超过 30 字符")
    @ApiModelProperty(value = "用户名,不能为空,不能超过 30 字符", name = "userName", required = true)
    private String userName;
    /**
     * 密码
     * */
    @NotNull(message = "密码不能为空")
    @Length(max = 80, message = "密码不能超过 80 字符")
    @Pattern(regexp = "\\w{0,80}", message = "密码仅支持字母、数字、下划线")
    @ApiModelProperty(value = "密码,不能为空,不能超过 80 字符", name = "passcode", required = true)
    private String passcode;
    /**
     * 邮箱
     * */
    @NotNull(message = "邮箱不能为空")
    @Length(max = 50, message = "邮箱不能超过 50 字符")
    @Email(message = "邮箱格式错误")
    @ApiModelProperty(value = "邮箱,不能为空,不能超过 50 字符", name = "email", required = true)
    private String email;


}

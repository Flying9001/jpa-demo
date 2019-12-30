package com.ljq.demo.jpa.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

/**
 * @Description: 搜索用户
 * @Author: junqiang.lu
 * @Date: 2019/12/30
 */
@Data
@ApiModel(value = "搜索用户", description = "搜索用户")
public class RestUserSearchParam extends BasePageParam {

    private static final long serialVersionUID = 4123802103824544007L;

    /**
     * 用户 id
     * */
    @Min(value = 1, message = "用户ID输入错误")
    @ApiModelProperty(value = "用户 id,选填,若传值,至少为 1", name = "id", example = "0")
    private Long id;
    /**
     * 用户名
     * */
    @Length(max = 30, message = "用户名不能超过 30 字符")
    @ApiModelProperty(value = "用户名,选填,若传值,不能超过 30 字符", name = "userName")
    private String userName;
    /**
     * 邮箱
     * */
    @Length(max = 50, message = "邮箱不能超过 50 字符")
    @Email(message = "邮箱格式错误")
    @ApiModelProperty(value = "邮箱,选填,若传值,不能超过 50 字符", name = "email")
    private String email;


}

package com.ljq.demo.jpa.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "查询用户详细信息", description = "查询用户详细信息")
public class RestUserFindByIdParam extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 用户 id
     * */
    @NotNull(message = "请输入用户ID")
    @Min(value = 1, message = "用户ID输入错误")
    @ApiModelProperty(value = "用户 id", name = "id", required = true, example = "0")
    private Long id;


}

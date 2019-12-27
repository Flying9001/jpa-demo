package com.ljq.demo.jpa.model.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * REST示例-用户表参数接收类
 *
 * @author junqiang.lu
 * @date 2019-12-19 16:58:31
 */
@Data
@ApiModel(value = "查询所有用户", description = "查询所有用户")
public class RestUserFindAllParam extends BasePageParam {

    private static final long serialVersionUID = 1L;


}

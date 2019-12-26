package com.ljq.demo.jpa.model.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * REST示例-用户表参数接收类
 *
 * @author junqiang.lu
 * @date 2019-12-19 16:58:31
 */
@Data
public class RestUserFindByIdVO extends BaseParam {

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
    /**
     * 创建时间
     * */
    @NotNull(message = "创建时间 不能为空")
    private Date insertTime;
    /**
     * 添加人用户 id
     * */
    @NotNull(message = "添加人用户 id 不能为空")
    @Min(value = 1, message = "添加人用户 id 至少为 1")
    private Long insertUserId;
    /**
     * 添加人身份标识,0:前台用户;1:后台用户(默认)
     * */
    @NotNull(message = "添加人身份标识,0:前台用户;1:后台用户(默认) 不能为空")
    @Min(value = 1, message = "添加人身份标识,0:前台用户;1:后台用户(默认) 至少为 1")
    private Integer insertIdentity;
    /**
     * 更新时间
     * */
    @NotNull(message = "更新时间 不能为空")
    private Date updateTime;
    /**
     * 修改人用户 id
     * */
    @NotNull(message = "修改人用户 id 不能为空")
    @Min(value = 1, message = "修改人用户 id 至少为 1")
    private Long updateUserId;
    /**
     * 修改人身份标识;0:前台用户;1:后台用户(默认)
     * */
    @NotNull(message = "修改人身份标识;0:前台用户;1:后台用户(默认) 不能为空")
    @Min(value = 1, message = "修改人身份标识;0:前台用户;1:后台用户(默认) 至少为 1")
    private Integer updateIdentity;
    /**
     * 版本控制字段(默认1)
     * */
    @NotNull(message = "版本控制字段(默认1) 不能为空")
    @Min(value = 1, message = "版本控制字段(默认1) 至少为 1")
    private Integer versions;
    /**
     * 逻辑删除字段,0正常(默认),1删除
     * */
    @NotNull(message = "逻辑删除字段,0正常(默认),1删除 不能为空")
    @Min(value = 1, message = "逻辑删除字段,0正常(默认),1删除 至少为 1")
    private Integer delSign;


}

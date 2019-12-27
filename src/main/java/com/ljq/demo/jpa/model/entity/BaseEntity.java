package com.ljq.demo.jpa.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 基础实体类
 * @Author: junqiang.lu
 * @Date: 2019/12/19
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -5193151091225256447L;

    /**
     * 创建时间
     * */
    @Column(name = "insert_time")
    private Date insertTime;
    /**
     * 添加人用户 id
     * */
    @Column(name = "insert_user_id")
    private Long insertUserId;
    /**
     * 添加人身份标识,0:前台用户;1:后台用户(默认)
     * */
    @Column(name = "insert_identity")
    private Integer insertIdentity;
    /**
     * 更新时间
     * */
    @Column(name = "update_time")
    private Date updateTime;
    /**
     * 修改人用户 id
     * */
    @Column(name = "update_user_id")
    private Long updateUserId;
    /**
     * 修改人身份标识;0:前台用户;1:后台用户(默认)
     * */
    @Column(name = "update_identity")
    private Integer updateIdentity;
    /**
     * 版本控制字段(默认1)
     * */
    @Column(name = "versions")
    private Integer versions;
    /**
     * 逻辑删除字段,0正常(默认),1删除
     * */
    @Column(name = "del_sign")
    private Integer delSign;

}

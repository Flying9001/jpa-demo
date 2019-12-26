package com.ljq.demo.jpa.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * REST示例-用户表实体类
 * 
 * @author junqiang.lu
 * @date 2019-12-19 16:58:31
 */
@Data
@Entity(name = "rest_user")
@DynamicInsert
@DynamicUpdate
public class RestUserEntity extends BaseEntity{

	private static final long serialVersionUID = -2027915064727797742L;

	/**
	 * 用户 id
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	/**
	 * 用户名
	 * */
	@Column(name = "user_name")
	private String userName;
	/**
	 * 密码
	 * */
	@Column(name = "passcode")
	private String passcode;
	/**
	 * 邮箱
	 * */
	@Column(name = "email")
	private String email;
	/**
	 * 用户状态,0:所有,不区分状态,1:正常(默认),2:禁止登陆
	 * */
	@Column(name = "user_status")
	private Integer userStatus;

}

package com.ljq.demo.jpa.service;

import com.ljq.demo.jpa.common.api.ApiResult;
import com.ljq.demo.jpa.model.param.*;

/**
 * REST示例-用户表业务层接口
 * 
 * @author junqiang.lu
 * @date 2019-12-26 15:15:33
 */
public interface RestUserService {

	/**
     * 保存(单条)
     *
     * @param restUserSaveVO
     * @return
     * @throws Exception
     */
	ApiResult save(RestUserSaveVO restUserSaveVO) throws Exception;

	/**
     * 查询详情(单条)
     *
     * @param restUserFindByIdVO
     * @return
     * @throws Exception
     */
	ApiResult findById(RestUserFindByIdVO restUserFindByIdVO) throws Exception;

	/**
     * 更新(单条)
     *
     * @param restUserUpdateVO
     * @return
     * @throws Exception
     */
	ApiResult update(RestUserUpdateVO restUserUpdateVO) throws Exception;

	/**
     * 查询列表
     *
     * @param restUserFindAllVO
     * @return
     * @throws Exception
     */
	ApiResult findAll(RestUserFindAllVO restUserFindAllVO) throws Exception;

	/**
     * 删除(单条)
     *
     * @param restUserDeleteVO
     * @return
     * @throws Exception
     */
	ApiResult delete(RestUserDeleteVO restUserDeleteVO) throws Exception;


}

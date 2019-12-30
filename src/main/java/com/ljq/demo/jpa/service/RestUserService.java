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
     * @param restUserSaveParam
     * @return
     * @throws Exception
     */
	ApiResult save(RestUserSaveParam restUserSaveParam) throws Exception;

	/**
     * 查询详情(单条)
     *
     * @param restUserFindByIdParam
     * @return
     * @throws Exception
     */
	ApiResult findById(RestUserFindByIdParam restUserFindByIdParam) throws Exception;

	/**
     * 更新(单条)
     *
     * @param restUserUpdateParam
     * @return
     * @throws Exception
     */
	ApiResult update(RestUserUpdateParam restUserUpdateParam) throws Exception;

	/**
     * 查询列表
     *
     * @param restUserFindAllParam
     * @return
     * @throws Exception
     */
	ApiResult findAll(RestUserFindAllParam restUserFindAllParam) throws Exception;

	/**
	 * 搜索用户
	 *
	 * @param searchParam
	 * @return
	 * @throws Exception
	 */
	ApiResult search(RestUserSearchParam searchParam) throws Exception;

	/**
     * 删除(单条)
     *
     * @param restUserDeleteParam
     * @return
     * @throws Exception
     */
	ApiResult delete(RestUserDeleteParam restUserDeleteParam) throws Exception;


}

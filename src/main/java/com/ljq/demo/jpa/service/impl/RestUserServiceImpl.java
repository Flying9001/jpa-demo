package com.ljq.demo.jpa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.ljq.demo.jpa.common.api.ApiResult;
import com.ljq.demo.jpa.common.api.ResponseCode;
import com.ljq.demo.jpa.dao.RestUserRepository;
import com.ljq.demo.jpa.model.entity.RestUserEntity;
import com.ljq.demo.jpa.model.param.*;
import com.ljq.demo.jpa.service.RestUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * REST示例-用户表业务层具体实现类
 *
 * @author junqiang.lu
 * @date 2019-12-26 15:15:33
 */
@Service("restUserService")
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class RestUserServiceImpl implements RestUserService {

	@Autowired
	private RestUserRepository restUserRepository;

	/**
	 * 保存(单条)
	 *
	 * @param restUserSaveVO
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public ApiResult save(RestUserSaveVO restUserSaveVO) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParams = new RestUserEntity();
		BeanUtil.copyProperties(restUserSaveVO,restUserParams, CopyOptions.create()
				.setIgnoreNullValue(true).setIgnoreError(true));
		// 保存
		RestUserEntity restUserDB = restUserRepository.save(restUserParams);
		if (Objects.isNull(restUserDB) || Objects.isNull(restUserDB.getId())) {
			return ApiResult.failure(ResponseCode.PARAM_ERROR);
		}

		return ApiResult.success();
	}

	/**
	 * 查询详情(单条)
	 *
	 * @param restUserFindByIdVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult findById(RestUserFindByIdVO restUserFindByIdVO) throws Exception {
		// 请求参数获取

		return ApiResult.success();
	}

	/**
	 * 更新(单条)
	 *
	 * @param restUserUpdateVO
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public ApiResult update(RestUserUpdateVO restUserUpdateVO) throws Exception {
		// 请求参数获取

		return ApiResult.success();
	}

	/**
	 * 查询列表
	 *
	 * @param restUserFindAllVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult findAll(RestUserFindAllVO restUserFindAllVO) throws Exception {
		// 请求参数获取

		return ApiResult.success();
	}

	/**
	 * 删除(单条)
	 *
	 * @param restUserDeleteVO
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public ApiResult delete(RestUserDeleteVO restUserDeleteVO) throws Exception {
		// 请求参数获取

		return ApiResult.success();
	}
	

	
}

package com.ljq.demo.jpa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.ljq.demo.jpa.common.api.ApiResult;
import com.ljq.demo.jpa.common.api.ResponseCode;
import com.ljq.demo.jpa.common.constant.CommonConst;
import com.ljq.demo.jpa.common.exception.ParamsCheckException;
import com.ljq.demo.jpa.common.page.PageUtil;
import com.ljq.demo.jpa.common.page.QueryUtil;
import com.ljq.demo.jpa.dao.RestUserRepository;
import com.ljq.demo.jpa.model.entity.RestUserEntity;
import com.ljq.demo.jpa.model.param.*;
import com.ljq.demo.jpa.service.RestUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
	 * @param restUserSaveParam
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public ApiResult save(RestUserSaveParam restUserSaveParam) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(restUserSaveParam,restUserParam, CopyOptions.create()
				.setIgnoreNullValue(true).setIgnoreError(true));
		// 校验-用户邮箱
		long countUser = restUserRepository.countByEmailAndDelSign(restUserSaveParam.getEmail(), CommonConst.DEL_SIGN_NORMAL);
		if (countUser > 0) {
			throw new ParamsCheckException(ResponseCode.USER_EMAIL_REGISTERED);
		}
		// 保存
		RestUserEntity restUserDB = restUserRepository.save(restUserParam);
		if (Objects.isNull(restUserDB) || Objects.isNull(restUserDB.getId())) {
			return ApiResult.failure(ResponseCode.PARAM_ERROR);
		}

		return ApiResult.success(restUserDB.getId());
	}

	/**
	 * 查询详情(单条)
	 *
	 * @param restUserFindByIdParam
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult findById(RestUserFindByIdParam restUserFindByIdParam) throws Exception {
		Optional<RestUserEntity> restUserDB = restUserRepository.findById(restUserFindByIdParam.getId());
		if (!restUserDB.isPresent() || Objects.equals(restUserDB.get().getDelSign(), CommonConst.DEL_SIGN_DELETED)) {
			throw new ParamsCheckException(ResponseCode.OBJECT_NOT_EXIST);
		}

		return ApiResult.success(restUserDB.get());
	}

	/**
	 * 更新(单条)
	 *
	 * @param restUserUpdateParam
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public ApiResult update(RestUserUpdateParam restUserUpdateParam) throws Exception {
		// 请求参数获取
		Optional<RestUserEntity> restUserDB = restUserRepository.findByIdAndDelSign(restUserUpdateParam.getId(),
				CommonConst.DEL_SIGN_NORMAL);
		if (!restUserDB.isPresent()) {
			throw new ParamsCheckException(ResponseCode.OBJECT_NOT_EXIST);
		}
		BeanUtil.copyProperties(restUserUpdateParam, restUserDB.get(), CopyOptions.create()
				.setIgnoreError(true).setIgnoreNullValue(true));
		restUserRepository.save(restUserDB.get());

		return ApiResult.success();
	}

	/**
	 * 查询列表
	 *
	 * @param restUserFindAllParam
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult findAll(RestUserFindAllParam restUserFindAllParam) throws Exception {
		// 请求参数获取
		Map<String, Object> map = BeanUtil.beanToMap(restUserFindAllParam, false, true);
		QueryUtil queryUtil = new QueryUtil(map);
		RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(restUserFindAllParam, restUserParam, CopyOptions.create()
				.setIgnoreError(true).setIgnoreNullValue(true));
		restUserParam.setDelSign(CommonConst.DEL_SIGN_NORMAL);
        // 分页查询
		Pageable pageable = PageRequest.of((queryUtil.getCurrPage() - 1), queryUtil.getPageLimit(),
				Sort.Direction.fromString(queryUtil.getDirection()),
				queryUtil.getProperties());
		Page<RestUserEntity> page = restUserRepository
				.findAll(Example.of(restUserParam),pageable);
		// 返回分页结果
		PageUtil pageUtil = new PageUtil(page.getContent(),(int)page.getTotalElements(),
				queryUtil.getPageLimit(),queryUtil.getCurrPage());

		return ApiResult.success(pageUtil);
	}

	/**
	 * 搜索用户
	 *
	 * @param searchParam
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult search(RestUserSearchParam searchParam) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(searchParam, restUserParam, CopyOptions.create()
				.setIgnoreError(true).setIgnoreNullValue(true));
		Map<String, Object> map = BeanUtil.beanToMap(searchParam, false, true);
		QueryUtil queryUtil = new QueryUtil(map);
		Pageable pageable = PageRequest.of((queryUtil.getCurrPage() - 1), queryUtil.getPageLimit(),
				Sort.Direction.fromString(queryUtil.getDirection()),
				queryUtil.getProperties());
		Page<RestUserEntity> page = restUserRepository.search(restUserParam,pageable);
		// 返回分页结果
		PageUtil pageUtil = new PageUtil(page.getContent(),(int)page.getTotalElements(),
				queryUtil.getPageLimit(),queryUtil.getCurrPage());

		return ApiResult.success(pageUtil);
	}

	/**
	 * 删除(单条)
	 *
	 * @param restUserDeleteParam
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public ApiResult delete(RestUserDeleteParam restUserDeleteParam) throws Exception {
		// 请求参数获取
		Optional<RestUserEntity> restUserDB = restUserRepository.findByIdAndDelSign(restUserDeleteParam.getId(),
				CommonConst.DEL_SIGN_NORMAL);
		if (!restUserDB.isPresent()) {
			throw new ParamsCheckException(ResponseCode.OBJECT_NOT_EXIST);
		}
		restUserDB.get().setDelSign(CommonConst.DEL_SIGN_DELETED);
		restUserRepository.save(restUserDB.get());

		return ApiResult.success();
	}
	

	
}

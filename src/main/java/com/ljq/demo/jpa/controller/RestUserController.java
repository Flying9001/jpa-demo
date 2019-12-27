package com.ljq.demo.jpa.controller;

import com.ljq.demo.jpa.common.api.ApiResult;
import com.ljq.demo.jpa.common.page.PageUtil;
import com.ljq.demo.jpa.model.entity.RestUserEntity;
import com.ljq.demo.jpa.model.param.*;
import com.ljq.demo.jpa.service.RestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * REST示例-用户表
 *
 * @author junqiang.lu
 * @date 2019-12-26 15:15:33
 */
@Controller
@RequestMapping(value = "/api/demo/rest/user")
@Slf4j
@Api(value = "REST示例-用户表控制层", tags = "REST示例-用户表控制层")
public class RestUserController {

    @Autowired
    private RestUserService restUserService;

    /**
     * 保存(单条)
     *
     * @param restUserSaveParam
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表保存(单条)",  notes = "REST示例-用户表保存(单条)")
    @ResponseBody
    public ResponseEntity<ApiResult<Long>> save(@RequestBody RestUserSaveParam restUserSaveParam) throws Exception{
        ApiResult apiResult = restUserService.save(restUserSaveParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }

    /**
     * 查询详情(单条)
     *
     * @param restUserFindByIdParam
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表查询详情(单条)",  notes = "REST示例-用户表查询详情(单条)")
    @ResponseBody
    public ResponseEntity<ApiResult<RestUserEntity>> info(@RequestBody RestUserFindByIdParam restUserFindByIdParam) throws Exception {
        ApiResult apiResult = restUserService.findById(restUserFindByIdParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }

    /**
     * 查询列表
     *
     * @param restUserFindAllParam
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表查询列表",  notes = "REST示例-用户表查询列表")
    @ResponseBody
    public ResponseEntity<ApiResult<PageUtil<RestUserEntity>>> list(@RequestBody RestUserFindAllParam restUserFindAllParam) throws Exception {
        ApiResult apiResult = restUserService.findAll(restUserFindAllParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }

    /**
     * 修改(单条)
     *
     * @param restUserUpdateParam
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表修改(单条)",  notes = "REST示例-用户表修改(单条)")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody RestUserUpdateParam restUserUpdateParam) throws Exception {
        ApiResult apiResult = restUserService.update(restUserUpdateParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }

    /**
     * 删除(单条)
     *
     * @param restUserDeleteParam
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表删除(单条)",  notes = "REST示例-用户表删除(单条)")
    @ResponseBody
    public ResponseEntity<?> delete(@RequestBody RestUserDeleteParam restUserDeleteParam) throws Exception {
        ApiResult apiResult = restUserService.delete(restUserDeleteParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }





}

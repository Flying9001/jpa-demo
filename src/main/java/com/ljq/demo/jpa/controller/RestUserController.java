package com.ljq.demo.jpa.controller;

import com.ljq.demo.jpa.common.api.ApiResult;
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
     * @param restUserSaveVO
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表保存(单条)",  notes = "REST示例-用户表保存(单条)")
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody RestUserSaveVO restUserSaveVO) throws Exception{
        ApiResult apiResult = restUserService.save(restUserSaveVO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.CREATED);
    }

    /**
     * 查询详情(单条)
     *
     * @param restUserFindByIdVO
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表查询详情(单条)",  notes = "REST示例-用户表查询详情(单条)")
    @ResponseBody
    public ResponseEntity<?> info(RestUserFindByIdVO restUserFindByIdVO) throws Exception {
        ApiResult apiResult = restUserService.findById(restUserFindByIdVO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }

    /**
     * 查询列表
     *
     * @param restUserFindAllVO
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表查询列表",  notes = "REST示例-用户表查询列表")
    @ResponseBody
    public ResponseEntity<?> list(RestUserFindAllVO restUserFindAllVO) throws Exception {
        ApiResult apiResult = restUserService.findAll(restUserFindAllVO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
    }

    /**
     * 修改(单条)
     *
     * @param restUserUpdateVO
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表修改(单条)",  notes = "REST示例-用户表修改(单条)")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody RestUserUpdateVO restUserUpdateVO) throws Exception {
        ApiResult apiResult = restUserService.update(restUserUpdateVO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.CREATED);
    }

    /**
     * 删除(单条)
     *
     * @param restUserDeleteVO
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE, produces = {"application/json"})
    @ApiOperation(value = "REST示例-用户表删除(单条)",  notes = "REST示例-用户表删除(单条)")
    @ResponseBody
    public ResponseEntity<?> delete(RestUserDeleteVO restUserDeleteVO) throws Exception {
        ApiResult apiResult = restUserService.delete(restUserDeleteVO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(apiResult, headers, HttpStatus.NO_CONTENT);
    }





}

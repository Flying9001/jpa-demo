package com.ljq.demo.jpa.common.api;

import lombok.Getter;
import lombok.ToString;

/**
 * @Description: 接口返回码枚举类
 * @Author: junqiang.lu
 * @Date: 2019/3/26
 */
@Getter
@ToString
public enum  ResponseCode {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(-1, "失败"),

    /**
     * 参数与公共模块
     */
    PARAM_ERROR(1001, "参数(格式)错误"),
    PARAM_NOT_NULL(1002, "参数不能为空"),
    OBJECT_NOT_EXIST(1003, "查询对象不存在"),
    REQUEST_METHOD_ERROR(1004, "请求方式错误"),
    MEDIA_TYPE_NOT_SUPPORT_ERROR(1005, "参数(文件)格式不支持"),
    PARAM_BIND_ERROR(1006, "参数格式错误,数据绑定失败"),
    NOT_FOUND_ERROR(1007, "请求资源(接口)不存在"),
    MISS_REQUEST_PART_ERROR(1008, "缺少请求体(未上传文件)"),
    MISS_REQUEST_PARAM_ERROR(1009, "缺少请求参数"),

    /**
     * 用户
     */
    USER_EMAIL_REGISTERED(2001, "用户邮箱已经注册"),


    /**
     * 未知异常
     */
    UNKNOWN_ERROR(-1000,"系统异常");


    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

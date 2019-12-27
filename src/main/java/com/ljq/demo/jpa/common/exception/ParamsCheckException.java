package com.ljq.demo.jpa.common.exception;

import com.ljq.demo.jpa.common.api.ResponseCode;
import lombok.Data;

/**
 * @Description: 参数校验异常类
 * @Author: junqiang.lu
 * @Date: 2019/3/26
 */
@Data
public class ParamsCheckException extends Exception {

    private static final long serialVersionUID = -3448595563459658126L;

    /**
     * 异常编码
     */
    private int code = ResponseCode.UNKNOWN_ERROR.getCode();

    /**
     * 异常信息
     */
    private String message = ResponseCode.UNKNOWN_ERROR.getMsg();

    public ParamsCheckException(){
        super();
    }

    public ParamsCheckException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ParamsCheckException(String message){
        this.message = message;
    }

    public ParamsCheckException(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.message = responseCode.getMsg();
    }

}

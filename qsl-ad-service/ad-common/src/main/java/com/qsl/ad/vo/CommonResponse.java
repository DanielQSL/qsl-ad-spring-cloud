package com.qsl.ad.vo;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author DanielQSL
 * @date 2019/5/20
 */
@Getter
public class CommonResponse<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    private CommonResponse(Integer code) {
        this.code = code;
    }

    private CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private CommonResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    private CommonResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> createBySuccess() {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> CommonResponse<T> createBySuccessMessage(String msg) {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> CommonResponse<T> createBySuccess(T data) {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> CommonResponse<T> createBySuccess(String msg, T data) {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> CommonResponse<T> createByError() {
        return new CommonResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> CommonResponse<T> createByErrorMessage(String errorMessage) {
        return new CommonResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> CommonResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new CommonResponse<T>(errorCode, errorMessage);
    }

    public static <T> CommonResponse<T> createByErrorCodeMessageData(int errorCode, String errorMessage, T data) {
        return new CommonResponse<T>(errorCode, errorMessage, data);
    }
}

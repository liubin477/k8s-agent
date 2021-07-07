package com.lb.k8s.api.model;

import java.io.Serializable;

/**
 * @Class: R
 * @Desc: 公共返回结果
 * @Author: liubin
 * @Date: 2021/7/7
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int RESULT_STATUS_SUCCESS = 0;
    private static final int RESULT_STATUS_FAIL = 1;
    private static final String RESULT_MESSAGE_SUCCESS = "操作成功！";
    private static final String RESULT_MESSAGE_FAIL = "操作失败！";

    private int status;

    private String message;

    private T data;

    public int getStatus() {
        return status;
    }

    public R<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public R<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> R<T> ok() {
        return restResult(RESULT_STATUS_SUCCESS, RESULT_MESSAGE_SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(RESULT_STATUS_SUCCESS, RESULT_MESSAGE_SUCCESS, data);
    }

    public static <T> R<T> fail() {
        return restResult(RESULT_STATUS_FAIL, RESULT_MESSAGE_FAIL, null);
    }

    public static <T> R<T> fail(String message) {
        return restResult(RESULT_STATUS_FAIL, message, null);
    }

    private static <T> R<T> restResult(int status, String message, T data) {
        R<T> result = new R<>();
        result.setStatus(status);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}

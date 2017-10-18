package com.kkk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * RESTful统一返回格式
 * Create By z3jjlzt on 2017/10/17
 */
@Data
public class ResultBean implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 100;
    public static final int FAIL = 200;

    private int code;
    private String msg;

    private Map<String, Object> result = new HashMap<>();

    public ResultBean() {
    }

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultBean success() {
        return new ResultBean(SUCCESS, "处理成功");
    }

    public static ResultBean fail() {
        return new ResultBean(FAIL, "处理失败");
    }

    public final ResultBean put(String key, Object value) {
        this.result.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}

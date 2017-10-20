package com.kkk.exception;

/**
 * 统一业务异常
 * Create By z3jjlzt on 2017/10/20
 */
public class BusinessExceptin extends RuntimeException{

    private static final long servialVersionUID = 1L;

    public BusinessExceptin() {
    }

    public BusinessExceptin(String message) {
        super(message);
    }

    public BusinessExceptin(Throwable cause) {
        super(cause);
    }
}

package com.example.exception;

/**
 * Created by steadyjack on 2017/3/22.
 */
public class UserException extends Throwable {

    private final String reason="发生异常";

    public UserException(String message) {
        super(message);
    }
}

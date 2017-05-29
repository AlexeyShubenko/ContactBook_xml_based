package com.test.javaproject.exceptions;

/**
 * Created by Alexey on 22.05.2017.
 */
public class UserNotFindException extends RuntimeException {

    public UserNotFindException(String message){
        super(message);
    }

}

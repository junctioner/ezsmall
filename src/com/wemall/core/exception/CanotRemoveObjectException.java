package com.wemall.core.exception;


public class CanotRemoveObjectException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public void printStackTrace(){
        System.out.println("鍒犻櫎瀵硅薄阌栾!");
        super.printStackTrace();
    }
}
package com.wemall.core.tools.bean;

/**
 * Created by John on 2016/1/13.
 */
public class WxToken {
    // 鎺ュ彛璁块棶鍑瘉
    private String accessToken;
    // 鍑瘉链夋晥链燂紝鍗曚綅锛氱
    private int expiresIn;

    public String getAccessToken(){
        return accessToken;
    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public int getExpiresIn(){
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn){
        this.expiresIn = expiresIn;
    }
}

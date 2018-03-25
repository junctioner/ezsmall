package com.wemall.core.tools.bean;

/**
 * Created by John on 2016/1/13.
 */
public class WxOauth2Token {
    // 缃戦〉鎺堟潈鎺ュ彛璋幂敤鍑瘉
    private String accessToken;
    // 鍑瘉链夋晥镞堕昵
    private int expiresIn;
    // 鐢ㄤ簬鍒锋柊鍑瘉
    private String refreshToken;
    // 鐢ㄦ埛镙囱瘑
    private String openId;
    // 鐢ㄦ埛鎺堟潈浣灭敤鍩?
    private String scope;

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

    public String getRefreshToken(){
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public String getOpenId(){
        return openId;
    }

    public void setOpenId(String openId){
        this.openId = openId;
    }

    public String getScope(){
        return scope;
    }

    public void setScope(String scope){
        this.scope = scope;
    }
}

package com.wemall.core.tools.bean;

/**
 * Created by John on 2016/1/13.
 */
public class WxUserInfo {
    // 鐢ㄦ埛镄勬爣璇?
    private String openId;
    // 鍏虫敞钟舵€侊纸1鏄叧娉紝0鏄湭鍏虫敞锛夛紝链叧娉ㄦ椂銮峰彇涓嶅埌鍏朵綑淇℃伅
    private int subscribe;
    // 鐢ㄦ埛鍏虫敞镞堕棿锛屼负镞堕棿鎴炽€傚鏋灭敤鎴锋浘澶氭鍏虫敞锛屽垯鍙栨渶鍚庡叧娉ㄦ椂闂?
    private String subscribeTime;
    // 鏄电О
    private String nickname;
    // 鐢ㄦ埛镄勬€у埆锛?鏄敺镐э紝2鏄コ镐э紝0鏄湭鐭ワ级
    private int sex;
    // 鐢ㄦ埛镓€鍦ㄥ浗瀹?
    private String country;
    // 鐢ㄦ埛镓€鍦ㄧ渷浠?
    private String province;
    // 鐢ㄦ埛镓€鍦ㄥ煄甯?
    private String city;
    // 鐢ㄦ埛镄勮瑷€锛岀亩浣扑腑鏂囦负zh_CN
    private String language;
    // 鐢ㄦ埛澶村儚
    private String headImgUrl;

    public String getOpenId(){
        return openId;
    }

    public void setOpenId(String openId){
        this.openId = openId;
    }

    public int getSubscribe(){
        return subscribe;
    }

    public void setSubscribe(int subscribe){
        this.subscribe = subscribe;
    }

    public String getSubscribeTime(){
        return subscribeTime;
    }

    public void setSubscribeTime(String subscribeTime){
        this.subscribeTime = subscribeTime;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public int getSex(){
        return sex;
    }

    public void setSex(int sex){
        this.sex = sex;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getProvince(){
        return province;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getLanguage(){
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public String getHeadImgUrl(){
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl){
        this.headImgUrl = headImgUrl;
    }
}

package com.wemall.core.tools.bean;

import java.util.List;

/**
 * Created by John on 2016/1/13.
 */
public class SNSUserInfo {
    // 鐢ㄦ埛镙囱瘑
    private String openId;
    // 鐢ㄦ埛鏄电О
    private String nickname;
    // 镐у埆锛?鏄敺镐э紝2鏄コ镐э紝0鏄湭鐭ワ级
    private int sex;
    // 锲藉
    private String country;
    // 鐪佷唤
    private String province;
    // 鍩庡竞
    private String city;
    // 鐢ㄦ埛澶村儚阈炬帴
    private String headImgUrl;
    // 鐢ㄦ埛鐗规潈淇℃伅
    private List<String> privilegeList;

    public String getOpenId(){
        return openId;
    }

    public void setOpenId(String openId){
        this.openId = openId;
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

    public String getHeadImgUrl(){
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl){
        this.headImgUrl = headImgUrl;
    }

    public List<String> getPrivilegeList(){
        return privilegeList;
    }

    public void setPrivilegeList(List<String> privilegeList){
        this.privilegeList = privilegeList;
    }
}

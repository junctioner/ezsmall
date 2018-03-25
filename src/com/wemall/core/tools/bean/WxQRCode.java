package com.wemall.core.tools.bean;

/**
 * Created by John on 2016/1/13.
 */
public class WxQRCode {
    // 銮峰彇镄勪簩缁寸爜ticket
    private String ticket;
    // 浜岀淮镰佺殑链夋晥镞堕棿锛屽崟浣崭负绉掞紝链€澶т笉瓒呰绷1800
    private int expireSeconds;

    public String getTicket(){
        return ticket;
    }

    public void setTicket(String ticket){
        this.ticket = ticket;
    }

    public int getExpireSeconds(){
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds){
        this.expireSeconds = expireSeconds;
    }
}

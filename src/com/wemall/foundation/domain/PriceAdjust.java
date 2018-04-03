package com.wemall.foundation.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 
 * Description: 商品调价记录<br/>
 * date: 2018年4月3日 下午2:43:17 <br/>
 *
 * @author yanL
 * @version
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_price_adjust")
public class PriceAdjust extends IdEntity {

    // 商品分类
    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsClass goodclass;

    // 颜色
    @ManyToOne(fetch = FetchType.LAZY)
    private Dict color;

    // 形态
    @ManyToOne(fetch = FetchType.LAZY)
    private Dict form;

    // 商品用途
    private String purpose;

    // 商品密度min
    private String density1;

    // 商品密度max
    private String density2;

    // 悬臂梁缺口冲击min
    private String cantilever1;

    // 悬臂梁缺口冲击max
    private String cantilever2;

    // 简支梁渠口冲击min
    private String freely1;

    // 简支梁渠口冲击max
    private String freely2;

    // 调整方向
    private String direction;

    // 调整幅度
    private String range;

    // 申请人
    @ManyToOne(fetch = FetchType.LAZY)
    private User proposer;

    // 申请时间
    private Date proposerTime;

    // 审批人
    @ManyToOne(fetch = FetchType.LAZY)
    private User approve;

    // 审批时间
    private Date approveTime;

    // 审批状态
    private String state;

    // 拒绝原因
    private String reason;

    public GoodsClass getGoodclass() {
        return goodclass;
    }

    public void setGoodclass(GoodsClass goodclass) {
        this.goodclass = goodclass;
    }

    public Dict getColor() {
        return color;
    }

    public void setColor(Dict color) {
        this.color = color;
    }

    public Dict getForm() {
        return form;
    }

    public void setForm(Dict form) {
        this.form = form;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDensity1() {
        return density1;
    }

    public void setDensity1(String density1) {
        this.density1 = density1;
    }

    public String getDensity2() {
        return density2;
    }

    public void setDensity2(String density2) {
        this.density2 = density2;
    }

    public String getCantilever1() {
        return cantilever1;
    }

    public void setCantilever1(String cantilever1) {
        this.cantilever1 = cantilever1;
    }

    public String getCantilever2() {
        return cantilever2;
    }

    public void setCantilever2(String cantilever2) {
        this.cantilever2 = cantilever2;
    }

    public String getFreely1() {
        return freely1;
    }

    public void setFreely1(String freely1) {
        this.freely1 = freely1;
    }

    public String getFreely2() {
        return freely2;
    }

    public void setFreely2(String freely2) {
        this.freely2 = freely2;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public User getProposer() {
        return proposer;
    }

    public void setProposer(User proposer) {
        this.proposer = proposer;
    }

    public Date getProposerTime() {
        return proposerTime;
    }

    public void setProposerTime(Date proposerTime) {
        this.proposerTime = proposerTime;
    }

    public User getApprove() {
        return approve;
    }

    public void setApprove(User approve) {
        this.approve = approve;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "PriceAdjust [goodclass=" + goodclass + ", color=" + color + ", form=" + form + ", purpose=" + purpose
                + ", density1=" + density1 + ", density2=" + density2 + ", cantilever1=" + cantilever1
                + ", cantilever2=" + cantilever2 + ", freely1=" + freely1 + ", freely2=" + freely2 + ", direction="
                + direction + ", range=" + range + ", proposer=" + proposer + ", proposerTime=" + proposerTime
                + ", approve=" + approve + ", approveTime=" + approveTime + ", state=" + state + ", reason=" + reason
                + "]";
    }

}
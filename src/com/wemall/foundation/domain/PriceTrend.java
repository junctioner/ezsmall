package com.wemall.foundation.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.wemall.core.domain.IdEntity;

/**
 * @author Administrator
 * wangxioa
 */

@Entity
@Table(name = "ezs_price_trend")
public class PriceTrend extends IdEntity {
	private int data_sources;// 数据来源 
	private int type ;//类型
	@ManyToOne(fetch = FetchType.LAZY)
	private Area region;// 地区
	private  String  specification;// 规格  （品类颜色和形状）
	private double price;// 交易单价
	private String procurement_standard;// 采购标准
	private String source;// 来源公司或者个人
	private  String source_tel;// 来源公司或者个人  电话
	private String density;// 商品密度
	private String cantilever;// 悬臂梁缺口冲击
	private String freely;// j简支梁渠口冲击
	private String lipolysis;// 溶脂
	private String ash;// 灰分
	private String water;// 水分
	private String tensile;// 拉伸强度
	private String crack;// 断裂伸长率
	private String bending;// 弯曲强度
	private String flexural;// 弯曲模量
	private String burning;// 燃烧等级
	private boolean protection;// 是否环保
	private String  date_from;// 来源
	private String purpose;// 用途
	private String content;// 备注
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;// 客户
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodsClass goodClass;// 商品分类
	public int getData_sources() {
		return data_sources;
	}
	public void setData_sources(int data_sources) {
		this.data_sources = data_sources;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Area getRegion() {
		return region;
	}
	public void setRegion(Area region) {
		this.region = region;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProcurement_standard() {
		return procurement_standard;
	}
	public void setProcurement_standard(String procurement_standard) {
		this.procurement_standard = procurement_standard;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSource_tel() {
		return source_tel;
	}
	public void setSource_tel(String source_tel) {
		this.source_tel = source_tel;
	}
	public String getDensity() {
		return density;
	}
	public void setDensity(String density) {
		this.density = density;
	}
	public String getCantilever() {
		return cantilever;
	}
	public void setCantilever(String cantilever) {
		this.cantilever = cantilever;
	}
	public String getFreely() {
		return freely;
	}
	public void setFreely(String freely) {
		this.freely = freely;
	}
	public String getLipolysis() {
		return lipolysis;
	}
	public void setLipolysis(String lipolysis) {
		this.lipolysis = lipolysis;
	}
	public String getAsh() {
		return ash;
	}
	public void setAsh(String ash) {
		this.ash = ash;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getTensile() {
		return tensile;
	}
	public void setTensile(String tensile) {
		this.tensile = tensile;
	}
	public String getCrack() {
		return crack;
	}
	public void setCrack(String crack) {
		this.crack = crack;
	}
	public String getBending() {
		return bending;
	}
	public void setBending(String bending) {
		this.bending = bending;
	}
	public String getFlexural() {
		return flexural;
	}
	public void setFlexural(String flexural) {
		this.flexural = flexural;
	}
	public String getBurning() {
		return burning;
	}
	public void setBurning(String burning) {
		this.burning = burning;
	}
	public boolean isProtection() {
		return protection;
	}
	public void setProtection(boolean protection) {
		this.protection = protection;
	}
	public String getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public GoodsClass getGoodClass() {
		return goodClass;
	}
	public void setGoodClass(GoodsClass goodClass) {
		this.goodClass = goodClass;
	}

	

}

package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 鍟嗗搧
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods")
public class Goods extends IdEntity {
	private String good_no;// 鍟嗗搧缂栧佛
	private String name;// 鍟嗗搧鍚岖О
	private double price;// 鍟嗗搧鍗曚环
	private int validity;// 鍟嗗搧链夋晥链?
	private double inventory;// 鍟嗗搧搴揿瓨閲?
	@ManyToOne(fetch = FetchType.LAZY)
	private Area area;// 鍟嗗搧搴揿瓨鍖哄幙
	private String addess;// 搴揿瓨镓€鍦ㄥ湴
	private String seo_description;// 鍟嗗搧SEO鎻忚堪
	private String keyword;// 鍟嗗搧鎼灭储鍏抽敭瀛?
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict util;// 鍗曚綅
	private boolean recommend;// 鏄惁鎺ㄨ崘
	private Date recommend_time;// 鎺ㄨ崘镞ユ湡
	private int click;// 鍟嗗搧镣瑰向閲?
	private int collect;// 鍟嗗搧鏀惰棌閲?
	private int status;// 鍟嗗搧钟舵€?
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict logistics;// 鐗╂祦鏂瑰纺
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict supply;// 渚涜揣鏂瑰纺
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict color;// 棰滆壊
	@ManyToOne(fetch = FetchType.LAZY)
	private Area region;// 鍦板尯
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict form;// 褰㈡€?
	private String source;// 鏉ユ簮
	private String purpose;// 鍟嗗搧鐢ㄩ€?
	private String density;// 鍟嗗搧瀵嗗害
	private String cantilever;// 镇哕姊佺己鍙ｅ啿鍑?
	private String lipolysis;// 婧惰刚
	private String ash;// 鐏板垎
	private String freely;// j绠€鏀娓犲彛鍐插向
	private String water;// 姘村垎
	private String tensile;// 鎷変几寮哄害
	private String crack;// 鏂浼搁昵鐜?
	private String bending;// 寮洸寮哄害
	private String flexural;// 寮洸妯￠噺
	private String burning;// 鐕幂儳绛夌骇
	private boolean protection;// 鏄惁鐜缭
	private String content;// 鎻忚堪
	private double cncl_num;// 镙峰搧搴揿瓨
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;// 鍙戝竷浜?
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodClass goodClass;// 鍟嗗搧鍒嗙被
	@ManyToOne(fetch = FetchType.LAZY)
	private Quality quality;// 璐ㄦ
	@ManyToOne(cascade = { javax.persistence.CascadeType.REMOVE })
	private Accessory goods_main_photo;// 涓诲浘鐗?
	private boolean memberLook;// 鏄惁浼氩憳镆ョ湅
	private int goods_salenum;//阌€閲忔暟
	// 镦х墖
	@ManyToMany
	@JoinTable(name = "ezs_goods_photo", joinColumns = {
			@javax.persistence.JoinColumn(name = "goods_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "photo_id") })
	private List<Accessory> goods_photos = new ArrayList<Accessory>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public double getInventory() {
		return inventory;
	}

	public void setInventory(double inventory) {
		this.inventory = inventory;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAddess() {
		return addess;
	}

	public void setAddess(String addess) {
		this.addess = addess;
	}

	public String getSeo_description() {
		return seo_description;
	}

	public void setSeo_description(String seo_description) {
		this.seo_description = seo_description;
	}

	public Dict getUtil() {
		return util;
	}

	public void setUtil(Dict util) {
		this.util = util;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public Date getRecommend_time() {
		return recommend_time;
	}

	public void setRecommend_time(Date recommend_time) {
		this.recommend_time = recommend_time;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public int getCollect() {
		return collect;
	}

	public void setCollect(int collect) {
		this.collect = collect;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Dict getLogistics() {
		return logistics;
	}

	public void setLogistics(Dict logistics) {
		this.logistics = logistics;
	}

	public Dict getSupply() {
		return supply;
	}

	public void setSupply(Dict supply) {
		this.supply = supply;
	}

	public Dict getColor() {
		return color;
	}

	public void setColor(Dict color) {
		this.color = color;
	}

	public Area getRegion() {
		return region;
	}

	public void setRegion(Area region) {
		this.region = region;
	}

	public Dict getForm() {
		return form;
	}

	public void setForm(Dict form) {
		this.form = form;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public String getFreely() {
		return freely;
	}

	public void setFreely(String freely) {
		this.freely = freely;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getCncl_num() {
		return cncl_num;
	}

	public void setCncl_num(double cncl_num) {
		this.cncl_num = cncl_num;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGood_no() {
		return good_no;
	}

	public void setGood_no(String good_no) {
		this.good_no = good_no;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public Accessory getGoods_main_photo() {
		return goods_main_photo;
	}

	public void setGoods_main_photo(Accessory goods_main_photo) {
		this.goods_main_photo = goods_main_photo;
	}

	public List<Accessory> getGoods_photos() {
		return goods_photos;
	}

	public void setGoods_photos(List<Accessory> goods_photos) {
		this.goods_photos = goods_photos;
	}


	public GoodClass getGoodClass() {
		return goodClass;
	}

	public void setGoodClass(GoodClass goodClass) {
		this.goodClass = goodClass;
	}

	public boolean isMemberLook() {
		return memberLook;
	}

	public void setMemberLook(boolean memberLook) {
		this.memberLook = memberLook;
	}

	public int getGoods_salenum() {
		return goods_salenum;
	}

	public void setGoods_salenum(int goods_salenum) {
		this.goods_salenum = goods_salenum;
	}

}

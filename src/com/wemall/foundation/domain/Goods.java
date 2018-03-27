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
 * 商品
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods")
public class Goods extends IdEntity {
	private String good_no;// 商品编号
	private String name;// 商品名称
	private double price;// 商品单价
	private int validity;// 商品有效期
	private double inventory;// 商品库存量
	@ManyToOne(fetch = FetchType.LAZY)
	private Area area;// 商品库存区县
	private String addess;// 库存所在地
	private String seo_description;// 商品SEO描述
	private String keyword;// 商品搜索关键字
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict util;// 单位
	private boolean recommend;// 是否推荐
	private Date recommend_time;// 推荐日期
	private int click;// 商品点击量
	private int collect;// 商品收藏量
	private int status;// 商品状态 2.正常上架
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict logistics;// 物流方式 
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict supply;// 供货方式
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict color;// 颜色 
	@ManyToOne(fetch = FetchType.LAZY)
	private Area region;// 地区
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict form;// 形态
	private String source;// 来源
	private String purpose;// 商品用途
	private String density;// 商品密度
	private String cantilever;// 悬臂梁缺口冲击
	private String lipolysis;// 溶脂
	private String ash;// 灰分
	private String freely;// j简支梁渠口冲击
	private String water;// 水分
	private String tensile;// 拉伸强度
	private String crack;// 断裂伸长率
	private String bending;// 弯曲强度
	private String flexural;// 弯曲模量
	private String burning;// 燃烧等级
	private boolean protection;// 是否环保
	private String content;// 描述
	private double cncl_num;// 样品库存
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;// 发布人
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodsClass goodClass;// 商品分类
	@ManyToOne(fetch = FetchType.LAZY)
	private Quality quality;// 质检
	@ManyToOne(cascade = { javax.persistence.CascadeType.REMOVE })
	private Accessory goods_main_photo;// 主图片
	private boolean memberLook;// 是否会员查看
	private int goods_salenum;//销量数
	// 照片
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


	public GoodsClass getGoodClass() {
		return goodClass;
	}

	public void setGoodClass(GoodsClass goodClass) {
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

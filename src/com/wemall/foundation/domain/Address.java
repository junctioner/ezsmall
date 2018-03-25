package com.wemall.foundation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 鏀惰揣鍦板潃
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_address")
public class Address extends IdEntity{
	private String trueName;
	// 鍦板尯
	@ManyToOne(fetch = FetchType.LAZY)
	private Area area;
	// 鍦板潃淇℃伅
	private String area_info;
	// 闾紪
	private String zip;
	// 鐢佃瘽
	private String telephone;
	// 镓嬫満
	private String mobile;
	// 鏄惁榛樿浣跨敤
	@Column(columnDefinition = "bit default false")
	private boolean bestow;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getArea_info() {
		return area_info;
	}

	public void setArea_info(String area_info) {
		this.area_info = area_info;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isBestow() {
		return bestow;
	}

	public void setBestow(boolean bestow) {
		this.bestow = bestow;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

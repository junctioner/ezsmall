package com.wemall.foundation.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 鐢ㄦ埛鏄庣粏
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_userinfo")
public class UserInfo extends IdEntity {
	private String email;// 鐢ㄦ埛闾
	private String phone;// 鐢ㄦ埛鐢佃瘽鍙风爜
	private Date entryTime;// 鍏ヨ亴镞堕棿
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict sex;// 镐у埆
	@Column(columnDefinition = "int default 0")
	private Integer status;// 鐢ㄦ埛钟舵€?
	@Column(columnDefinition = "bit default false")
	private Boolean enable;// 鏄惁鍚敤
	@ManyToOne(fetch = FetchType.LAZY)
	private Depart depart;// 閮ㄩ棬
	@ManyToOne(fetch = FetchType.LAZY)
	private Position position;// 鑱屼綅

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Dict getSex() {
		return sex;
	}

	public void setSex(Dict sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}

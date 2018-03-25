package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_group")
public class Group extends IdEntity {
	// 瀹㈡埗鍒嗙粍鍚岖О
	private String name;
	// 瑙掕壊鍗栧銆佷拱瀹?
	private String role;
	// 瀹㈡埗钟舵€侊纸0.绾跨储锛?.娉ㄥ唽锛?.璁よ瘉锛?.婵€娲伙级
	private int cus_status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCus_status() {
		return cus_status;
	}

	public void setCus_status(int cus_status) {
		this.cus_status = cus_status;
	}

}

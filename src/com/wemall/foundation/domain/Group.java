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
	// 客戶分组名称
	private String name;
	// 角色卖家、买家
	private String role;
	// 客戶状态（0.线索，1.注册，2.认证，3.激活）
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

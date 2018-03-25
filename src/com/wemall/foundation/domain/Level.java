package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 瀹㈡埛鐧昏
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_Level")
public class Level extends IdEntity {
	// 鍚岖О
	private String name;
	// 绾у埆
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict grade;
	// 瀹㈡埗钟舵€?
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict cus_status;
	// 鏄惁榛樿獚
	private boolean initial;
	// 鏄惁鍚敤
	private boolean enable;
	// 涔板銆佸岽瀹?
	private String role;
	// 鎻忚堪
	private String msg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dict getGrade() {
		return grade;
	}

	public void setGrade(Dict grade) {
		this.grade = grade;
	}

	public Dict getCus_status() {
		return cus_status;
	}

	public void setCus_status(Dict cus_status) {
		this.cus_status = cus_status;
	}

	public boolean isInitial() {
		return initial;
	}

	public void setInitial(boolean initial) {
		this.initial = initial;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

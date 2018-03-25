package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 绾跨储鏉ユ簮
 * @author 鍒樻亽绂?
 *
 */

import com.wemall.core.domain.IdEntity;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_source")
public class Source extends IdEntity {
	// 鍚岖О
	private String name;
	// 镙囱瘑
	private String identifying;
	//鎻忚堪
	private String msg;
	//鏄惁鍚敤
	private boolean enable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifying() {
		return identifying;
	}
	public void setIdentifying(String identifying) {
		this.identifying = identifying;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}

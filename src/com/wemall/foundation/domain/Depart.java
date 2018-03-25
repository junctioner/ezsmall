package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 閮ㄩ棬
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_depart")
public class Depart extends IdEntity {
	private String name;// 閮ㄩ棬鍚岖О
	@ManyToOne(fetch = FetchType.LAZY)
	private Depart parent;//鐖剁被閮ㄩ棬
	@ManyToOne(fetch = FetchType.LAZY)
	private Store store;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Depart getParent() {
		return parent;
	}
	public void setParent(Depart parent) {
		this.parent = parent;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	

}

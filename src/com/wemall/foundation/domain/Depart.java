package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 部门
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_depart")
public class Depart extends IdEntity {
	// 部门名称
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	// 父类部门
	private Depart parent;
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

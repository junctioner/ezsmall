package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 鍟嗗搧绫诲瀷
 * @author lianfu
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods_class")
public class GoodClass extends IdEntity {
	private String name;// 鍟嗗搧鍒嗙被鍚岖О
	@ManyToOne(fetch = FetchType.LAZY)
	private Accessory photo;// 鍟嗗搧鍒嗙被锲剧墖
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodClass parent;// 鍟嗗搧绫诲瀷鐖剁被

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Accessory getPhoto() {
		return photo;
	}

	public void setPhoto(Accessory photo) {
		this.photo = photo;
	}

	public GoodClass getParent() {
		return parent;
	}

	public void setParent(GoodClass parent) {
		this.parent = parent;
	}

}

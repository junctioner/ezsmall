package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 商品类型
 * @author lianfu
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods_class")
public class GoodClass extends IdEntity {
	private String name;// 商品分类名称
	@ManyToOne(fetch = FetchType.LAZY)
	private Accessory photo;// 商品分类图片
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodClass parent;// 商品类型父类

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

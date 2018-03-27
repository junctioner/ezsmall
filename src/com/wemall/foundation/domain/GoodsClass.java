package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 商品类型
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods_class")
public class GoodsClass extends IdEntity {
	private String name;// 商品分类名称
	@ManyToOne(fetch = FetchType.LAZY)
	private Accessory photo;// 商品分类图片
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodsClass parent;// 商品类型父类
	// 地区子类
	@OneToMany(mappedBy = "parent", cascade = { javax.persistence.CascadeType.REMOVE })
	private List<GoodsClass> childs = new ArrayList<GoodsClass>();
	// 排序字段
	private int sequence;

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

	public GoodsClass getParent() {
		return parent;
	}

	public void setParent(GoodsClass parent) {
		this.parent = parent;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public List<GoodsClass> getChilds() {
		return childs;
	}

	public void setChilds(List<GoodsClass> childs) {
		this.childs = childs;
	}

	

}

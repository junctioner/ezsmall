package com.wemall.foundation.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 购物表
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goodscart")
public class GoodsCart extends IdEntity {
	// 商品
	@OneToOne
	private Goods goods;
	// 数量
	private int count;
	// 价格
	@Column(precision = 12, scale = 2)
	private BigDecimal price;
	@ManyToOne(fetch = FetchType.LAZY)
	private OrderForm of;// 订单
	private String cart_type;// 购物车类型
	// 店铺购物车
	@ManyToOne(fetch = FetchType.LAZY)
	private StoreCart sc;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public OrderForm getOf() {
		return of;
	}

	public void setOf(OrderForm of) {
		this.of = of;
	}

	public String getCart_type() {
		return cart_type;
	}

	public void setCart_type(String cart_type) {
		this.cart_type = cart_type;
	}

	public StoreCart getSc() {
		return sc;
	}

	public void setSc(StoreCart sc) {
		this.sc = sc;
	}

}

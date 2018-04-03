package com.wemall.foundation.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 供应商商品审核流程表
 * 
 * @author tumin
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods_audit_process")
public class GoodsAuditProcess extends IdEntity {

	// 商品(包含供应商信息，样品信息，质检信息)
	@ManyToOne(fetch = FetchType.LAZY)
	private Goods goods;

	// 商品id
	private Long goodsId;

	// 供应价 supply
	private BigDecimal supplyPrice;

	// 销售价
	private BigDecimal salePrice;

	@Override
	public String toString() {
		return "GoodsAuditProcess [goods=" + goods + ", goodsId=" + goodsId
				+ ", supplyPrice=" + supplyPrice + ", salePrice=" + salePrice
				+ "]";
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public BigDecimal getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(BigDecimal supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

}

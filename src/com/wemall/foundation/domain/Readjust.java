package com.wemall.foundation.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 *  璋冧环
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_readjust")
public class Readjust extends IdEntity {
	// 璁㈠崟璇︽儏
	@ManyToOne
	private OrderForm orderForm;
	// 璋冧环閲戦
	private BigDecimal price;
	// 璋冧环铡熷洜
	@ManyToOne
	private Dict cause;
	// 涓娄紶鍑嵁
	@ManyToOne
	private Accessory proof;
	//鎻忚堪
	private String msg;
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Dict getCause() {
		return cause;
	}
	public void setCause(Dict cause) {
		this.cause = cause;
	}
	public Accessory getProof() {
		return proof;
	}
	public void setProof(Accessory proof) {
		this.proof = proof;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * @author Administrator
 * wangxioa
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_comment")
public class Comment extends IdEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;// 操作人
	private  String  intention; // 意向  （偏高  偏低）

	private double price;//  意向价格
	@ManyToOne(fetch = FetchType.LAZY)
	private PriceTrend priceTrend;// 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIntention() {
		return intention;
	}
	public void setIntention(String intention) {
		this.intention = intention;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public PriceTrend getPriceTrend() {
		return priceTrend;
	}
	public void setPriceTrend(PriceTrend priceTrend) {
		this.priceTrend = priceTrend;
	}
	
	

}

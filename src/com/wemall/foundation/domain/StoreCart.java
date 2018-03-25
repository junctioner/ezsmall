package com.wemall.foundation.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 鍟嗗簵璩肩墿杌?
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_storeCart")
public class StoreCart extends IdEntity {

	// 搴楅摵
	@ManyToOne
	private Store store;

	// 鍟嗗搧杩愰€?
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sc")
	private List<GoodsCart> gcs = new ArrayList<GoodsCart>();
	// 镐讳环
	private BigDecimal total_price;

	// 鐢ㄦ埛
	@ManyToOne
	private User user;
	// 杩愰€佷细璇滻D
	private String cart_session_id;

	// 杩愰€佺姸镐?
	@Column(columnDefinition = "int default 0")
	private int sc_status;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<GoodsCart> getGcs() {
		return gcs;
	}

	public void setGcs(List<GoodsCart> gcs) {
		this.gcs = gcs;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCart_session_id() {
		return cart_session_id;
	}

	public void setCart_session_id(String cart_session_id) {
		this.cart_session_id = cart_session_id;
	}

	public int getSc_status() {
		return sc_status;
	}

	public void setSc_status(int sc_status) {
		this.sc_status = sc_status;
	}
	
}

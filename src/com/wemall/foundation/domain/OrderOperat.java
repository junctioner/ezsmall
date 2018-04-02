package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 订单操作记录
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_order_operat")
public class OrderOperat extends IdEntity {
	@ManyToOne
	private Dict OperatStatus;
	@ManyToOne
	private User user;
	@ManyToOne
	private OrderForm orderForm;
	public Dict getOperatStatus() {
		return OperatStatus;
	}
	public void setOperatStatus(Dict operatStatus) {
		OperatStatus = operatStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	
}

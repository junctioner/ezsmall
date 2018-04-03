package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 退订单操作记录
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_retrun_order_operat")
public class RetrunOrderOperat extends IdEntity {
	@ManyToOne
	private Dict OperatStatus;
	@ManyToOne
	private User user;
	@ManyToOne
	private ReturnGood returnGood;

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

	public ReturnGood getReturnGood() {
		return returnGood;
	}

	public void setReturnGood(ReturnGood returnGood) {
		this.returnGood = returnGood;
	}

}

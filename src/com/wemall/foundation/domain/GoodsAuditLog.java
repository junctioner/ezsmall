package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 商品审核日志表
 * 
 * @author tumin
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_goods_audit_log")
public class GoodsAuditLog extends IdEntity {

	// 商品审核id
	private Long goodsAuditId;

	// 操作员id
	private Long userId;

	// 操作员
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	// 操作id
	private int actionId;
	
	//备注
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public Long getGoodsAuditId() {
		return goodsAuditId;
	}

	public void setGoodsAuditId(Long goodsAuditId) {
		this.goodsAuditId = goodsAuditId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

}

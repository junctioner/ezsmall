package com.wemall.foundation.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 寮€绁ㄤ俊鎭?
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_invoice")
public class Invoice extends IdEntity {
	private String express_name;// 闾瘎鏂瑰纺
	private String express_no;// 蹇€掑佛
	private Date express_time;// 寮€绁ㄦ椂闂?
	private int invoice_status;// 寮€绁ㄧ姸镐?
	@ManyToOne(fetch = FetchType.LAZY)
	private Accessory receipt;// 绁ㄦ嵁
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public String getExpress_name() {
		return express_name;
	}

	public void setExpress_name(String express_name) {
		this.express_name = express_name;
	}

	public String getExpress_no() {
		return express_no;
	}

	public void setExpress_no(String express_no) {
		this.express_no = express_no;
	}

	public Date getExpress_time() {
		return express_time;
	}

	public void setExpress_time(Date express_time) {
		this.express_time = express_time;
	}

	public int getInvoice_status() {
		return invoice_status;
	}

	public void setInvoice_status(int invoice_status) {
		this.invoice_status = invoice_status;
	}

	public Accessory getReceipt() {
		return receipt;
	}

	public void setReceipt(Accessory receipt) {
		this.receipt = receipt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

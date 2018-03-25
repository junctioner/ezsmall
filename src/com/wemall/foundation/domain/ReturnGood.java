package com.wemall.foundation.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 阃€鍗?
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_returm_good")
public class ReturnGood extends IdEntity {
	// 阃€鍗旷紪鍙?
	private String retrun_good_no;
	// 璁㈠崟璇︽儏
	@OneToOne
	private OrderForm orderForm;
	// 鐢宠阃€鍗曟椂闂?
	private Date sappy_time;
	// 阃€璐х姸镐?
	private int retrun_status;
	// 阃€璐ф暟閲?
	private double retrun_num;
	// 阃€璐ч噾棰?
	private BigDecimal price;
	// 阃€璐у师锲?
	@ManyToOne
	private Dict why;
	// 琛ュ厖璇存槑
	private String explain;
	// 澶勭悊钟舵€?
	private int process_state;
	// 阃€璐ц
	private String retrun_bank;
	// 阃€璐у嚟璇?
	@ManyToOne
	private Accessory voucher;
	// 澶勭悊浜?
	private User user;
	public String getRetrun_good_no() {
		return retrun_good_no;
	}
	public void setRetrun_good_no(String retrun_good_no) {
		this.retrun_good_no = retrun_good_no;
	}
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	public Date getSappy_time() {
		return sappy_time;
	}
	public void setSappy_time(Date sappy_time) {
		this.sappy_time = sappy_time;
	}
	public int getRetrun_status() {
		return retrun_status;
	}
	public void setRetrun_status(int retrun_status) {
		this.retrun_status = retrun_status;
	}
	public double getRetrun_num() {
		return retrun_num;
	}
	public void setRetrun_num(double retrun_num) {
		this.retrun_num = retrun_num;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Dict getWhy() {
		return why;
	}
	public void setWhy(Dict why) {
		this.why = why;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public int getProcess_state() {
		return process_state;
	}
	public void setProcess_state(int process_state) {
		this.process_state = process_state;
	}
	public String getRetrun_bank() {
		return retrun_bank;
	}
	public void setRetrun_bank(String retrun_bank) {
		this.retrun_bank = retrun_bank;
	}
	public Accessory getVoucher() {
		return voucher;
	}
	public void setVoucher(Accessory voucher) {
		this.voucher = voucher;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

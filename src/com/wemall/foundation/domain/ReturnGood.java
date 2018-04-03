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
 * 退单
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_returm_good")
public class ReturnGood extends IdEntity {
	// 退单编号
	private String retrun_good_no;
	// 订单详情
	@OneToOne
	private OrderForm orderForm;
	// 申请退单时间
	private Date sappy_time;
	// 退货状态
	private int retrun_status;
	// 退货数量
	private double retrun_num;
	// 退货金额
	private BigDecimal price;
	// 退货原因
	@ManyToOne
	private Dict why;
	// 补充说明
	private String explain;
	// 处理状态
	private int process_state;
	// 退货行
	private String retrun_bank;
	// 退货凭证
	@ManyToOne
	private Accessory voucher;
	//退单类型
	private String retrun_order_type;
	// 处理人
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
	public String getRetrun_order_type() {
		return retrun_order_type;
	}
	public void setRetrun_order_type(String retrun_order_type) {
		this.retrun_order_type = retrun_order_type;
	}
	
}

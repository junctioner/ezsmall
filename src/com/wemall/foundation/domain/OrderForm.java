package com.wemall.foundation.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 订单信息
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_orderform")
public class OrderForm extends IdEntity {
	// 订单编号
	private String order_no;
	// 订单类型
	private String order_type;
	// 商品运送集合
	@OneToMany(mappedBy = "of")
	List<GoodsCart> gcs = new ArrayList<GoodsCart>();
	// 总价
	private BigDecimal total_price;
	// 用户
	@ManyToOne
	private User user;
	// 运送会话ID
	private String cart_session_id;
	// 运送状态
	@Column(columnDefinition = "int default 0")
	private int sc_status;
	// 支付方式（0.全款，1：首款+尾款，2.线下）
	private int pay_mode;
	// 商品量
	@Column(precision = 12, scale = 2)
	private BigDecimal goods_amount;
	// 信息
	@Lob
	@Column(columnDefinition = "LongText")
	private String msg;
	// 票据
	@ManyToOne
	private Accessory bill;
	private int order_status;// 订单状态
	// 首付款
	private BigDecimal first_price;
	//首付支付时间
	private Date firest_time;
	//尾款支付时间
	private Date end_time;
	// 尾款
	private BigDecimal end_price;
	//全款
	private BigDecimal all_price;
	// 合同编号
	private String pact_no;
	// 合同附件
	@ManyToMany(targetEntity = Accessory.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_order_pact", joinColumns = {
			@javax.persistence.JoinColumn(name = "order_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "pact_id") })
	private List<Accessory> pact_file;
	// 合同状态
	private int pact_status;
	// 收货地址
	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;
	// 订单完成时
	private Date finishtime;
	// 开票信息
	@ManyToOne(fetch = FetchType.LAZY)
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.LAZY)
	private Logistics logistics;

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}



	public List<Accessory> getPact_file() {
		return pact_file;
	}

	public void setPact_file(List<Accessory> pact_file) {
		this.pact_file = pact_file;
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

	public int getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(int pay_mode) {
		this.pay_mode = pay_mode;
	}

	public BigDecimal getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(BigDecimal goods_amount) {
		this.goods_amount = goods_amount;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Accessory getBill() {
		return bill;
	}

	public void setBill(Accessory bill) {
		this.bill = bill;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public BigDecimal getFirst_price() {
		return first_price;
	}

	public void setFirst_price(BigDecimal first_price) {
		this.first_price = first_price;
	}

	public BigDecimal getEnd_price() {
		return end_price;
	}

	public void setEnd_price(BigDecimal end_price) {
		this.end_price = end_price;
	}

	public String getPact_no() {
		return pact_no;
	}

	public void setPact_no(String pact_no) {
		this.pact_no = pact_no;
	}

	public int getPact_status() {
		return pact_status;
	}

	public void setPact_status(int pact_status) {
		this.pact_status = pact_status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

	public List<GoodsCart> getGcs() {
		return gcs;
	}

	public void setGcs(List<GoodsCart> gcs) {
		this.gcs = gcs;
	}

	public Date getFirest_time() {
		return firest_time;
	}

	public void setFirest_time(Date firest_time) {
		this.firest_time = firest_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

}

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
 * 璁㈠崟淇℃伅
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_orderform")
public class OrderForm extends IdEntity {
	// 璁㈠崟缂栧佛
	private String order_no;
	// 璁㈠崟绫诲瀷
	private String order_type;
	// 鍟嗗搧杩愰€侀泦鍚?
	@OneToMany(mappedBy = "of")
	List<GoodsCart> gcs = new ArrayList<GoodsCart>();
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
	// 鏀粯鏂瑰纺锛?.鍏ㄦ锛?锛氶娆?灏炬锛?.绾夸笅锛?
	private int pay_mode;
	// 鍟嗗搧閲?
	@Column(precision = 12, scale = 2)
	private BigDecimal goods_amount;
	// 淇℃伅
	@Lob
	@Column(columnDefinition = "LongText")
	private String msg;
	// 绁ㄦ嵁
	@ManyToOne
	private Accessory bill;
	private int order_status;// 璁㈠崟钟舵€?
	// 棣栦粯娆?
	private BigDecimal first_price;
	// 灏炬
	private BigDecimal end_price;
	// 鍚埚悓缂栧佛
	private String pact_no;
	// 鍚埚悓闄勪欢
	@ManyToMany(targetEntity = Accessory.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_order_pact", joinColumns = {
			@javax.persistence.JoinColumn(name = "order_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "pact_id") })
	private List<Accessory> pact_file;
	// 鍚埚悓钟舵€?
	private int pact_status;
	// 鏀惰揣鍦板潃
	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;
	// 璁㈠崟瀹屾垚镞?
	private Date finishtime;
	// 寮€绁ㄤ俊鎭?
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

}

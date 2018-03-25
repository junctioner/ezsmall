package com.wemall.foundation.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 鐗╂祦
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_logistics")
public class Logistics extends IdEntity {
	// 鐗╂祦鍗曞佛
	private String logistics_no;
	// 鐗╂祦鍏徃鍚岖О
	private String logistics_name;
	// 杞︾墝鍙峰涓溅鐗岀敤鑻辨枃钬?钬濋殧寮€
	private String car_no;
	// 鐗╂祦浜哄憳澶氢釜浜哄憳鑻辨枃钬?钬濋殧寮€
	private String proples;
	// 鐗╂祦璐圭敤
	private BigDecimal total_price;
	// 棰勮阃佽揪镞堕棿
	private Date service_time;
	// 阃佽揪镞堕棿
	private Date end_time;
	// 鐗╂祦钟舵€?
	private int status;
	// 澶囨敞
	private String msg;

	public String getLogistics_no() {
		return logistics_no;
	}

	public void setLogistics_no(String logistics_no) {
		this.logistics_no = logistics_no;
	}

	public String getLogistics_name() {
		return logistics_name;
	}

	public void setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
	}

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getProples() {
		return proples;
	}

	public void setProples(String proples) {
		this.proples = proples;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public Date getService_time() {
		return service_time;
	}

	public void setService_time(Date service_time) {
		this.service_time = service_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

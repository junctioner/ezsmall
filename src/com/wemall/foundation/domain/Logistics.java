package com.wemall.foundation.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 物流
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_logistics")
public class Logistics extends IdEntity {
	// 物流单号
	private String logistics_no;
	// 物流公司名称
	private String logistics_name;
	// 车牌号多个车牌用英文“,”隔开
	private String car_no;
	// 物流人员多个人员英文“,”隔开
	private String proples;
	// 物流费用
	private BigDecimal total_price;
	// 预警送达时间
	private Date service_time;
	// 送达时间
	private Date end_time;
	// 物流状态
	private int status;
	// 备注
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

package com.wemall.foundation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.wemall.core.domain.IdEntity;

/**
 * 
 * @author wangxiao
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_crm_dev")
public class CrmDev extends IdEntity {

	private String dev_id; // 1 设备编号 Dev_ID
	private String dev_name;// 2 设备名称 Dev_name 加工设备：破碎机、清洗生产线、造粒生产线、注塑设备、
	/*
	 * 环保设备：污水处理系统 运输设备：自有货车、合作货车、
	 * 检测设备：邵氏硬度计、洛氏硬度计、电子密度计、电动缺口制样机、熔体流动速率仪、X射线荧光光谱仪、数显悬臂冲击试验机、
	 * 数显简支梁冲击试验机、色差仪、烘箱、微机控制万能试验机、燃烧速率仪、热变形维卡软化测试机、马弗炉、红外测试仪、热重分析仪
	 */
	private String dev_type;// 3 设备类型 Dev_type 加工设备、检测设备、运输工具、环保设备
	private int number; // 4 数量 Number
	private String pro_capacity; // 5 处理能力 Pro_capacity
	private String loa_capacity_c; // 6 装载能力（立方）Loa_capacity_c
	private String loa_capacity_t; // 7 装载能力（吨）Loa_capacity_t
	private String turename; // 8 联系人 Turename
	private String mobile; // 9 联系电话 Mobile
	@OneToOne(fetch = FetchType.LAZY)
	private CrmConsumer consumer; // Ent_ID 企业编号
	public String getDev_id() {
		return dev_id;
	}
	public void setDev_id(String dev_id) {
		this.dev_id = dev_id;
	}
	public String getDev_name() {
		return dev_name;
	}
	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}
	public String getDev_type() {
		return dev_type;
	}
	public void setDev_type(String dev_type) {
		this.dev_type = dev_type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPro_capacity() {
		return pro_capacity;
	}
	public void setPro_capacity(String pro_capacity) {
		this.pro_capacity = pro_capacity;
	}
	public String getLoa_capacity_c() {
		return loa_capacity_c;
	}
	public void setLoa_capacity_c(String loa_capacity_c) {
		this.loa_capacity_c = loa_capacity_c;
	}
	public String getLoa_capacity_t() {
		return loa_capacity_t;
	}
	public void setLoa_capacity_t(String loa_capacity_t) {
		this.loa_capacity_t = loa_capacity_t;
	}
	public String getTurename() {
		return turename;
	}
	public void setTurename(String turename) {
		this.turename = turename;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public CrmConsumer getConsumer() {
		return consumer;
	}
	public void setConsumer(CrmConsumer consumer) {
		this.consumer = consumer;
	}

}

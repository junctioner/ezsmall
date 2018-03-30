package com.wemall.foundation.domain;

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
@Table(name = "ezs_crm_contacts")
public class CrmContacts extends IdEntity {

	private String tn_id; // 1 联系人编号 Tn_ID
	
	private String truename; // 2 联系人姓名 Truename
	
	private String sex; // 3 性别 Sex 男、女
	
	private String mobile; // 4 手机 Mobile 通过验证规则
	
	private String telephone; // 5 固定电话 Telephone 通用验证规则
	
	private String department; // 6 部门 Department
	
	private String post; // 7 职务 Post
	
	private String email; // 8 邮箱 Email 通用验证规则
	
	private String address;// 9 联系地址 Address 省 市 详细地址
	 @OneToOne(fetch = FetchType.LAZY)
	private CrmConsumer consumer; // 10 所属企业 Ent_ID 企业编号
	/*
	 * 采集信息、用户自填 
	 * 1、通过系统导入的线索用户信息，均为“采集信息” 
	 * 2、通过地推工具导入的用户信息，也为采集信息
	 * 3、通过网站进行注册、认证、激活填写的信息为“用户自填信息” 
	 * 4、“采集信息”与客户采集信息关联、“客户自填信息”与正式用户信息关联
	 */

	private String Infor_source; // 11 信息来源 Infor_source

	public String getTn_id() {
		return tn_id;
	}

	public void setTn_id(String tn_id) {
		this.tn_id = tn_id;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CrmConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(CrmConsumer consumer) {
		this.consumer = consumer;
	}

	public String getInfor_source() {
		return Infor_source;
	}

	public void setInfor_source(String infor_source) {
		Infor_source = infor_source;
	}

	
}

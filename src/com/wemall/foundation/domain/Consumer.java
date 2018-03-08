package com.wemall.foundation.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ezs_consumer")
public class Consumer extends IdEntity {
	private String name;// 企业名称

	private String tel;// 联系电话
	private String contacts;// 联系人
	private String site;// 地址
	private Date apply_time; // 申请时间

	private String type; // 平台类型
	private String scope; // 经营范围
	@Column(columnDefinition = "int default 0")
	private int grade;// 等级

	private String phone; // 注册手机
	private String state; // 状态
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		grade = grade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}

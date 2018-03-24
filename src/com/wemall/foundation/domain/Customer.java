package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 客户
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_customer")
public class Customer extends IdEntity {
	// 企业名称
	private String companyName;
	// 来源
	@ManyToOne
	private Source source;
	// 卖家、买家、都是
	private String role;
	// 主营行业
	private String mianIndustry;
	@ManyToOne
	private Level level;
	// 营业地址区县
	@ManyToOne
	private Area area;
	// 经营地址
	private String address;
	// 经营主体
	private int mainDody;
	// 经营年限
	private String year;
	// 场地面积
	private String site;
	// 场地是否租用
	private boolean enable;
	// 是否提供发票
	private boolean bill;
	// 税点
	private double point;
	// 证件类型
	@ManyToOne
	private Dict paper;
	@ManyToMany(targetEntity = Paper.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_customer_paper", joinColumns = {
			@javax.persistence.JoinColumn(name = "cus_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "paper_id") })
	private List<Paper> certificate = new ArrayList<Paper>();
	// 自由设备
	private String haveDevice;
	// 检验设备
	private String testDevice;
	// 破碎机台数
	private String crusher_num;
	// 破碎机能力
	private String crusher_ability;
	// 清洗生产线能力
	private String clean_num;
	// 清洗生产线能力
	private String clean_ability;
	// 造粒生产线台数
	private String granulation_num;
	// 造粒生产线能力
	private String granulation_ability;
	// 注塑设备台数
	private String mold_num;
	// 注塑设备能力
	private String mold_ability;
	// 污水处理系统
	private String sewage;
	// 自有货车数量
	private String truck_num;
	// 自有货车转载能力
	private String truck_load;
	// 自有货车卸载能力
	private String truck_uninstall;
	// 合作货车联系人
	private String hz_truck_lxr;
	// 合作货车联系人1
	private String hz_truck_lxr1;
	// 合作货车联系电话号
	private String hz_truck_tel;
	// 合作货车联系电话号1
	private String hz_truck_tel1;
	// 合作货车处理能力
	private String hz_truck_ability;
	// 合作货车处理能力
	private String hz_truck_ability1;
	// 导入时间
	private Date importDate;
	// 管理状态(1.分派，2.认领)
	private int admin_status;
	// 客戶状态（0.线索，1.注册，2.认证，3.激活）
	private int cus_status;
	@ManyToOne
	private Group group;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMianIndustry() {
		return mianIndustry;
	}

	public void setMianIndustry(String mianIndustry) {
		this.mianIndustry = mianIndustry;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMainDody() {
		return mainDody;
	}

	public void setMainDody(int mainDody) {
		this.mainDody = mainDody;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isBill() {
		return bill;
	}

	public void setBill(boolean bill) {
		this.bill = bill;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Dict getPaper() {
		return paper;
	}

	public void setPaper(Dict paper) {
		this.paper = paper;
	}

	public List<Paper> getCertificate() {
		return certificate;
	}

	public void setCertificate(List<Paper> certificate) {
		this.certificate = certificate;
	}

	public String getHaveDevice() {
		return haveDevice;
	}

	public void setHaveDevice(String haveDevice) {
		this.haveDevice = haveDevice;
	}

	public String getTestDevice() {
		return testDevice;
	}

	public void setTestDevice(String testDevice) {
		this.testDevice = testDevice;
	}

	public String getCrusher_num() {
		return crusher_num;
	}

	public void setCrusher_num(String crusher_num) {
		this.crusher_num = crusher_num;
	}

	public String getCrusher_ability() {
		return crusher_ability;
	}

	public void setCrusher_ability(String crusher_ability) {
		this.crusher_ability = crusher_ability;
	}

	public String getClean_num() {
		return clean_num;
	}

	public void setClean_num(String clean_num) {
		this.clean_num = clean_num;
	}

	public String getClean_ability() {
		return clean_ability;
	}

	public void setClean_ability(String clean_ability) {
		this.clean_ability = clean_ability;
	}

	public String getGranulation_num() {
		return granulation_num;
	}

	public void setGranulation_num(String granulation_num) {
		this.granulation_num = granulation_num;
	}

	public String getGranulation_ability() {
		return granulation_ability;
	}

	public void setGranulation_ability(String granulation_ability) {
		this.granulation_ability = granulation_ability;
	}

	public String getMold_num() {
		return mold_num;
	}

	public void setMold_num(String mold_num) {
		this.mold_num = mold_num;
	}

	public String getMold_ability() {
		return mold_ability;
	}

	public void setMold_ability(String mold_ability) {
		this.mold_ability = mold_ability;
	}

	public String getSewage() {
		return sewage;
	}

	public void setSewage(String sewage) {
		this.sewage = sewage;
	}

	public String getTruck_num() {
		return truck_num;
	}

	public void setTruck_num(String truck_num) {
		this.truck_num = truck_num;
	}

	public String getTruck_load() {
		return truck_load;
	}

	public void setTruck_load(String truck_load) {
		this.truck_load = truck_load;
	}

	public String getTruck_uninstall() {
		return truck_uninstall;
	}

	public void setTruck_uninstall(String truck_uninstall) {
		this.truck_uninstall = truck_uninstall;
	}

	public String getHz_truck_lxr() {
		return hz_truck_lxr;
	}

	public void setHz_truck_lxr(String hz_truck_lxr) {
		this.hz_truck_lxr = hz_truck_lxr;
	}

	public String getHz_truck_lxr1() {
		return hz_truck_lxr1;
	}

	public void setHz_truck_lxr1(String hz_truck_lxr1) {
		this.hz_truck_lxr1 = hz_truck_lxr1;
	}

	public String getHz_truck_tel() {
		return hz_truck_tel;
	}

	public void setHz_truck_tel(String hz_truck_tel) {
		this.hz_truck_tel = hz_truck_tel;
	}

	public String getHz_truck_tel1() {
		return hz_truck_tel1;
	}

	public void setHz_truck_tel1(String hz_truck_tel1) {
		this.hz_truck_tel1 = hz_truck_tel1;
	}

	public String getHz_truck_ability() {
		return hz_truck_ability;
	}

	public void setHz_truck_ability(String hz_truck_ability) {
		this.hz_truck_ability = hz_truck_ability;
	}

	public String getHz_truck_ability1() {
		return hz_truck_ability1;
	}

	public void setHz_truck_ability1(String hz_truck_ability1) {
		this.hz_truck_ability1 = hz_truck_ability1;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public int getAdmin_status() {
		return admin_status;
	}

	public void setAdmin_status(int admin_status) {
		this.admin_status = admin_status;
	}

	public int getCus_status() {
		return cus_status;
	}

	public void setCus_status(int cus_status) {
		this.cus_status = cus_status;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}

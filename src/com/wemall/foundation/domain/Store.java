package com.wemall.foundation.domain;

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
 * 商城店铺
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_store")
public class Store extends IdEntity {
	private String companyName;// 企业名称
	@ManyToOne(fetch = FetchType.LAZY)
	private Area area;// 经营地址区县
	private String address;// 经营地址
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict mianIndustry;// 主营行业
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_store_dict", joinColumns = {
			@javax.persistence.JoinColumn(name = "store_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "dict_id") })
	private List<Dict> companyType;// 公司类型
	private double yTurnover;// 年营业额
	private double covered;// 占地面积
	private boolean rent;// 租用
	private int device_num;// 设备数量
	private int employee_num;// 员工数量
	private double assets;// 总资产
	private double fixed_assets;// 固定资产
	private int obtainYear;// 实际控制人从业年限
	private String open_bank_name;// 开户行名称
	private String openBankNo;// 开户行账号
	private String open_branch_name;// 开户银行支行名称
	private String open_branch_no;// 开户支行账号
	private Area location;// 开户银行区县
	private String location_detail;// 开户银行所在地
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict cardType;// 证件类型
	@ManyToMany(targetEntity = Accessory.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_card_dict", joinColumns = {
			@javax.persistence.JoinColumn(name = "store_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "accessory_id") })
	private List<Accessory> card_imgs;// 证件图片
	@ManyToMany(targetEntity = Accessory.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_idcard_dict", joinColumns = {
			@javax.persistence.JoinColumn(name = "store_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "accessory_id") })
	private List<Accessory> idCard_imgs;// 身份证图片
	private int status;// 商品状态
	private Date registerDate;// 注册时间

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Dict getMianIndustry() {
		return mianIndustry;
	}

	public void setMianIndustry(Dict mianIndustry) {
		this.mianIndustry = mianIndustry;
	}

	public List<Dict> getCompanyType() {
		return companyType;
	}

	public void setCompanyType(List<Dict> companyType) {
		this.companyType = companyType;
	}

	public double getyTurnover() {
		return yTurnover;
	}

	public void setyTurnover(double yTurnover) {
		this.yTurnover = yTurnover;
	}

	public double getCovered() {
		return covered;
	}

	public void setCovered(double covered) {
		this.covered = covered;
	}

	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}

	public int getDevice_num() {
		return device_num;
	}

	public void setDevice_num(int device_num) {
		this.device_num = device_num;
	}

	public int getEmployee_num() {
		return employee_num;
	}

	public void setEmployee_num(int employee_num) {
		this.employee_num = employee_num;
	}

	public double getAssets() {
		return assets;
	}

	public void setAssets(double assets) {
		this.assets = assets;
	}

	public double getFixed_assets() {
		return fixed_assets;
	}

	public void setFixed_assets(double fixed_assets) {
		this.fixed_assets = fixed_assets;
	}

	public int getObtainYear() {
		return obtainYear;
	}

	public void setObtainYear(int obtainYear) {
		this.obtainYear = obtainYear;
	}

	public String getOpen_bank_name() {
		return open_bank_name;
	}

	public void setOpen_bank_name(String open_bank_name) {
		this.open_bank_name = open_bank_name;
	}

	public String getOpenBankNo() {
		return openBankNo;
	}

	public void setOpenBankNo(String openBankNo) {
		this.openBankNo = openBankNo;
	}

	public String getOpen_branch_name() {
		return open_branch_name;
	}

	public void setOpen_branch_name(String open_branch_name) {
		this.open_branch_name = open_branch_name;
	}

	public String getOpen_branch_no() {
		return open_branch_no;
	}

	public void setOpen_branch_no(String open_branch_no) {
		this.open_branch_no = open_branch_no;
	}

	public Area getLocation() {
		return location;
	}

	public void setLocation(Area location) {
		this.location = location;
	}

	public String getLocation_detail() {
		return location_detail;
	}

	public void setLocation_detail(String location_detail) {
		this.location_detail = location_detail;
	}

	public Dict getCardType() {
		return cardType;
	}

	public void setCardType(Dict cardType) {
		this.cardType = cardType;
	}

	public List<Accessory> getCard_imgs() {
		return card_imgs;
	}

	public void setCard_imgs(List<Accessory> card_imgs) {
		this.card_imgs = card_imgs;
	}

	public List<Accessory> getIdCard_imgs() {
		return idCard_imgs;
	}

	public void setIdCard_imgs(List<Accessory> idCard_imgs) {
		this.idCard_imgs = idCard_imgs;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}

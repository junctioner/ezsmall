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
 * 瀹㈡埛
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_customer")
public class Customer extends IdEntity {
	// 浼佷笟鍚岖О
	private String companyName;
	// 鏉ユ簮
	@ManyToOne
	private Source source;
	// 鍗栧銆佷拱瀹躲€侀兘鏄?
	private String role;
	// 涓昏惀琛屼笟
	private String mianIndustry;
	@ManyToOne
	private Level level;
	// 钀ヤ笟鍦板潃鍖哄幙
	@ManyToOne
	private Area area;
	// 缁忚惀鍦板潃
	private String address;
	// 缁忚惀涓讳綋
	private int mainDody;
	// 缁忚惀骞撮檺
	private String year;
	// 鍦哄湴闱㈢Н
	private String site;
	// 鍦哄湴鏄惁绉熺敤
	private boolean enable;
	// 鏄惁鎻愪緵鍙戠エ
	private boolean bill;
	// 绋庣偣
	private double point;
	// 璇佷欢绫诲瀷
	@ManyToOne
	private Dict paper;
	@ManyToMany(targetEntity = Paper.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_customer_paper", joinColumns = {
			@javax.persistence.JoinColumn(name = "cus_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "paper_id") })
	private List<Paper> certificate = new ArrayList<Paper>();
	// 镊敱璁惧
	private String haveDevice;
	// 妫€楠岃澶?
	private String testDevice;
	// 镰寸链哄彴鏁?
	private String crusher_num;
	// 镰寸链鸿兘锷?
	private String crusher_ability;
	// 娓呮礂鐢熶骇绾胯兘锷?
	private String clean_num;
	// 娓呮礂鐢熶骇绾胯兘锷?
	private String clean_ability;
	// 阃犵矑鐢熶骇绾垮彴鏁?
	private String granulation_num;
	// 阃犵矑鐢熶骇绾胯兘锷?
	private String granulation_ability;
	// 娉ㄥ璁惧鍙版暟
	private String mold_num;
	// 娉ㄥ璁惧鑳藉姏
	private String mold_ability;
	// 姹℃按澶勭悊绯荤粺
	private String sewage;
	// 镊湁璐ц溅鏁伴噺
	private String truck_num;
	// 镊湁璐ц溅杞浇鑳藉姏
	private String truck_load;
	// 镊湁璐ц溅鍗歌浇鑳藉姏
	private String truck_uninstall;
	// 鍚堜綔璐ц溅鑱旗郴浜?
	private String hz_truck_lxr;
	// 鍚堜綔璐ц溅鑱旗郴浜?
	private String hz_truck_lxr1;
	// 鍚堜綔璐ц溅鑱旗郴鐢佃瘽鍙?
	private String hz_truck_tel;
	// 鍚堜綔璐ц溅鑱旗郴鐢佃瘽鍙?
	private String hz_truck_tel1;
	// 鍚堜綔璐ц溅澶勭悊鑳藉姏
	private String hz_truck_ability;
	// 鍚堜綔璐ц溅澶勭悊鑳藉姏
	private String hz_truck_ability1;
	// 瀵煎叆镞堕棿
	private Date importDate;
	// 绠＄悊钟舵€?1.鍒嗘淳锛?.璁ら)
	private int admin_status;
	// 瀹㈡埗钟舵€侊纸0.绾跨储锛?.娉ㄥ唽锛?.璁よ瘉锛?.婵€娲伙级
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

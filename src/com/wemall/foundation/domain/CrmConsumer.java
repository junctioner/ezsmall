package com.wemall.foundation.domain;


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
@Table(name = "ezs_crm_consumer")
public class CrmConsumer extends IdEntity {
	
	private String ent_id; // 企业编号
	
	private String ent_name;// 企业名称

	private String platform_type;// 平台类别 -- 买家、卖家
	
	private String clue_source;// 线索来源 --配置管理—>线索来源设置中设置的项

	@Column(columnDefinition = "int default 0")
	private int grade;// 等级
	
	private String oper_address;// 详细地址

	private String per_subject;// 经营主体 --(个体工商户、企业)

	private String main_business;// 主营行业 -- (改性、造粒、塑料产品加工)

	private String oper_life;// 经营年限 -- (1年以内、1-2年、2-5年，5-10年，10年以上)

	private String site_area;// 场地面积 --(300平米以下、300-500平米、500—1000平米、1000—5000平米、5000-10000平米、10000-30000平米、30000平米以上)
	
	private boolean rented; //场地是否租用  --(是否)  

	private String own_equipment; // 自有设备
	
	private String invoice; // 是否提供发票

	private String tax_point; // 税点
	
	private String num_workers; // 工人数量
	
	private String mon_turnover; // 月营业额

	private String cred_type; // 证件类型   --三证合一、五证合一（四证合一）、三证三号
	
	private String ente_Certificate;      // 企业证件   --工商营业执照、税务登记证、组织机构代码证图片
	
	private String EIA_qualification; // 环评资质  --图片

	private String Qua_sewage_treatment; // 污水处理资质  --图片
	
	private String status; // 状态
	
	



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnt_id() {
		return ent_id;
	}

	public void setEnt_id(String ent_id) {
		this.ent_id = ent_id;
	}

	public String getEnt_name() {
		return ent_name;
	}

	public void setEnt_name(String ent_name) {
		this.ent_name = ent_name;
	}

	public String getPlatform_type() {
		return platform_type;
	}

	public void setPlatform_type(String platform_type) {
		this.platform_type = platform_type;
	}

	public String getClue_source() {
		return clue_source;
	}

	public void setClue_source(String clue_source) {
		this.clue_source = clue_source;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getOper_address() {
		return oper_address;
	}

	public void setOper_address(String oper_address) {
		this.oper_address = oper_address;
	}

	public String getPer_subject() {
		return per_subject;
	}

	public void setPer_subject(String per_subject) {
		this.per_subject = per_subject;
	}

	public String getMain_business() {
		return main_business;
	}

	public void setMain_business(String main_business) {
		this.main_business = main_business;
	}

	public String getOper_life() {
		return oper_life;
	}

	public void setOper_life(String oper_life) {
		oper_life = oper_life;
	}

	public String getSite_area() {
		return site_area;
	}

	public void setSite_area(String site_area) {
		this.site_area = site_area;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getOwn_equipment() {
		return own_equipment;
	}

	public void setOwn_equipment(String own_equipment) {
		this.own_equipment = own_equipment;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getTax_point() {
		return tax_point;
	}

	public void setTax_point(String tax_point) {
		this.tax_point = tax_point;
	}

	public String getNum_workers() {
		return num_workers;
	}

	public void setNum_workers(String num_workers) {
		this.num_workers = num_workers;
	}

	public String getMon_turnover() {
		return mon_turnover;
	}

	public void setMon_turnover(String mon_turnover) {
		this.mon_turnover = mon_turnover;
	}

	public String getCred_type() {
		return cred_type;
	}

	public void setCred_type(String cred_type) {
		this.cred_type = cred_type;
	}

	public String getEnte_Certificate() {
		return ente_Certificate;
	}

	public void setEnte_Certificate(String ente_Certificate) {
		this.ente_Certificate = ente_Certificate;
	}

	public String getEIA_qualification() {
		return EIA_qualification;
	}

	public void setEIA_qualification(String eIA_qualification) {
		EIA_qualification = eIA_qualification;
	}

	public String getQua_sewage_treatment() {
		return Qua_sewage_treatment;
	}

	public void setQua_sewage_treatment(String qua_sewage_treatment) {
		Qua_sewage_treatment = qua_sewage_treatment;
	}
	


}

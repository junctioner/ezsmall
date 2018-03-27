package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_specialSubject")
public class SpecialSubject extends IdEntity{
    private String name;//专题名称
    
    private String abbreviation;//简称
    
    private String keyWord;//关键字
    
    private String description;//描述
    
    private String pcTitlePhoto;//pc端描述图
    
    private String phoneTitlePhoto;//手机端描述图
    
    private String pcContentPhoto;//pc端内容图
    
    private String phoneContentPhoto;//手机端内容图
    
    private int orderid;// 排序
    
    private boolean recommend;//推荐
    
	private String colTemplate;// 专题模板
	
	private String phoTemplate;// 手机模板

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPcTitlePhoto() {
		return pcTitlePhoto;
	}

	public void setPcTitlePhoto(String pcTitlePhoto) {
		this.pcTitlePhoto = pcTitlePhoto;
	}

	public String getPhoneTitlePhoto() {
		return phoneTitlePhoto;
	}

	public void setPhoneTitlePhoto(String phoneTitlePhoto) {
		this.phoneTitlePhoto = phoneTitlePhoto;
	}

	public String getPcContentPhoto() {
		return pcContentPhoto;
	}

	public void setPcContentPhoto(String pcContentPhoto) {
		this.pcContentPhoto = pcContentPhoto;
	}

	public String getPhoneContentPhoto() {
		return phoneContentPhoto;
	}

	public void setPhoneContentPhoto(String phoneContentPhoto) {
		this.phoneContentPhoto = phoneContentPhoto;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public String getColTemplate() {
		return colTemplate;
	}

	public void setColTemplate(String colTemplate) {
		this.colTemplate = colTemplate;
	}

	public String getPhoTemplate() {
		return phoTemplate;
	}

	public void setPhoTemplate(String phoTemplate) {
		this.phoTemplate = phoTemplate;
	}
    
}

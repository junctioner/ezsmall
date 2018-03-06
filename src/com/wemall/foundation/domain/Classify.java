package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 分类
 * @author 浣欏爟
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_classify")
public class Classify extends IdEntity{

	private String name;//分类名称
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Remark re ;
	
	private String remarkValue;//实际地区名
	
	private String title;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Remark getRe() {
		return re;
	}

	public void setRe(Remark re) {
		this.re = re;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemarkValue() {
		return remarkValue;
	}

	public void setRemarkValue(String remarkValue) {
		this.remarkValue = remarkValue;
	}
	
}

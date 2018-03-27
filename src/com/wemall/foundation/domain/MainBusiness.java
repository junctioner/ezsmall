package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_main_business")
public class MainBusiness extends IdEntity {
	private String main_business; //主营行业
	
	public String getMain_business() {
		return main_business;
	}
	
	public void setMain_business(String main_business) {
		this.main_business = main_business;
	}
	
}

package com.wemall.foundation.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.easyjf.dbo.annotation.ManyToMany;
import com.wemall.core.domain.IdEntity;

/**
 * 标签
 * @author 浣欏爟
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_remark")
public class Remark extends IdEntity{
	
	private String name;//分类或者标签名称
	
	@OneToMany(mappedBy = "re")
	private List<Classify> cla;//标签类型
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EzsSubstance substance;
	
	private String title;//标签beizhu

	public EzsSubstance getSubstance() {
		return substance;
	}

	public void setSubstance(EzsSubstance substance) {
		this.substance = substance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Classify> getCla() {
		return cla;
	}

	public void setCla(List<Classify> cla) {
		this.cla = cla;
	}
    
}

package com.wemall.foundation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 沟通类型
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_communicate")
public class Communicate extends IdEntity {
	// 线索名称
	private String name;
	// 线索类型
	@ManyToOne
	private Dict dictType;
	// 线索描述
	private String content;
	// 是否显示
	@Column(columnDefinition = "bit default false")
	private boolean display;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dict getDictType() {
		return dictType;
	}

	public void setDictType(Dict dictType) {
		this.dictType = dictType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}

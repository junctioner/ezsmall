package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 瀛楀吀
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_dict")
public class Dict extends IdEntity {
	private String name;// 鍚岖О
	private String code;// 缂栧佛
	private String content;// 鎻忚堪
	@ManyToOne(fetch = FetchType.LAZY)
	private Dict parent;// 鐖剁被
	private int sequence;// 鎺掑簭sequence

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Dict getParent() {
		return parent;
	}

	public void setParent(Dict parent) {
		this.parent = parent;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}

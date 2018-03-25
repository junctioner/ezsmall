package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 璐ㄦ
 * 
 * @author lianfu
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_quality")
public class Quality extends IdEntity {
	private String quality_no;// 璐ㄦ缂栧佛
	private int status;// 璐ㄦ钟舵€?
	private String report;// 璐ㄦ鎶ュ憡

	public String getQuality_no() {
		return quality_no;
	}

	public void setQuality_no(String quality_no) {
		this.quality_no = quality_no;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

}

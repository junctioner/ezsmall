package com.wemall.foundation.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 证件
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_paper")
public class Paper extends IdEntity {
	//证件
	@ManyToOne
	public Accessory certificate;
	// 证件有效期
	private Date validDate;

	public Accessory getCertificate() {
		return certificate;
	}

	public void setCertificate(Accessory certificate) {
		this.certificate = certificate;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

}

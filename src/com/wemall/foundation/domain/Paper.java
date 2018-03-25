package com.wemall.foundation.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_paper")
public class Paper extends IdEntity {
	// 姝ｅ皢
	@ManyToOne
	public Accessory certificate;
	// 璇佷欢链夋晥链?
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

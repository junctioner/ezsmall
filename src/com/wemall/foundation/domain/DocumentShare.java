package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 文章分享的类
 * @author 浣欏爟
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_documentShare")
public class DocumentShare extends IdEntity{
	
	@OneToOne
	private User u;
	
	@OneToOne
	private EzsSubstance e;
	
	private int give;//文章的状态,0表示初始化，1表示点赞，2表示踩
	
	private int house;//收藏状态 0表示未收藏1收藏

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public EzsSubstance getE() {
		return e;
	}

	public void setE(EzsSubstance e) {
		this.e = e;
	}

	public int getGive() {
		return give;
	}

	public void setGive(int give) {
		this.give = give;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}
	
}

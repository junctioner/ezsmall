package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.wemall.core.domain.IdEntity;

/**
 * 鏉冮檺璧勬簮
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_res")
public class Res extends IdEntity {
	// 鍚岖О
	private String resName;
	// 绫诲瀷
	private String type;
	// 浠锋牸
	private String value;
	// 搴忓垪
	private int sequence;
	// 淇℃伅
	private String info;
	// 瑙掕壊
	@ManyToMany(mappedBy = "reses", targetEntity = Role.class, fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();

	@Transient
	public String getRoleAuthorities() {
		List<String> roleAuthorities = new ArrayList<String>();
		for (Role role : this.roles) {
			roleAuthorities.add(role.getRoleCode());
		}
		return StringUtils.join(roleAuthorities.toArray(), ",");
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

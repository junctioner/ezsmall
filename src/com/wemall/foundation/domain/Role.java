package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 瑙掕壊
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_role")
public class Role extends IdEntity {
	private String name;// 瑙掕壊鍚岖О
	private String roleCode;// 瑙掕壊浠ｅ佛
	private String type;// 绫诲瀷
	private String info;// 淇℃伅
	private boolean display;// 灞旷ず
	private int sequence;// 搴忓垪
	// 瑙掕壊缁?
	@ManyToOne(fetch = FetchType.LAZY)
	private RoleGroup roleGroup;
	//璧勬簮
	@ManyToMany(targetEntity = Res.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_role_res", joinColumns = {
			@javax.persistence.JoinColumn(name = "role_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "res_id") })
	private List<Res> reses = new ArrayList<Res>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public RoleGroup getRoleGroup() {
		return roleGroup;
	}
	public void setRoleGroup(RoleGroup roleGroup) {
		this.roleGroup = roleGroup;
	}
	public List<Res> getReses() {
		return reses;
	}
	public void setReses(List<Res> reses) {
		this.reses = reses;
	}
	
}

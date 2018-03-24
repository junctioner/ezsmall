package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

import com.wemall.core.annotation.Lock;
import com.wemall.core.domain.IdEntity;

/**
 * 用户登陆信息
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_user")
public class User extends IdEntity implements UserDetails {
	public String name;// 用户登陆名称
	private String trueName;// 用户真实名称
	 @Lock
	private String password;// 用户密码
	private String userRole;// ADMIN(后台用户)，BUYER(买家)，SELLER（卖家），若一个人两个角色（后台管理+买家）用ADMIN_BUYER
	@OneToOne
	private UserInfo userInfo;// 用户详情
	@ManyToOne(fetch = FetchType.LAZY)
	private User parent;// 父类账号
	@ManyToOne(fetch = FetchType.LAZY)
	private Store store;// 用户店铺
	// 上次登录时间
	private Date lastLoginDate;
	// 登录时间
	private Date loginDate;
	// 上次登录IP
	private String lastLoginIp;
	// 登录IP
	private String loginIp;
	// 登录次数
	private int loginCount;
	// 角色
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
	@JoinTable(name = "ezs_user_role", joinColumns = {
			@javax.persistence.JoinColumn(name = "user_id") }, inverseJoinColumns = {
					@javax.persistence.JoinColumn(name = "role_id") })
	private Set<Role> roles = new TreeSet<Role>();
	// 配置
	@OneToOne(mappedBy = "user")
	private UserConfig config;
	// 角色资源
	@Transient
	private Map<String, List<Res>> roleResources;
	@Transient
	private GrantedAuthority[] authorities = new GrantedAuthority[0];

	public String UserInfo() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getName() {
		return name;
	}

	@Override
	public GrantedAuthority[] getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {

		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, List<Res>> getRoleResources() {
		if (this.roleResources == null) {
			this.roleResources = new HashMap();
			for (Role role : this.roles) {
				String roleCode = role.getRoleCode();
				List<Res> ress = role.getReses();
				for (Res res : ress) {
					String key = roleCode + "_" + res.getType();
					if (!this.roleResources.containsKey(key)) {
						this.roleResources.put(key, new ArrayList());
					}
					((List) this.roleResources.get(key)).add(res);
				}
			}
		}

		return this.roleResources;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GrantedAuthority[] get_all_Authorities() {
		List grantedAuthorities = new ArrayList(this.roles.size());
		for (Role role : this.roles) {
			grantedAuthorities.add(new GrantedAuthorityImpl(role.getRoleCode()));
		}
		return (GrantedAuthority[]) grantedAuthorities.toArray(new GrantedAuthority[this.roles.size()]);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GrantedAuthority[] get_common_Authorities() {
		List grantedAuthorities = new ArrayList(this.roles.size());
		for (Role role : this.roles) {
			if (!role.getType().equals("ADMIN"))
				grantedAuthorities.add(new GrantedAuthorityImpl(role.getRoleCode()));
		}
		return (GrantedAuthority[]) grantedAuthorities.toArray(new GrantedAuthority[grantedAuthorities.size()]);
	}

	public void setAuthorities(GrantedAuthority[] authorities) {
		this.authorities = authorities;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setRoleResources(Map<String, List<Res>> roleResources) {
		this.roleResources = roleResources;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public UserConfig getConfig() {
		return config;
	}

	public void setConfig(UserConfig config) {
		this.config = config;
	}

}

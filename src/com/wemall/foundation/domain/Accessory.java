package com.wemall.foundation.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;
/**
 * 附件
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_accessory")
public class Accessory extends IdEntity {
	// 附近名称
	private String name;
	// 附件路径
	private String path;
	// 大小
	private float size;
	// 宽度
	private int width;
	// 高度
	private int height;
	// 扩展名
	private String ext;
	// 名称详情
	private String info;

	// 所属人
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	// 相册
	@ManyToOne(fetch = FetchType.LAZY)
	private Album album;

	@OneToOne(mappedBy = "album_cover", fetch = FetchType.LAZY)
	private Album cover_album;

	// 系统配置
	@ManyToOne(fetch = FetchType.LAZY)
	private SysConfig config;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Album getCover_album() {
		return cover_album;
	}

	public void setCover_album(Album cover_album) {
		this.cover_album = cover_album;
	}

	public SysConfig getConfig() {
		return config;
	}

	public void setConfig(SysConfig config) {
		this.config = config;
	}

}

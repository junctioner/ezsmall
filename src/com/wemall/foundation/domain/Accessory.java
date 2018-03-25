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
 * 闄勪欢
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_accessory")
public class Accessory extends IdEntity {
	// 闄勮繎鍚岖О
	private String name;
	// 闄勪欢璺缎
	private String path;
	// 澶у皬
	private float size;
	// 瀹藉害
	private int width;
	// 楂桦害
	private int height;
	// 镓╁睍鍚?
	private String ext;
	// 鍚岖О璇︽儏
	private String info;

	// 镓€灞炰汉
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	// 鐩稿唽
	@ManyToOne(fetch = FetchType.LAZY)
	private Album album;

	@OneToOne(mappedBy = "album_cover", fetch = FetchType.LAZY)
	private Album cover_album;

	// 绯荤粺閰岖疆
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

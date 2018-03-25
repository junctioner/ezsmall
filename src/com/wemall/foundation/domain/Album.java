package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 鐩稿唽
 * 
 * @author 鍒樻亽绂?
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_album")
public class Album extends IdEntity {
	// 鐩稿唽鍚岖О
	private String album_name;
	// 鐩稿唽搴忓佛
	private int album_sequence;
	// 澶村儚
	@OneToMany(mappedBy = "album", cascade = { javax.persistence.CascadeType.REMOVE })
	private List<Accessory> photos = new ArrayList<Accessory>();
	// 鐩稿唽
	@OneToOne(fetch = FetchType.LAZY)
	private Accessory album_cover;
	// 榛樿鐩稿唽
	private boolean album_default;

	// 鐩稿唽淇℃伅
	@Lob
	@Column(columnDefinition = "LongText")
	private String alblum_info;

	// 鐩稿唽镓€灞炰汉
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public int getAlbum_sequence() {
		return album_sequence;
	}

	public void setAlbum_sequence(int album_sequence) {
		this.album_sequence = album_sequence;
	}

	public List<Accessory> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Accessory> photos) {
		this.photos = photos;
	}

	public Accessory getAlbum_cover() {
		return album_cover;
	}

	public void setAlbum_cover(Accessory album_cover) {
		this.album_cover = album_cover;
	}

	public boolean isAlbum_default() {
		return album_default;
	}

	public void setAlbum_default(boolean album_default) {
		this.album_default = album_default;
	}

	public String getAlblum_info() {
		return alblum_info;
	}

	public void setAlblum_info(String alblum_info) {
		this.alblum_info = alblum_info;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

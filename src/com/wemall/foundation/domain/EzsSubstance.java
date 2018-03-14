package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wemall.core.domain.IdEntity;

/**
 * 内容
 * @author 浣欏爟
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_ezsSubstance")
public class EzsSubstance extends IdEntity{
	
	// 栏目
	@ManyToOne(fetch = FetchType.LAZY)
	private EzsColumn ec;
	
	// 副栏目
	@ManyToOne(fetch = FetchType.LAZY)
	private EzsColumn childEc;
	
	//专题
	@ManyToOne(fetch = FetchType.LAZY)
	private SpecialSubject ss;

	private String name;// 主标题
	
	private boolean linkPort;//外部链接
	
	private String linkUrl;//链接地址
	
	private String subheading;//副标题
	
	private String titleColor;//标题颜色
	
	private boolean bold;//加粗
	
	private String tagTitle;//tag标签
	
	private String meta;//摘要
	
	private String keyWord;//关键字
	
	private String author;//作者
	
	private String origin;//来源
	
	private String originUrl;//来源链接
	
	@Temporal(TemporalType.DATE)
	private Date publicTime;//发布时间
	
	private String fixedTime;//固顶时间
	
	private boolean pcView;//是否在pc端显示
	
	private int attribute;//1.头条，2.推荐3.图片4.幻灯5.滚动6.图文
	
	private String thumbnail;//缩略图
	
	private String attachment;//附件
	
	private String multimediaFiles;//多媒体文件
	
	private String photos;//图片集
	
	private String content;//文章内容
	
	private int clickRate;//点击量
	
	private int status;//审核状态 1.未审核2.已审核3.退回
	
	private int staticStatus;//静态页状态1.未生成 2.已生成
	
    private String remarkValue;//标签集合
    
    @OneToOne
    private User u;

	public int getClickRate() {
		return clickRate;
	}

	public void setClickRate(int clickRate) {
		this.clickRate = clickRate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStaticStatus() {
		return staticStatus;
	}

	public void setStaticStatus(int staticStatus) {
		this.staticStatus = staticStatus;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public EzsColumn getEc() {
		return ec;
	}

	public void setEc(EzsColumn ec) {
		this.ec = ec;
	}

	public SpecialSubject getSs() {
		return ss;
	}

	public void setSs(SpecialSubject ss) {
		this.ss = ss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLinkPort() {
		return linkPort;
	}

	public void setLinkPort(boolean linkPort) {
		this.linkPort = linkPort;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getSubheading() {
		return subheading;
	}

	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	public String getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public String getTagTitle() {
		return tagTitle;
	}

	public void setTagTitle(String tagTitle) {
		this.tagTitle = tagTitle;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public Date getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}

	public String getFixedTime() {
		return fixedTime;
	}

	public void setFixedTime(String fixedTime) {
		this.fixedTime = fixedTime;
	}

	public boolean isPcView() {
		return pcView;
	}

	public void setPcView(boolean pcView) {
		this.pcView = pcView;
	}

	public int getAttribute() {
		return attribute;
	}

	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getMultimediaFiles() {
		return multimediaFiles;
	}

	public void setMultimediaFiles(String multimediaFiles) {
		this.multimediaFiles = multimediaFiles;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemarkValue() {
		return remarkValue;
	}

	public void setRemarkValue(String remarkValue) {
		this.remarkValue = remarkValue;
	}

	public EzsColumn getChildEc() {
		return childEc;
	}

	public void setChildEc(EzsColumn childEc) {
		this.childEc = childEc;
	}
	
}

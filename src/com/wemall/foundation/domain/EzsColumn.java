package com.wemall.foundation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
 * 
 * @author 刘恒福
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "ezs_column")
public class EzsColumn extends IdEntity {
	private int columnLevel;//栏目级别
	private String prepareColumn;//备用字段
	private String name;// 栏目名称
	@Column(columnDefinition = "int default 0")
	private int attribute;// 1.最终列表栏目,2.频道封面,3.仅为单独内容页，4.外部链接
	private String accessPath;// 访问路径
	private String colTemplate;// 栏目模板
	private String phoTemplate;// 手机模板
	@Column(columnDefinition = "int default 0")
	private int orderid;// 栏目排序
	private boolean reveal;// 是否显示
	private boolean window;// 是否新窗体
	private String title;// meta标题
	private String keyWord;// 关键字
	private String description;// 描述
	@Column(columnDefinition = "int default 0")
	private int browsePower;// 浏览权限 1.所有人，2.注册会员，3.付费会员
	private boolean review;// 是否审核
	@Column(columnDefinition = "int default 0")
	private int examine;// 审核状态
	private String content;//内容
	@ManyToOne
	private User user;
	//最终栏目列表
	private String finalSection;
    public String getFinalSection() {
		return finalSection;
	}

	public void setFinalSection(String finalSection) {
		this.finalSection = finalSection;
	}

	//	@ManyToMany
//	@JoinTable(name = "ezs_col_gsp", joinColumns = {
//			@javax.persistence.JoinColumn(name = "col_id") }, inverseJoinColumns = {
//					@javax.persistence.JoinColumn(name = "gsp_id") })
//	private List<GoodsSpecification> gsps = new ArrayList<GoodsSpecification>();
	// 分类
//	@ManyToOne(fetch = FetchType.LAZY)
//	private GoodsClass gc;
	//父类
	@ManyToOne(fetch = FetchType.LAZY)
	private EzsColumn parentEzsColumn;
	
	public EzsColumn getParentEzsColumn() {
		return parentEzsColumn;
	}

	public void setParentEzsColumn(EzsColumn parentEzsColumn) {
		this.parentEzsColumn = parentEzsColumn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPrepareColumn() {
		return prepareColumn;
	}

	public void setPrepareColumn(String prepareColumn) {
		this.prepareColumn = prepareColumn;
	}

	public int getColumnLevel() {
		return columnLevel;
	}

	public void setColumnLevel(int columnLevel) {
		this.columnLevel = columnLevel;
	}

	public int getAttribute() {
		return attribute;
	}

	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessPath() {
		return accessPath;
	}

	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}

	public String getColTemplate() {
		return colTemplate;
	}

	public void setColTemplate(String colTemplate) {
		this.colTemplate = colTemplate;
	}

	public String getPhoTemplate() {
		return phoTemplate;
	}

	public void setPhoTemplate(String phoTemplate) {
		this.phoTemplate = phoTemplate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public boolean isReveal() {
		return reveal;
	}

	public void setReveal(boolean reveal) {
		this.reveal = reveal;
	}

	public boolean isWindow() {
		return window;
	}

	public void setWindow(boolean window) {
		this.window = window;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBrowsePower() {
		return browsePower;
	}

	public void setBrowsePower(int browsePower) {
		this.browsePower = browsePower;
	}

	public boolean isReview() {
		return review;
	}

	public void setReview(boolean review) {
		this.review = review;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<GoodsSpecification> getGsps() {
//		return gsps;
//	}
//
//	public void setGsps(List<GoodsSpecification> gsps) {
//		this.gsps = gsps;
//	}

	public int getExamine() {
		return examine;
	}

	public void setExamine(int examine) {
		this.examine = examine;
	}

//	public GoodsClass getGc() {
//		return gc;
//	}
//
//	public void setGc(GoodsClass gc) {
//		this.gc = gc;
//	}

}

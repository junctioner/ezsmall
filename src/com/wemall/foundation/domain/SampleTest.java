package com.wemall.foundation.domain;

public class SampleTest {
private int id;
private int singlePrice;
private int goodsNum;
private int logistics;
private int changePrivace;
private int state;
private double weight;
private String buyerInfo;




public String toString() {
	return "SampleTest [id=" + id + ", singlePrice=" + singlePrice
			+ ", goodsNum=" + goodsNum + ", logistics=" + logistics
			+ ", changePrivace=" + changePrivace + ", state=" + state
			+ ", weight=" + weight + ", buyerInfo=" + buyerInfo + "]";
}
public double getWeight() {
	return weight;
}
public void setWeight(double d) {
	this.weight = d;
}
public String getBuyerInfo() {
	return buyerInfo;
}
public void setBuyerInfo(String buyerInfo) {
	this.buyerInfo = buyerInfo;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getSinglePrice() {
	return singlePrice;
}
public void setSinglePrice(int singlePrice) {
	this.singlePrice = singlePrice;
}
public int getGoodsNum() {
	return goodsNum;
}
public void setGoodsNum(int goodsNum) {
	this.goodsNum = goodsNum;
}
public int getLogistics() {
	return logistics;
}
public void setLogistics(int logistics) {
	this.logistics = logistics;
}
public int getChangePrivace() {
	return changePrivace;
}
public void setChangePrivace(int changePrivace) {
	this.changePrivace = changePrivace;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
	
}

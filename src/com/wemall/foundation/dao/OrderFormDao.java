package com.wemall.foundation.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.base.GenericDAO;
import com.wemall.core.dao.IGenericDAO;
import com.wemall.foundation.domain.Accessory;
import com.wemall.foundation.domain.OrderForm;

public class OrderFormDao extends GenericDAO<OrderForm> {
	
	 @Resource(name = "orderFormDAO")
	    private IGenericDAO<OrderForm> orderFormDAO;
	
	public List<OrderForm> getAllOrder(Map params, int begin, int max) {
		
		return orderFormDAO.query("select obj from OrderForm obj", params, begin, max);
	}
	
	

}

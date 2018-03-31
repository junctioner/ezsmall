package com.wemall.foundation.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.base.GenericDAO;
import com.wemall.core.dao.IGenericDAO;
import com.wemall.foundation.domain.Accessory;
import com.wemall.foundation.domain.OrderForm;

@Repository("orderFormDAO")
public class OrderFormDao extends GenericDAO<OrderForm> {
}

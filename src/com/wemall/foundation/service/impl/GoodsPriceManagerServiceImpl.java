/**
 * Project Name:ezsmall
 * File Name:GoodsPriceManagerServiceImpl.java
 * Package Name:com.wemall.foundation.service.impl
 * Date:2018年3月31日下午7:50:19
 * Copyright (c) 2018, yanL All Rights Reserved.
 *
*/

package com.wemall.foundation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.service.GoodsPriceManagerService;

/**
 * Description: <br/>
 * Date: 2018年3月31日 下午7:50:19 <br/>
 * 
 * @author yanL
 * @version
 * @see
 */
@Service
@Transactional
public class GoodsPriceManagerServiceImpl implements GoodsPriceManagerService {

    @Resource(name = "goodsDAO")
    private IGenericDAO<Goods> goodsDAO;

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see com.wemall.foundation.service.impl.GoodsPriceManagerService#list()
     */
    @Override
    public List<Map<String, Object>> list() {

        List<Map<String, Object>> list = this.goodsDAO.query("from Goods", new HashMap<>(), 1, 1);
        return list;
    }

}

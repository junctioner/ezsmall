/**
 * Project Name:ezsmall
 * File Name:GoodsPriceManagerServiceImpl.java
 * Package Name:com.wemall.foundation.service.impl
 * Date:2018年3月31日下午7:50:19
 * Copyright (c) 2018, yanL All Rights Reserved.
 *
*/

package com.wemall.foundation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.dao.PriceAdjustDao;
import com.wemall.foundation.domain.PriceAdjust;
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

    @Resource(name = "priceAdjustDao")
    private PriceAdjustDao priceAdjustDao;

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see com.wemall.foundation.service.impl.GoodsPriceManagerService#list()
     */
    @Override
    public List<PriceAdjust> list() {

        List<PriceAdjust> list = this.priceAdjustDao.queryAll();
        return list;
    }

}

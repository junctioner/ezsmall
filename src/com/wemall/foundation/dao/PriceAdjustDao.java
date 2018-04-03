/**
 * Project Name:ezsmall
 * File Name:PriceAdjistDao.java
 * Package Name:com.wemall.foundation.dao
 * Date:2018年4月3日下午3:07:11
 * Copyright (c) 2018, yanL All Rights Reserved.
 *
*/

package com.wemall.foundation.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.PriceAdjust;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:07:11 <br/>
 * 
 * @author yanL
 * @version
 * @see
 */
@Repository("priceAdjustDao")
public class PriceAdjustDao extends GenericDAO<PriceAdjust> {

    public void queryById(int id) {
        String hql = "from tab1 where id=: id";

    }

    public List<PriceAdjust> queryAll() {

        return find("from PriceAdjust", new HashMap<String, Object>(), 0, Integer.MAX_VALUE);

    }

}

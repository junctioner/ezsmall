/**
 * Project Name:ezsmall
 * File Name:GoodsClassDaoImpl.java
 * Package Name:com.wemall.manage.admin.dao.impl
 * Date:2018年3月30日下午4:32:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package com.wemall.manage.admin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wemall.foundation.domain.GoodClass;
import com.wemall.manage.admin.dao.GoodsClassDao;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午4:32:00 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
@Repository
public class GoodsClassDaoImpl implements GoodsClassDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<GoodClass> name() {
        Session session = sessionFactory.openSession();
        List<GoodClass> list = session.createQuery("from GoodClass").list();
        session.close();
        return list;
    }
}

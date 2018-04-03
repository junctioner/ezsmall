package com.wemall.manage.admin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wemall.foundation.domain.Address;
import com.wemall.manage.admin.dao.AddressDao;
@Repository
public class AddressDaoImpl implements AddressDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Address> getAllAddress(Long id) {
		 Session session = sessionFactory.openSession();
		 List<Address> list = session.createQuery("from Address where id = :id").list();
		 session.close();
		return list;
	}

}

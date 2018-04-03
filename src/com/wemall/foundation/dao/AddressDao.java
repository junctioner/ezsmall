package com.wemall.foundation.dao;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.Address;
@Repository("addressDao")
public class AddressDao extends GenericDAO<Address> {
	
	
	public List<Address>  query(String paramString, Map paramMap, int paramInt1, int paramInt2){
		
		
		return super.query(paramString, paramMap, paramInt1, paramInt2);
		
	}
	
	

}

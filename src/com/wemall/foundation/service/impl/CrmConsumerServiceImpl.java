package com.wemall.foundation.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.query.GenericPageList;
import com.wemall.core.query.PageObject;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.core.tools.PageData;
import com.wemall.foundation.dao.CrmConsumerDAO;
import com.wemall.foundation.dao.CrmContactsDAO;
import com.wemall.foundation.domain.CrmConsumer;
import com.wemall.foundation.domain.CrmContacts;
import com.wemall.foundation.domain.CrmDev;
import com.wemall.foundation.service.ICrmConsumerService;
@Service
@Transactional
public class CrmConsumerServiceImpl implements ICrmConsumerService{


	 @Resource
	 private	CrmContactsDAO crmContactsDao;
	 @Resource
	 private CrmConsumerDAO crmConsumerDao;

	@Override
	public boolean save(CrmConsumer consumer) {
		try {
			this.crmConsumerDao.save(consumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			this.crmConsumerDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CrmConsumer consumer) {
		try {
			this.crmConsumerDao.update(consumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public IPageList list(IQueryObject properties) {
		 if (properties == null){
	            return null;
	        }
	        String query = properties.getQuery();
	        Map params = properties.getParameters();
	        GenericPageList pList = new GenericPageList(CrmConsumer.class, query,
	                params, this.crmConsumerDao);
	        if (properties != null){
	            PageObject pageObj = properties.getPageObj();
	            if (pageObj != null)
	                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
	                             .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
	                             pageObj.getPageSize().intValue());
	        }else{
	            pList.doList(0, -1);
	        }

	        return pList;
	}

	@Override
	public List<CrmConsumer> query(String query, Map params, int begin, int max) {
		// TODO Auto-generated method stub
		return  this.crmConsumerDao.query(query, params, begin, max);
	}

	@Override
	public CrmConsumer getObjByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return (CrmConsumer)this.crmConsumerDao.getBy(propertyName, value);
	}

	@Override
	public CrmConsumer getObjById(Long id) {
		// TODO Auto-generated method stub
		CrmConsumer crmConsumer = (CrmConsumer)this.crmConsumerDao.get(id);
        if (crmConsumer != null){
            return crmConsumer;
        }
		return null;
	}



	@Override
	public boolean uploadingExcel(List<HashMap> listPageData) {
		// TODO Auto-generated method stub
		try {
		for (HashMap pageData : listPageData) {
			CrmConsumer con= new    CrmConsumer();
			CrmContacts crm= new    CrmContacts();
		/*	CrmDev dev=new  CrmDev();
			CrmDev dev2=new  CrmDev();
			CrmDev dev3=new  CrmDev();
			CrmDev dev4=new  CrmDev();
			CrmDev dev5=new  CrmDev();
			CrmDev dev6=new  CrmDev();
			CrmDev dev7=new  CrmDev();
			CrmDev dev8=new  CrmDev();
			CrmDev dev9=new  CrmDev();*/
			   crm.setTruename(pageData.get("var5")+"");
			   crm.setMobile(pageData.get("var6")+"");
			   crm.setTelephone(pageData.get("var7")+"");
			   crm.setSex(pageData.get("var8")+"");
			   crm.setDepartment(pageData.get("var9")+"");
			   crm.setPost(pageData.get("var10")+"");
			   crm.setEmail(pageData.get("var11")+"");
			   crm.setAddress(pageData.get("var13")+"");
			   crm.setConsumer(con);
			
			
			    con.setEnt_name(String.valueOf(pageData.get("var0")));
			    con.setClue_source(pageData.get("var1")+"");
			    con.setGrade(Integer.parseInt(pageData.get("var2")+""));
			    con.setOper_scope(pageData.get("var3")+"");
			    con.setPlatform_type(pageData.get("var4")+"");
			    con.setMain_business(pageData.get("var14")+"");
			    con.setOper_life(pageData.get("var15")+"");
			    con.setSite_area(pageData.get("var16")+"");
			    con.setRented(pageData.get("var17").equals("是")?true:false);
			    con.setOper_address(pageData.get("var18")+"");
			    con.setInvoice(pageData.get("var64")+"");
			    con.setTax_point(pageData.get("var65")+"");
			    con.setNum_workers(pageData.get("var66")+"");
			    con.setMon_turnover(pageData.get("var67")+"");
			    con.setAddTime(new Date());
			    con.setStatus("0");
			    this.crmContactsDao.save(crm);
			    this.crmConsumerDao.save(con);
			 
//			  dev.setDev_name("破碎机数量（台）");
//			   dev.setNumber(Integer.parseInt(pageData.getString("var19")));
//			   dev.setPro_capacity(pageData.getString("var20"));
//			   
//			   dev2.setDev_name("清洗生产线数量（台）");
//			   dev2.setNumber(Integer.parseInt(pageData.getString("var21")));
//			   dev2.setPro_capacity(pageData.getString("var22"));
//			   
//			   dev3.setDev_name("造粒生产线（台）");
//			   dev3.setNumber(Integer.parseInt(pageData.getString("var23")));
//			   dev3.setPro_capacity(pageData.getString("var24"));
//			   
//			   dev4.setDev_name("注塑设备（台）");
//			   dev4.setNumber(Integer.parseInt(pageData.getString("var25")));
//			   dev4.setPro_capacity(pageData.getString("var26"));
//			   
//			   dev5.setDev_name("污水处理系统");
//			   dev5.setNumber(Integer.parseInt(pageData.getString("var27")));
//			   dev5.setPro_capacity(pageData.getString("var28"));
//			   
//			   dev6.setDev_name("打包机");
//			   dev6.setNumber(pageData.getString("var29").equals("有")?1:0);
//			   
//			   dev7.setDev_name("地磅");
//			   dev7.setNumber(pageData.getString("var30").equals("有")?1:0);
//			   
//			   dev8.setDev_name("烟气处理");
//			   dev8.setNumber(pageData.getString("var31").equals("有")?1:0);
//			   
//			   dev9.setDev_name("自有货车数量");
//			   dev9.setNumber(Integer.parseInt(pageData.getString("var32")));
//			   dev9.setLoa_capacity_c(pageData.getString("var33"));
//			   dev9.setLoa_capacity_t(pageData.getString("var34"));
			    
		}
		return true;
		} catch (Exception e) {
			return false;
		}
		
	}

/*
	@Override
	public boolean uploadingExcel(List<HashMap> listPageData) {
		// TODO Auto-generated method stub
		
		for (HashMap pageData : listPageData) {
			CrmConsumer con= new    CrmConsumer();
			CrmContacts crm= new    CrmContacts();
			CrmDev dev=new  CrmDev();
			CrmDev dev2=new  CrmDev();
			CrmDev dev3=new  CrmDev();
			CrmDev dev4=new  CrmDev();
			CrmDev dev5=new  CrmDev();
			CrmDev dev6=new  CrmDev();
			CrmDev dev7=new  CrmDev();
			CrmDev dev8=new  CrmDev();
			CrmDev dev9=new  CrmDev();
			
			    con.setEnt_name(pageData.getString("var0"));
			    con.setClue_source(pageData.getString("var1"));
			    con.setGrade(Integer.parseInt(pageData.getString("var2")));
			    con.setOper_scope(pageData.getString("var3"));
			    con.setPlatform_type(pageData.getString("var4"));
			    con.setMain_business(pageData.getString("var14"));
			    con.setOper_life(pageData.getString("var15"));
			    con.setSite_area(pageData.getString("var16"));
			    con.setRented(pageData.getString("var17").equals("是")?true:false);
			    con.setOper_address(pageData.getString("var18"));
			    this.crmConsumerDao.save(con);
			    crm.setTruename(pageData.getString("var5"));
			   crm.setMobile(pageData.getString("var6"));
			   crm.setTelephone(pageData.getString("var7"));
			   crm.setSex(pageData.getString("var8"));
			   crm.setDepartment(pageData.getString("var9"));
			   crm.setPost(pageData.getString("var10"));
			   crm.setEmail(pageData.getString("var11"));
			   crm.setAddress(pageData.getString("var13"));
			   this.crmContactsDao.save(crm);
//			  dev.setDev_name("破碎机数量（台）");
//			   dev.setNumber(Integer.parseInt(pageData.getString("var19")));
//			   dev.setPro_capacity(pageData.getString("var20"));
//			   
//			   dev2.setDev_name("清洗生产线数量（台）");
//			   dev2.setNumber(Integer.parseInt(pageData.getString("var21")));
//			   dev2.setPro_capacity(pageData.getString("var22"));
//			   
//			   dev3.setDev_name("造粒生产线（台）");
//			   dev3.setNumber(Integer.parseInt(pageData.getString("var23")));
//			   dev3.setPro_capacity(pageData.getString("var24"));
//			   
//			   dev4.setDev_name("注塑设备（台）");
//			   dev4.setNumber(Integer.parseInt(pageData.getString("var25")));
//			   dev4.setPro_capacity(pageData.getString("var26"));
//			   
//			   dev5.setDev_name("污水处理系统");
//			   dev5.setNumber(Integer.parseInt(pageData.getString("var27")));
//			   dev5.setPro_capacity(pageData.getString("var28"));
//			   
//			   dev6.setDev_name("打包机");
//			   dev6.setNumber(pageData.getString("var29").equals("有")?1:0);
//			   
//			   dev7.setDev_name("地磅");
//			   dev7.setNumber(pageData.getString("var30").equals("有")?1:0);
//			   
//			   dev8.setDev_name("烟气处理");
//			   dev8.setNumber(pageData.getString("var31").equals("有")?1:0);
//			   
//			   dev9.setDev_name("自有货车数量");
//			   dev9.setNumber(Integer.parseInt(pageData.getString("var32")));
//			   dev9.setLoa_capacity_c(pageData.getString("var33"));
//			   dev9.setLoa_capacity_t(pageData.getString("var34"));
			    
		}
		return false;
	}*/



}

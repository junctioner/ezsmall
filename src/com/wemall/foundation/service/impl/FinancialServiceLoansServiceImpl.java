package com.wemall.foundation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.dao.FinancialServiceLoansDAO;
import com.wemall.foundation.domain.FinancialServiceLoans;
import com.wemall.foundation.service.IFinancialServiceLoansService;

@Service
@Transactional
public class FinancialServiceLoansServiceImpl implements IFinancialServiceLoansService{
    
	@Resource(name="financialServiceLoansDAO")
	private FinancialServiceLoansDAO financialServiceLoansDAO;
	public boolean save(FinancialServiceLoans financialServiceLoans) {
		try {
			this.financialServiceLoansDAO.save(financialServiceLoans);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

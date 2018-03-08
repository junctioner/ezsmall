package com.wemall.foundation.dao;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.CrmContacts;

@Repository("crmContactsDAO")
public class CrmContactsDAO extends GenericDAO<CrmContacts> {
}

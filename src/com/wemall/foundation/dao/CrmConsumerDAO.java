package com.wemall.foundation.dao;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.Consumer;
import com.wemall.foundation.domain.CrmConsumer;

@Repository("crmConsumerDAO")
public class CrmConsumerDAO extends GenericDAO<CrmConsumer> {
}

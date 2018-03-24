package com.wemall.foundation.dao;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.Store;

@Repository("storeDAO")
public class StoreDAO extends GenericDAO<Store> {
}


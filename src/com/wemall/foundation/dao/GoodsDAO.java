package com.wemall.foundation.dao;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.Goods;

@Repository("goodsDAO")
public class GoodsDAO extends GenericDAO<Goods> {
}


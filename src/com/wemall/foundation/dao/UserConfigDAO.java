package com.wemall.foundation.dao;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.UserConfig;

@Repository("userConfigDAO")
public class UserConfigDAO extends GenericDAO<UserConfig> {
}


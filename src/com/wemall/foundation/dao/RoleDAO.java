package com.wemall.foundation.dao;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.foundation.domain.Role;

@Repository("roleDAO")
public class RoleDAO extends GenericDAO<Role> {
}


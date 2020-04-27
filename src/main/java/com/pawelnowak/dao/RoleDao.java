package com.pawelnowak.dao;

import com.pawelnowak.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}

package com.pawelnowak.service;


import com.pawelnowak.entity.User;
import com.pawelnowak.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}

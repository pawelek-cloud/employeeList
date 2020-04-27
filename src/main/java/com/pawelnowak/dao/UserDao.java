package com.pawelnowak.dao;

import com.pawelnowak.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}

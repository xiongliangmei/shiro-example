package com.gitub.xl137010393.service.impl;

import com.gitub.xl137010393.dao.IUserDao;
import com.gitub.xl137010393.entity.User;
import com.gitub.xl137010393.service.IUserService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}

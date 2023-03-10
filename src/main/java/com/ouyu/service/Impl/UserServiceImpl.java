package com.ouyu.service.Impl;

import com.ouyu.entity.User;
import com.ouyu.mapper.UserMapper;
import com.ouyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author a1315
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Long insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int selectUserName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public int selectByNamePass(String userName, String password) {
        return userMapper.selectByNamePass(userName,password);
    }
}

package com.ouyu.service;

import com.ouyu.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author a1315
 */
public interface UserService {
    Long insertUser(User user);
    int selectUserName(String username);

    int selectByNamePass(String userName,String password);
}

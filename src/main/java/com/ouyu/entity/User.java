package com.ouyu.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author a1315
 */
@Data
public class User {
    private long userId;
    private String userName;
    private String userPassword;
    private String phone;
    private String sex;
    private String userIDNumber;
    private String userRealName;
    private String userPic;
    private byte isRoot;
    private LocalDateTime updateTime;
    private Long operator;

}

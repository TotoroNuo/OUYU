package com.ouyu.mapper;

import com.ouyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author a1315
 */
@Mapper
@Repository
public interface UserMapper {
    /**新建用户*/
    Long insertUser(User user);
    /**判断用户名是否已存在*/
    @Select("SELECT COUNT(userId) FROM oy_user WHERE userName = #{userName}")
    int selectByName(String userName);
    /**登录*/
    @Select("SELECT COUNT(userId) FROM oy_user WHERE userName = #{userName} AND userPassword = #{password}")
    int selectByNamePass(String userName,String password);
}

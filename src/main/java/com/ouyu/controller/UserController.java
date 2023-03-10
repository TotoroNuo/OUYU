package com.ouyu.controller;

import com.ouyu.Utils.BaseContext;
import com.ouyu.Utils.R;
import com.ouyu.entity.User;
import com.ouyu.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author a1315
 */
@RestController
@RequestMapping("/api/user/")
@CrossOrigin
public class UserController {
    private static final int TWO = 2;
    private static final String SEX = "先生";
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 注册
     */
    @PostMapping("/sign")
    public R sign(@RequestBody User user) {
        /**特殊判断用户名*/
        if (userService.selectUserName(user.getUserName()) != 0) {
            return R.error("用户名重复!");
        }
        if (user.getUserIDNumber().equals("")) {
            user.setUserIDNumber(null);
        }
        if (user.getUserRealName().equals("")) {
            user.setUserRealName(null);
        }
        user.setIsRoot(BaseContext.DEFAULT_ROOT);
        if (SEX.equals(user.getSex())) {
            user.setUserPic("123456.png");
        } else {
            user.setUserPic("654321.png");
        }
        user.setUpdateTime(LocalDateTime.now());
        user.setOperator(new Long(10001));
        userService.insertUser(user);
        System.out.println(user.toString());
        System.out.println("getId:" + user.getUserId());
        return R.success("插入成功！");
    }

    /**
     * 检查用户名重复
     */
    @GetMapping("/selectUserName")
    public R selectUserName(HttpServletRequest request, String userName) {
        String token = request.getHeader("token");
        int count = userService.selectUserName(userName);
        if (count != 0) {
            return R.success("-101");
        } else {
            return R.success();
        }
    }
    @PostMapping("/login")
    public R login(@RequestBody User user){
        int count = userService.selectByNamePass(user.getUserName(),user.getUserPassword());
        if (count == 1) {
            return R.success("登录成功！");
        } else if(count == 0) {
            if(userService.selectUserName(user.getUserName())==0){
                return R.error(-2,"用户名不存在！");
            }
            return R.error("账号或密码错误！");
        }else{
            return R.error(-3,"有重名的用户名，请联系管理员删除！");
        }
    }
}

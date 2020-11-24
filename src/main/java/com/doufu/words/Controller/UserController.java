package com.doufu.words.Controller;


import com.doufu.words.Controller.DTO.AdminParamter;
import com.doufu.words.Controller.DTO.UserParamter;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin() // 解决跨域访问
@RequestMapping(value = "user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 获取用户列表
    * */
    @RequestMapping(value = "userList")
    public Result userList(UserParamter userParamter) {
        return userService.userList(userParamter);
    }
    /*
    * 删除用户
    * */
    @RequestMapping(value = "deleteUser")
    public Result deleteUser(UserParamter userParamter) {
        return userService.deleteUser(userParamter);
    }



}

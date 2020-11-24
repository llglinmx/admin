package com.doufu.words.Controller;

import com.doufu.words.Controller.DTO.AdminParamter;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin() // 解决跨域访问
@RequestMapping(value = "admin")
@RestController
public class AdminController {
@Autowired
private AdminService adminService;

    /*
     * 管理员登录
     * */
    @RequestMapping(value = "login")
    public Result login(AdminParamter userParamter){
        return adminService.login(userParamter);
    }

}

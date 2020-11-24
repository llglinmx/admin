package com.doufu.words.ServiceImpl;

import com.doufu.words.Controller.DTO.AdminParamter;

import com.doufu.words.Dao.AdminRepository;
import com.doufu.words.Domain.Admin;
import com.doufu.words.Model.vo.MD5Util;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Model.vo.TokenUtils;
import com.doufu.words.Service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminRepository adminRepository;

    @Override
    public Result login(AdminParamter adminParamter) {

        MD5Util md5Util = new MD5Util();
        String token = null;
//        Admin admin = adminRepository.findByAdminPhone(adminParamter.getPhone());
        List<Admin> adminList = adminRepository.findAll();

        // 判断是否存在此账号
        if(!adminList.get(0).getAdminPhone().equals(adminParamter.getPhone())){
            return Result.createFail("账号不存在，请先注册");
        }
        String md5 = md5Util.crypt(adminParamter.getPassword());

        if(!md5.equals(adminList.get(0).getPassword())){
            return Result.createFail("密码错误，请重新输入");
        }
        TokenUtils tokenUtils = new TokenUtils();

        Boolean bool = tokenUtils.verify(adminList.get(0).toString());

        if(!bool){ // 判断是否登录超时
            token= tokenUtils.token(adminList.get(0).getAdminPhone(), adminList.get(0).getPassword());
            adminList.get(0).setToken(token);
            adminRepository.save(adminList.get(0));
        }



        return Result.createSuccess("登录成功", true);
    }
}

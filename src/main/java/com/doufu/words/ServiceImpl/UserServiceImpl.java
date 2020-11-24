package com.doufu.words.ServiceImpl;

import com.doufu.words.Controller.DTO.AdminParamter;
import com.doufu.words.Controller.DTO.UserParamter;
import com.doufu.words.Dao.UserRepository;
import com.doufu.words.Domain.User;
import com.doufu.words.Model.retrunType.PageDate;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;


    @Override
    public Result userList(UserParamter userParamter) {

        Integer pagesIndex = userParamter.getPageIndex() - 1;
        Integer pageSize = userParamter.getPageSize();
        Pageable pageable = PageRequest.of(pagesIndex, pageSize);
        PageDate pageDate = new PageDate();


        Long count = null;
        List<User> userList = null;

        if (userParamter.getToken().equals("") || userParamter.getToken() == null) {
            return Result.createFail("失败,token对象不存在");
        }

        //搜索框搜索
        if (!userParamter.getSearch().isEmpty()) {
            count = userRepository.countAllByPhoneContaining(userParamter.getSearch());// 获取总条数
            userList = userRepository.findAllByPhoneContaining(userParamter.getSearch(), pageable);
            pageDate.setCount(count);
            pageDate.setPageIndex(pagesIndex);
            pageDate.setPageSize(pageSize);
            // 数据是否等于0
            if (userList.size() <= 0) {
                return Result.createFail("暂无数据");
            }
            pageDate.setDataList(userList);
            return Result.createSuccess("用户列表获取成功", pageDate);
        }

        // 通过判断 是否vip 获取对应的列表
        if (userParamter.getIsMember() != null) {
            if (userParamter.getIsMember().equals(0) || userParamter.getIsMember().equals(1)) {
                count = userRepository.countAllByIsVip(userParamter.getIsMember());// 获取总条数
                userList = userRepository.findAllByIsVip(userParamter.getIsMember(), pageable);
                pageDate.setCount(count);
                pageDate.setPageIndex(pagesIndex);
                pageDate.setPageSize(pageSize);
                // 数据是否等于0
                if (userList.size() <= 0) {
                    return Result.createFail("暂无数据");
                }
                pageDate.setDataList(userList);
                return Result.createSuccess("用户列表获取成功", pageDate);
            }
        }

        //全部数据
        count = userRepository.count();// 获取总条数
        userList = userRepository.findAllByOrderByCreateTimeDesc(pageable);

        pageDate.setCount(count);
        pageDate.setPageIndex(pagesIndex);
        pageDate.setPageSize(pageSize);

        pageDate.setDataList(userList);
        if (userList.size() <= 0) {
            return Result.createFail("暂无数据");
        }
        return Result.createSuccess("用户列表获取成功", pageDate);
    }

    @Override
    public Result deleteUser(UserParamter userParamter) {

        Integer user = userRepository.deleteAllByUserId(userParamter.getUserId());

        return Result.createSuccess("用户删除成功", true);
    }

}

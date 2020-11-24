package com.doufu.words.Service;

import com.doufu.words.Controller.DTO.AdminParamter;
import com.doufu.words.Controller.DTO.UserParamter;
import com.doufu.words.Model.vo.Result;

public interface UserService {
    Result userList(UserParamter userParamter);
    Result deleteUser(UserParamter userParamter);
}

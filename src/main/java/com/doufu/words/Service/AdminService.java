package com.doufu.words.Service;

import com.doufu.words.Controller.DTO.AdminParamter;
import com.doufu.words.Model.vo.Result;

public interface AdminService {
    Result login(AdminParamter userParamter);
}

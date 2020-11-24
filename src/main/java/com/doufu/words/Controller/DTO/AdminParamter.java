package com.doufu.words.Controller.DTO;

import lombok.Data;

@Data
public class AdminParamter {

    private String token; // token
    private String phone;//用户手机号
    private String password;//用户密码
}

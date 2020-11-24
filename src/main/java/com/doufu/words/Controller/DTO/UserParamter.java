package com.doufu.words.Controller.DTO;

import lombok.Data;

@Data
public class UserParamter {
    private Integer userId;//用户id
    private String token; // token
    private Integer isMember;//是否会员
    private String search;// 搜索框内容
    private Integer pageIndex;//
    private Integer pageSize;
}

package com.doufu.words.Model.retrunType;

import lombok.Data;

@Data
public class PageDate {
    private Integer pageIndex;//当前页码
    private Integer pageSize;//当前请求数据条数
    private Long count;//总条数
    private Object dataList;// 列表数据
}

package com.doufu.words.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;// 用户id

    private String userName;//用户名

    private String phone;//用户手机号

    private String userImage;//用户头像

    private Integer userIntegral;//用户积分

    private Integer isVip;//是否vip  0 不是 1是

    private Date createTime;// 创建时间

    private Date updateTime;// 更新时间

}

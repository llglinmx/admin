package com.doufu.words.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", columnDefinition = "Integer COMMENT '管理员id'")
    private Integer AdminId;// 管理员id

    @Column(name = "admin_name", columnDefinition = "char(10) COMMENT '管理员名称'")
    private String adminName;//管理员名称

    @Column(name = "password", columnDefinition = "varchar(255) COMMENT '管理员密码'")
    private String password;//管理员密码

    @Column(name = "admin_phone", columnDefinition = "char(15) COMMENT '管理员手机号'")
    private String adminPhone;//管理员手机号

    @Column(name = "admin_image", columnDefinition = "varchar COMMENT '管理员头像'")
    private String adminImage;//管理员头像

    @Column(name = "token", columnDefinition = "varchar(255) COMMENT 'token'")
    private String token;// token

    @Column(name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
    private Date createTime;// 创建时间

    @Column(name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
    private Date updateTime;// 更新时间
}

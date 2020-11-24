package com.doufu.words.Dao;

import com.doufu.words.Domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    List<User> findAllByOrderByCreateTimeDesc(Pageable pageable);// 按添加时间倒序输出 并分页

    List<User> findAllByPhoneContaining(String phone,Pageable pageable);//根据手机号查询
    Long countAllByPhoneContaining(String phone);//根据手机号计数

    List<User> findAllByIsVip(Integer member,Pageable pageable);//根据是否vip查询
    Long countAllByIsVip(Integer member);//根据是否vip计数

    Integer deleteAllByUserId(Integer userId);

}

package com.doufu.words.Dao;

import com.doufu.words.Domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin ,Integer> {
    Admin findByAdminPhone(String phone);
    List<Admin> findAll();
}

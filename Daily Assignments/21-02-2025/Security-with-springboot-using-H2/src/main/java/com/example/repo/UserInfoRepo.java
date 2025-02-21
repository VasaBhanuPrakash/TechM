package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer>{

}

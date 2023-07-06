package com.jsp.sp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.sp2.dto.User;

public interface  UserRepository  extends JpaRepository<User, Integer>{

}

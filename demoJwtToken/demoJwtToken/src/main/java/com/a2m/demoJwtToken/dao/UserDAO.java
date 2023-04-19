package com.a2m.demoJwtToken.dao;

import org.apache.ibatis.annotations.Mapper;

import com.a2m.demoJwtToken.entity.*;

@Mapper
public interface UserDAO {

	user SelectUserByUsername(String username);
	
}

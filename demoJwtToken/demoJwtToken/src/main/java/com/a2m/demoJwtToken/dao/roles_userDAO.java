package com.a2m.demoJwtToken.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.a2m.demoJwtToken.entity.*;

@Mapper
public interface roles_userDAO {
	List<String> SelectUserRolesByID(int id);
}

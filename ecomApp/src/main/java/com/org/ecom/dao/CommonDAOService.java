package com.org.ecom.dao;

import java.util.ArrayList;
import java.util.List;

import com.org.ecom.model.UserModel;

//@Repository
public class CommonDAOService {

	// @Autowired
	// JdbcTemplate jdbcTemplate;

	public List<UserModel> getUsers() {

		List<UserModel> users = new ArrayList<>();

		// List<Map<String, Object>> usersMap = jdbcTemplate.queryForList("");

		return users;

	}

}

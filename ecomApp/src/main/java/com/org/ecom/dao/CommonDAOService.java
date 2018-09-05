package com.org.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.ecom.model.UserModel;

@Repository
public class CommonDAOService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<UserModel> getUsers() {
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM USERS");
		List<UserModel> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			UserModel user = new UserModel();
			user.setId(String.valueOf(row.get("ID")));
			user.setFname((String) row.get("FNAME"));
			return user;
		}).forEach((ss) -> {
			usersList.add(ss);
		});
		return usersList;
	}

	public void createUser(UserModel user) {
		jdbcTemplate.update((Connection connection) -> {
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO USERS (FNAME) VALUES (?)");
				preparedStatement.setString(1, user.getFname());
			} catch (Exception e) {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				throw (e);
			}
			return preparedStatement;
		});
	}

}

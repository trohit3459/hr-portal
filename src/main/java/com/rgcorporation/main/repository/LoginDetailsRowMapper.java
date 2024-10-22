package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.LoginDetails;

@Component
public class LoginDetailsRowMapper implements RowMapper<LoginDetails> {

	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		int userId = rs.getInt("USER_ID");
		String password = rs.getString("PASSWORD");
		String role = rs.getString("ROLE");

		LoginDetails loginDetails = new LoginDetails(userId, "******", role);

		return loginDetails;
	}

}

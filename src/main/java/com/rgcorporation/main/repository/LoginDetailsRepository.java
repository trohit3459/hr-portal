package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.LoginDetails;

@Repository
public class LoginDetailsRepository implements LoginDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	LoginDetailsRowMapper loginDetailsRowMapper;

	private static final String INSERT_LOGIN_DETAILS = "INSERT INTO LOGIN_DETAILS(USER_ID,PASSWORD ,ROLE) VALUES(?,?,?)";
	private static final String SELECT_ALL_LOGIN_DETAILS = "SELECT * FROM LOGIN_DETAILS";
	private static final String SELECT_SINGLE_LOGIN_DETAILS = "SELECT * FROM LOGIN_DETAILS WHERE USER_ID = ?";
	private static final String UPDATE_LOGIN_DETAILS = "UPDATE LOGIN_DETAILS SET ROLE = ?" + "WHERE USER_ID = ?";
	private static final String DELETE_LOGIN_DETAILS = "DELETE LOGIN_DETAILS WHERE USER_ID = ?";
	private static final String LOGIN = "SELECT * FROM LOGIN_DETAILS WHERE USER_ID = ? AND PASSWORD = ?";

	int resultCount;

	@Override
	public boolean addNewLoginDetails(LoginDetails loginDetails) {
//		System.out.println("inserting login details into database");
//		System.out.println(loginDetails);

		Object[] args = { loginDetails.getRole() };

		resultCount = jdbcTemplate.update(INSERT_LOGIN_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateLoginDetailsByLoginId(LoginDetails loginDetails) {
		Object[] args = { loginDetails.getRole() };
		resultCount = jdbcTemplate.update(UPDATE_LOGIN_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteLoginDetailsByLoginId(int loginId) {
		Object[] args = { loginId };
		resultCount = jdbcTemplate.update(DELETE_LOGIN_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public LoginDetails getLoginDetailsByLoginId(int loginId) {
		Object[] args = { loginId };
		LoginDetails loginDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_LOGIN_DETAILS, args,
				new LoginDetailsRowMapper());
		return loginDetails;
	}

	@Override
	public List<LoginDetails> getAllLoginDetails() {
		List<LoginDetails> allEmployees = jdbcTemplate.query(SELECT_ALL_LOGIN_DETAILS, new LoginDetailsRowMapper());
		return allEmployees;

	}

	@Override
	public LoginDetails login(LoginDetails loginDetails) {

		try {
			Object[] args = { loginDetails.getUserId(), loginDetails.getPassword() };
			LoginDetails loginDetails2 = jdbcTemplate.queryForObject(LOGIN, loginDetailsRowMapper, args);
			return loginDetails2;
		} catch (Exception e) {
			return new LoginDetails();
		}

	}

}

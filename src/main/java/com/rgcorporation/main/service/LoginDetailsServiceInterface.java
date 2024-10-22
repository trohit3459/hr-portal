package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.LoginDetails;

public interface LoginDetailsServiceInterface {

	public boolean addNewLoginDetails(LoginDetails loginDetails);

	public boolean updateLoginDetailsByLoginId(LoginDetails loginDetails);

	public boolean deleteLoginDetailsByLoginId(int loginId);

	public LoginDetails getLoginDetailsByLoginId(int loginId);

	public List<LoginDetails> getAllLoginDetails();

	public LoginDetails login(LoginDetails loginDetails);

}

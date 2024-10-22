package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.LoginDetails;

public interface LoginDetailsRepositoryInterface {

	public boolean addNewLoginDetails(LoginDetails loginDetails);

	public boolean updateLoginDetailsByLoginId(LoginDetails loginDetails);

	public boolean deleteLoginDetailsByLoginId(int loginId);

	public LoginDetails getLoginDetailsByLoginId(int loginId);

	public List<LoginDetails> getAllLoginDetails();

	public LoginDetails login(LoginDetails loginDetails);
}

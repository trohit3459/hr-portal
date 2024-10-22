package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.LoginDetails;
import com.rgcorporation.main.repository.LoginDetailsRepositoryInterface;

@Service
public class LoginDetailsService implements LoginDetailsServiceInterface {

	@Autowired
	private LoginDetailsRepositoryInterface loginDetailsRepository;

	@Override
	public boolean addNewLoginDetails(LoginDetails loginDetails) {

		return loginDetailsRepository.addNewLoginDetails(loginDetails);
	}

	@Override
	public boolean updateLoginDetailsByLoginId(LoginDetails loginDetails) {

		return loginDetailsRepository.updateLoginDetailsByLoginId(loginDetails);
	}

	@Override
	public boolean deleteLoginDetailsByLoginId(int loginId) {

		return loginDetailsRepository.deleteLoginDetailsByLoginId(loginId);
	}

	@Override
	public LoginDetails getLoginDetailsByLoginId(int loginId) {

		return loginDetailsRepository.getLoginDetailsByLoginId(loginId);
	}

	@Override
	public List<LoginDetails> getAllLoginDetails() {

		return loginDetailsRepository.getAllLoginDetails();
	}

	@Override
	public LoginDetails login(LoginDetails loginDetails) {

		return loginDetailsRepository.login(loginDetails);
	}

}

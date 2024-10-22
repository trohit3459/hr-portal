package com.rgcorporation.main.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.LoginDetails;
import com.rgcorporation.main.service.LoginDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("logindetails")
public class LoginDetailsController {
	
	@Autowired
	private LoginDetailsServiceInterface loginDetailsService;
	
//	@RequestMapping(value = "logindetail" ,method = RequestMethod.POST )
//	public boolean addNewLoginDetails(@RequestBody LoginDetails loginDetails) {
//		return loginDetailsService.addNewLoginDetails(loginDetails);
//	}

	@RequestMapping(value = "logindetail" , method = RequestMethod.GET)
	public List<LoginDetails> getAllLoginDetails(){
		System.out.println("getAllLoginDetails");
		return loginDetailsService.getAllLoginDetails();
	}

	@RequestMapping(value = "logindetail/{userid}" , method = RequestMethod.GET )
	public LoginDetails getLogindetails(@PathVariable int userid) {
		return loginDetailsService.getLoginDetailsByLoginId(userid);
	}
	
	@RequestMapping( value = "logindetail" , method = RequestMethod.POST )
	public LoginDetails login(@RequestBody LoginDetails loginDetails) {
		
		
		System.out.println(loginDetails);
		return loginDetailsService.login(loginDetails);
		
	}
}

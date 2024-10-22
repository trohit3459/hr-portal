package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.EmployeeDetails;
import com.rgcorporation.main.service.EmployeeDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("employeedetails")
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsServiceInterface employeeDetailsServiceInterface;
	
	@RequestMapping(value = "employeedetail" , method = RequestMethod.GET)
	public List<EmployeeDetails> employeeDetails(){
		System.out.println("in controller");
		return employeeDetailsServiceInterface.getAllEmployee();
	}
	
	@RequestMapping(value = "employeedetail/{employeeId}" , method = RequestMethod.GET)
	public EmployeeDetails getDetails(@PathVariable int employeeId) {
		return employeeDetailsServiceInterface.getEmployeeByEmployeeId(employeeId);
	}
	
	@RequestMapping(value = "employeebyuserid/{userid}" , method = RequestMethod.GET)
	public EmployeeDetails getEmployeeByUserId(@PathVariable int userid){
		return employeeDetailsServiceInterface.getEmployeeByUserId(userid);
	}
	
	
	@RequestMapping(value = "employeebyprojectid/{projectid}" , method = RequestMethod.GET)
	public EmployeeDetails getProjectDetail(@PathVariable int projectid){
		return employeeDetailsServiceInterface.getProjectDetail(projectid);
	}
	
	@RequestMapping(value = "employeebyskill" , method = RequestMethod.POST)
	public List<EmployeeDetails> getAllEmployeeByMatchingSkills(@RequestBody EmployeeDetails employeeDetails){
		
		return employeeDetailsServiceInterface.getAllEmployeeBySkills(employeeDetails);
	}
	
	@RequestMapping(value = "updateprojectid", method = RequestMethod.PUT)
	public boolean updateProjectId(@RequestBody EmployeeDetails employeeDetails) {
		return employeeDetailsServiceInterface.updateProjectId(employeeDetails);
	}
}

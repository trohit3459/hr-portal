package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.RequirementRequestDetails;
import com.rgcorporation.main.service.RequirementRequestDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("requirementrequestdetails")
public class RequirementRequestDetailsController {

	@Autowired
	private RequirementRequestDetailsServiceInterface requestDetailsServiceInterface;

	@RequestMapping(value = "requirementrequestdetail", method = RequestMethod.GET)
	public List<RequirementRequestDetails> getAllRequirementRequest() {
		return requestDetailsServiceInterface.getAllRequirementRequest();
	}

	@RequestMapping(value = "requirementrequestdetail/{requirementrequestid}", method = RequestMethod.GET)
	public RequirementRequestDetails getRequirementRequestByRequirementRequestId(
			@PathVariable int requirementrequestid) {
		return requestDetailsServiceInterface.getRequirementRequestByRequirementRequestId(requirementrequestid);
	}

	@RequestMapping(value = "requirementrequestdetail", method = RequestMethod.POST)
	public boolean addNewRequirementRequest(@RequestBody RequirementRequestDetails requirementRequestDetails) {
		return requestDetailsServiceInterface.addNewRequirementRequest(requirementRequestDetails);
	}

	@RequestMapping(value = "requirementrequestdetail", method = RequestMethod.PUT)
	public boolean updateEmployee(@RequestBody RequirementRequestDetails requirementRequestDetails) {
		return requestDetailsServiceInterface.updateRequirementRequestByRequirementRequestId(requirementRequestDetails);
	}

	@RequestMapping(value = "requirementrequestdetail/{requirementrequestid}", method = RequestMethod.DELETE)
	public boolean deleteRequirementRequestByRequirementRequestId(@PathVariable int requirementrequestid) {
		return requestDetailsServiceInterface.deleteRequirementRequestByRequirementRequestId(requirementrequestid);
	}

	@RequestMapping(value = "requirementrequestdetailbyprojectid/{projectid}", method = RequestMethod.GET)
	public List<RequirementRequestDetails> getAllRequirementRequestUsingProjectId(@PathVariable int projectid) {
		return requestDetailsServiceInterface.getAllRequirementRequestUsingProjectId(projectid);
	}

	@RequestMapping(value = "updaterequirementrequestdetailstatus", method = RequestMethod.PUT)
	public boolean updateRequirementRequestDetailStatus(
			@RequestBody RequirementRequestDetails requirementRequestDetails) {
		return requestDetailsServiceInterface.updateRequirementRequestDetailStatus(requirementRequestDetails);

	}
	

	@RequestMapping(value = "updaterequirementrequestdetailstatusasselected", method = RequestMethod.PUT)
	public boolean updateRequirementRequestDetailStatusAsSelected(
			@RequestBody RequirementRequestDetails requirementRequestDetails) {
		return requestDetailsServiceInterface.updateRequirementRequestDetailStatusAsSelected(requirementRequestDetails);

	}

	@RequestMapping(value = "requirementrequestdetailasselected", method = RequestMethod.GET)
	public List<RequirementRequestDetails> getAllRequirementRequestAsSelected() {
		return requestDetailsServiceInterface.getAllRequirementRequestAsSelected();
	}
	
	@RequestMapping(value = "requirementrequestdetailasinprocess", method = RequestMethod.GET)
	public List<RequirementRequestDetails> getAllRequirementRequestAsInprocess() {
		return requestDetailsServiceInterface.getAllRequirementRequestAsInprocess();
	}

	
	@RequestMapping(value = "requirementrequestdetailasnew", method = RequestMethod.GET)
	public List<RequirementRequestDetails> getAllRequirementRequestAsNew() {
		return requestDetailsServiceInterface.getAllRequirementRequestAsNew();
	}


	@RequestMapping(value = "getallnewrequirementrequestusingemployeeid/{employeeid}", method = RequestMethod.GET)
	public List<RequirementRequestDetails> getAllNewRequirementRequestUsingEmployeeId(@PathVariable int employeeid) {
		return requestDetailsServiceInterface.getAllNewRequirementRequestUsingEmployeeId(employeeid);
	}
	
	@RequestMapping(value = "updaterequirementrequestdetails" , method = RequestMethod.PUT)
	public boolean updateRequirementRequestByRequirementRequestId(@RequestBody RequirementRequestDetails requirementRequestDetails) {
		return requestDetailsServiceInterface.updateRequirementRequestByRequirementRequestId(requirementRequestDetails);

	}
	
	
}

package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.CandidateDetails;
import com.rgcorporation.main.service.CandidateDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("candidatedetails")
public class CandidateDetailsController {

	@Autowired
	private CandidateDetailsServiceInterface candidateDetailsServiceInterface;

	@RequestMapping(value = "candidatedetail", method = RequestMethod.GET)
	public List<CandidateDetails> getInterviewDetails() {
		return candidateDetailsServiceInterface.getAllCandidateDetails();
	}

	@RequestMapping(value = "candidatedetail/{candidateid}", method = RequestMethod.GET)
	public CandidateDetails getDetails(@PathVariable int candidateid) {
		return candidateDetailsServiceInterface.getCandidateDetailsByCandidateId(candidateid);
	}

	@RequestMapping(value = "candidatedetail", method = RequestMethod.POST)
	public boolean addNewCandidateDetails(@RequestBody CandidateDetails candidateDetails) {
		return candidateDetailsServiceInterface.addNewCandidateDetails(candidateDetails);
	}

	@RequestMapping(value = "inprocesscandidatedetail", method = RequestMethod.PUT)
	public boolean updateCandidateDetailsByStatus(@RequestBody CandidateDetails candidateDetails) {
		return candidateDetailsServiceInterface.updateCandidateDetailsByStatus(candidateDetails);
	}

	@RequestMapping(value = "inprocesscandidatedetail", method = RequestMethod.GET)
	public List<CandidateDetails> getAllInprocessCandidateDetails() {
		return candidateDetailsServiceInterface.getAllInprocessCandidateDetails();
	}

	@RequestMapping(value = "newcandidatedetail", method = RequestMethod.GET)
	public List<CandidateDetails> getAllNewCandidateDetails() {
		return candidateDetailsServiceInterface.getAllNewCandidateDetails();
	}

	@RequestMapping(value = "selectedcandidatedetail", method = RequestMethod.GET)
	public List<CandidateDetails> getAllSelectedCandidateDetails() {
		return candidateDetailsServiceInterface.getAllSelectedCandidateDetails();
	}

	@RequestMapping(value = "rejectedcandidatedetail", method = RequestMethod.GET)
	public List<CandidateDetails> getAllRejectedCandidateDetails() {
		return candidateDetailsServiceInterface.getAllRejectedCandidateDetails();
	}

	@RequestMapping(value = "pendingcandidatedetail", method = RequestMethod.GET)
	public List<CandidateDetails> getAllPendingCandidateDetails() {
		return candidateDetailsServiceInterface.getAllPendingCandidateDetails();
	}

// @PostMapping(value = "saveUserProfile")
	@RequestMapping(value = "sendemail", method = RequestMethod.POST)
	public boolean sendmailByStatus(@RequestBody CandidateDetails candidateDetails) {
		return candidateDetailsServiceInterface.sendmailByStatus(candidateDetails);
	}

}

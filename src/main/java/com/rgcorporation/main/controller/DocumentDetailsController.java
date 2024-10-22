package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rgcorporation.main.model.DocumentDetails;
import com.rgcorporation.main.repository.DocumentDetailsRepository;
import com.rgcorporation.main.service.DocumentDetailsSeviceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("documentdetails")
public class DocumentDetailsController {

	
	@Autowired
	private DocumentDetailsSeviceInterface documentDetailsSeviceInterface;
	
	@Autowired
	private DocumentDetailsRepository documentDetailsRepository;
	
	@RequestMapping(value = "documentdetail" , method = RequestMethod.GET)
	public List<DocumentDetails> getAllDocumentDetails(){
		return documentDetailsSeviceInterface.getAllDocumentDetails();
	}
	
	@RequestMapping(value = "documentdetail/{documentId}" , method = RequestMethod.GET)
	public DocumentDetails getDetails(@PathVariable int documentId) {
		return documentDetailsSeviceInterface.getDocumentDetailsByDocumentId(documentId);
	}
	@PostMapping(value = "saveUserProfile")
	public ResponseEntity<String> uploadFile(@RequestParam("resume") MultipartFile file, @RequestParam("user") String user){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());

		try {
			
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
			}
			if (!file.getContentType().equals("application/pdf")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only PDF allowed");
			}
			
			boolean f = documentDetailsRepository.uploadFile(file);
			
			if (f) {
				//return ResponseEntity.ok("File is successfully uploaded");
				
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/pdf/").path(file.getOriginalFilename()).toUriString());
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Someting Went Wrong! Try Again");

	
		
		//return new ResponseEntity<Response>(new Response(), HttpStatus.OK);
	}
	
}

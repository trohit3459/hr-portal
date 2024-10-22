package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.DocumentDetails;
import com.rgcorporation.main.repository.DocumentDetailsRepositoryInterface;

@Service
public class DocumentDetailsSevice implements DocumentDetailsSeviceInterface {

	@Autowired
	private DocumentDetailsRepositoryInterface documentDetailsRepository;

	@Override
	public boolean addNewDocumentDetails(DocumentDetails documentDetails) {

		return documentDetailsRepository.addNewDocumentDetails(documentDetails);
	}

	@Override
	public boolean updateDocumentDetailsByDocumentId(DocumentDetails documentDetails) {

		return documentDetailsRepository.updateDocumentDetailsByDocumentId(documentDetails);
	}

	@Override
	public boolean deleteDocumentDetailsByDocumentId(int documentId) {

		return documentDetailsRepository.deleteDocumentDetailsByDocumentId(documentId);
	}

	@Override
	public DocumentDetails getDocumentDetailsByDocumentId(int documentId) {

		return documentDetailsRepository.getDocumentDetailsByDocumentId(documentId);
	}

	@Override
	public List<DocumentDetails> getAllDocumentDetails() {

		return documentDetailsRepository.getAllDocumentDetails();
	}

}

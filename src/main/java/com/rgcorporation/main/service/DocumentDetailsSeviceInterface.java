package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.DocumentDetails;

public interface DocumentDetailsSeviceInterface {

	public boolean addNewDocumentDetails(DocumentDetails documentDetails);

	public boolean updateDocumentDetailsByDocumentId(DocumentDetails documentDetails);

	public boolean deleteDocumentDetailsByDocumentId(int documentId);

	public DocumentDetails getDocumentDetailsByDocumentId(int documentId);

	public List<DocumentDetails> getAllDocumentDetails();
}

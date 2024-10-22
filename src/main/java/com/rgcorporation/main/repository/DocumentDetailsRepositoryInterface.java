package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.DocumentDetails;

public interface DocumentDetailsRepositoryInterface {

	public boolean addNewDocumentDetails(DocumentDetails documentDetails);

	public boolean updateDocumentDetailsByDocumentId(DocumentDetails documentDetails);

	public boolean deleteDocumentDetailsByDocumentId(int documentId);

	public DocumentDetails getDocumentDetailsByDocumentId(int documentId);

	public List<DocumentDetails> getAllDocumentDetails();

}

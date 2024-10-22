package com.rgcorporation.main.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.rgcorporation.main.model.DocumentDetails;

@Repository
public class DocumentDetailsRepository implements DocumentDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DocumentDetailsRowMapper documentDetailsRowMapper;

	private static final String INSERT_DOCUMENT_DETAILS = "INSERT INTO DOCUMENTS_DETAILS(DOCUMENT_TYPE, CANDIDATE_ID, DOCUMENT) VALUES(?,?,?,?)";
	private static final String SELECT_ALL_DOCUMENT_DETAILS = "SELECT * FROM DOCUMENTS_DETAILS";
	private static final String SELECT_SINGLE_DOCUMENT_DETAIL = "SELECT * FROM DOCUMENTS_DETAILS WHERE DOCUMENT_ID = ?";
	private static final String UPDATE_DOCUMENT_DETAILS = "UPDATE DOCUMENTS_DETAILS SET DOCUMENTS_TYPE = ?, CANDIDATE_ID = ?, DOCUMENT = ?"
			+ "	WHERE DOCUMENT_ID = ?";
	private static final String DELETE_DOCUMENT_DETAILS = "DELETE DOCUMENTS_DETAILS WHERE DOCUMENT_ID = ?";

	int resultCount;

	@Override
	public boolean addNewDocumentDetails(DocumentDetails documentDetails) {
//		System.out.println("inserting document details into database");
//		System.out.println(documentDetails);

		Object[] args = { documentDetails.getDocumentType(), documentDetails.getCandidateId(),
				documentDetails.getDocument() };

		resultCount = jdbcTemplate.update(INSERT_DOCUMENT_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean updateDocumentDetailsByDocumentId(DocumentDetails documentDetails) {

		Object[] args = { documentDetails.getDocumentType(), documentDetails.getCandidateId(),
				documentDetails.getDocument(), documentDetails.getDocumentId() };
		resultCount = jdbcTemplate.update(UPDATE_DOCUMENT_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteDocumentDetailsByDocumentId(int documentId) {

		Object[] args = { documentId };
		resultCount = jdbcTemplate.update(DELETE_DOCUMENT_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public DocumentDetails getDocumentDetailsByDocumentId(int documentId) {

		Object[] args = { documentId };
		DocumentDetails documentDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_DOCUMENT_DETAIL,
				documentDetailsRowMapper, args);
		return documentDetails;
	}

	@Override
	public List<DocumentDetails> getAllDocumentDetails() {

		List<DocumentDetails> allDocumentsDetails = jdbcTemplate.query(SELECT_ALL_DOCUMENT_DETAILS,
				documentDetailsRowMapper);
		return allDocumentsDetails;
	}

	// public final String UPLOAD_DIR
	// ="E:\\Training\\HrPortal\\src\\main\\resources\\static\\pdf";

	public final String UPLOAD_DIR = new ClassPathResource("static/pdf/").getFile().getAbsolutePath();

	public DocumentDetailsRepository() throws IOException {

	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;

		try {

//			InputStream is = multipartFile.getInputStream();
//			byte data[]= new byte[is.available()];
//			is.read(data);
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();

			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
	}
}

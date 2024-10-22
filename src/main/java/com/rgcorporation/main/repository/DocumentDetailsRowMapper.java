package com.rgcorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.CandidateDetails;
import com.rgcorporation.main.model.DocumentDetails;

@Component
public class DocumentDetailsRowMapper implements RowMapper<DocumentDetails> {

	@Autowired
	CandidateDetailsRepository candidateDetailsRepository;
//	@Autowired
//	DocumentDetailsRepository documentDetailsRepository;

	@Override
	public DocumentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		int documentId = rs.getInt("DOCUMENT_ID");
		String documentType = rs.getString("DOCUMENT_TYPE");
		int candidateId = rs.getInt("CANDIDATE_ID");
		byte[] document = rs.getBytes("DOCUMENT");
		CandidateDetails candidateDetails = candidateDetailsRepository
				.getCandidateDetailsByCandidateId(rs.getInt("CANDIDATE_ID"));

		DocumentDetails documentDetails = new DocumentDetails(documentId, documentType, candidateId, document,
				candidateDetails);

		return documentDetails;
	}

}

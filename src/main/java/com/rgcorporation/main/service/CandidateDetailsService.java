package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.CandidateDetails;
import com.rgcorporation.main.repository.CandidateDetailsRepositoryInterface;

@Service
public class CandidateDetailsService implements CandidateDetailsServiceInterface {

	@Autowired
	private CandidateDetailsRepositoryInterface candidateDetailsRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public boolean addNewCandidateDetails(CandidateDetails candidateDetails) {
		// TODO Auto-generated method stub
		return candidateDetailsRepository.addNewCandidateDetails(candidateDetails);
	}

	@Override
	public boolean updateCandidateDetailsByCandidateId(CandidateDetails candidateDetails) {
		// TODO Auto-generated method stub
		return candidateDetailsRepository.updateCandidateDetailsDetailsByCandidateId(candidateDetails);
	}

	@Override
	public boolean deleteCandidateDetailsByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return candidateDetailsRepository.deleteCandidateDetailsDetailsByCandidateId(candidateId);
	}

	@Override
	public CandidateDetails getCandidateDetailsByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return candidateDetailsRepository.getCandidateDetailsByCandidateId(candidateId);
	}

	@Override
	public List<CandidateDetails> getAllCandidateDetails() {
		// TODO Auto-generated method stub
		return candidateDetailsRepository.getAllCandidateDetails();
	}

	@Override
	public boolean updateCandidateDetailsByStatus(CandidateDetails candidateDetails) {
		// TODO Auto-generated method stub
		return candidateDetailsRepository.updateCandidateDetailsByStatus(candidateDetails);
	}

	@Override
	public List<CandidateDetails> getAllInprocessCandidateDetails() {
		return candidateDetailsRepository.getAllInprocessCandidateDetails();
	}

	@Override
	public List<CandidateDetails> getAllNewCandidateDetails() {
		return candidateDetailsRepository.getAllNewCandidateDetails();
	}

	@Override
	public List<CandidateDetails> getAllSelectedCandidateDetails() {
		return candidateDetailsRepository.getAllSelectedCandidateDetails();
	}

	@Override
	public List<CandidateDetails> getAllRejectedCandidateDetails() {
		return candidateDetailsRepository.getAllRejectedCandidateDetails();
	}

	@Override
	public List<CandidateDetails> getAllPendingCandidateDetails() {
		return candidateDetailsRepository.getAllPendingCandidateDetails();
	}

	@Override
	public boolean updateCandidateDetailsDetailsByCandidateId(String status, int candidateId) {
		return candidateDetailsRepository.updateCandidateDetailsDetailsByCandidateId(status, candidateId);
	}

	@Override
	public boolean sendmailByStatus(CandidateDetails candidateDetails) {
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo(candidateDetails.getEmail());
			System.out.println(candidateDetails.getEmail());
			mailMessage.setSubject("Result");

			if (candidateDetails.getStatus().equalsIgnoreCase("SELECTED")) {
				mailMessage.setText("Hi " + candidateDetails.getCandidateName() + "" + "\r\n"
						+ "Welcome to Mindgate Family!\r\n" + "\r\n"
						+ "It was great interacting with you in the whole interview process. I really liked your attitude of being so down to earth and supportive with high level of patience shown from your end during the whole offer process.\r\n"
						+ "\r\n"
						+ "I am sure you might have had great interaction with all who were part of panel regarding company future approach and that might have left an great impact on you.\r\n"
						+ "\r\n"
						+ "We have Established in 2008, with home to 750+ passionate payment professional into Digital Product Payments space. You may get to know more about us on (www.mindgate.in)\r\n"
						+ "\r\n"
						+ "Having you on-board will be an add-on to Mindgate’ s Success story, as we believe you to be an important part of Mindgate family who would extend support to help us take Mindgate to next level.\r\n"
						+ "\r\n" + "Its pleasure offering you the position of “Trainee Developer”, Mumbai location.\r\n"
						+ "\r\n" + "Looking to start from  2nd july, 2022 onwards\r\n" + "\r\n"
						+ "Joining Formalities will be Face to face.");
				javaMailSender.send(mailMessage);

			}
			if (candidateDetails.getStatus().equalsIgnoreCase("REJECTED")) {
				mailMessage.setText("Thank you for taking the time to consider Mindgate pvt ltd.\r\n"
						+ "We wanted to let you know that we have chosen to move forward \r\n"
						+ "with a different candidate for the Developer position.\r\n"
						+ "Our team was impressed by your skills and accomplishments. \r\n"
						+ "We think you could be a good fit for other future openings and \r\n"
						+ "will reach out again if we find a good match.\r\n"
						+ "We wish you all the best in your job search and future \r\n" + "professional endeavors.\r\n"
						+ "");
				javaMailSender.send(mailMessage);
			}
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

}

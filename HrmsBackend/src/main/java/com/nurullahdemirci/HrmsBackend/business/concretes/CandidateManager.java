package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.nurullahdemirci.HrmsBackend.business.abstracts.CandidateService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeInCandidateService;
import com.nurullahdemirci.HrmsBackend.core.utilities.adapters.abstracts.EmailControlService;
import com.nurullahdemirci.HrmsBackend.core.utilities.adapters.abstracts.MernisService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.AllDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.CandidateDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Candidate;
import com.nurullahdemirci.HrmsBackend.entities.dtos.CandidateDto;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private VerificationCodeInCandidateService verificationCodeInCandidateService;
	private MernisService mernisService;
	private EmailControlService emailControlService;
	
	@Autowired
	public CandidateManager(
			CandidateDao candidateDao, 
			VerificationCodeInCandidateService verificationCodeInCandidateService, 
			MernisService mernisService, 
			EmailControlService emailControlService){
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeInCandidateService = verificationCodeInCandidateService;
		this.mernisService = mernisService;
		this.emailControlService = emailControlService;
	}
	
	@Override
	public List<Result> register(Candidate candidate) {
		AllDataResult<Candidate> allDataResult = new AllDataResult<Candidate>();
		allDataResult=checkAllFields(candidate);
		
		if(allDataResult.getSuccess()) {
			
			this.candidateDao.save(candidate);
			allDataResult.addResult(new SuccessResult("Candidate User Generated."));
			
			if(emailVerification(candidate.getId()) == true) {
				allDataResult.addResult(new SuccessResult("Verification Code has been Sent."));
				return allDataResult.getSuccessResults();
			} else {
				allDataResult.addResult(new ErrorResult("Verification Code has not been Sent."));
				return allDataResult.getErrorResults();
			}
				
		}
		
		return allDataResult.getErrorResults();
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidate User Listed.");
	}
	
	@Override
	public AllDataResult<Candidate> checkAllFields(Candidate candidate) {
		AllDataResult<Candidate> allDataResult = new AllDataResult<Candidate>();

		if(Strings.isNullOrEmpty(candidate.getEmail())==true)
			allDataResult.addResult(new ErrorResult("Email Address is Empty."));
		
		else if(checkEmailControl(candidate.getEmail()) == false)
			allDataResult.addResult(new ErrorResult("Email Address not Correct!"));

		else if(checkEmail(candidate.getEmail()) == false)
			allDataResult.addResult(new ErrorResult("In Memory has this Email Address!"));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(candidate.getPassword())==true)
			allDataResult.addResult(new ErrorResult("Password is Empty. Do not empty!"));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(candidate.getFirstName())==true)
			allDataResult.addResult(new ErrorResult("First Name is Empty."));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(candidate.getLastName())==true)
			allDataResult.addResult(new ErrorResult("Last Name is Empty."));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(candidate.getIdentityNumber())==true)
			allDataResult.addResult(new ErrorResult("Identity Number is Empty."));
		
		else if(checkIdentity(candidate.getIdentityNumber()) ==  false)
			allDataResult.addResult(new ErrorResult("In Memory has this Identity Number!"));
		
		else if(mernisVerification(candidate.getIdentityNumber()) == false)
			allDataResult.addResult(new ErrorResult("Identity Number is not Correct!"));
		
		/* ----------------------------------------------------------------------------- */
		
		if(candidate.getBirthDate() == null) 
			allDataResult.addResult(new ErrorResult("Birth Date is Empty."));
		
		/* ----------------------------------------------------------------------------- */
		
		return allDataResult;
	}
	
	@Override
	public Boolean checkEmail(String email) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
			if(candidate.getEmail().equals(email)) {
				return false;
			}				
		}
		return true;
	}
	
	@Override
	public Boolean checkEmailControl(String email) {
		return this.emailControlService.emailControl(email);
	}
	
	@Override
	public Boolean mernisVerification(String identityNumber) {
		return this.mernisService.verification(identityNumber);
	}
	
	@Override
	public Boolean checkIdentity(String identityNumber) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
			if(candidate.getIdentityNumber().equals(identityNumber)) {
				return false;
			}				
		}
		return true;
	}

	@Override
	public Boolean emailVerification(Integer candidateUserId) {
		if(this.verificationCodeInCandidateService.send(candidateUserId).getSuccess())
			return true;
		else
			return false;
	}

	@Override
	public DataResult<Candidate> getById(Integer candidateId) {
		return new SuccessDataResult<Candidate>(candidateDao.getById(candidateId));
	}

	@Override
	public DataResult<CandidateDto> getByCandidateDtoId(Integer candidateId) {
		return new SuccessDataResult<CandidateDto>(this.candidateDao.getByCandidateDtoId(candidateId), "");
	}

}

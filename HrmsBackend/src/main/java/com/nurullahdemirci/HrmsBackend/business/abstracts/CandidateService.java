package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.AllDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Candidate;
import com.nurullahdemirci.HrmsBackend.entities.dtos.CandidateDto;

public interface CandidateService {
	
	List<Result> register(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getById(Integer candidateId);
	
	DataResult<CandidateDto> getByCandidateDtoId(Integer candidateId);
	
	AllDataResult<Candidate> checkAllFields(Candidate candidate);
	
	Boolean checkEmail(String email);
	
	Boolean emailVerification(Integer candidateUserId);
	
	Boolean mernisVerification(String identityNumber);
	
	Boolean checkIdentity(String identityNumber);
	
	Boolean checkEmailControl(String email);
	
}

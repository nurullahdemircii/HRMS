package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeCandidate;

public interface VerificationCodeCandidateService {
	
	DataResult<List<VerificationCodeCandidate>> getAll();
	
	public Result send(Integer candidateUserId);
	
}

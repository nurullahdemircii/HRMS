package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeInCandidate;

public interface VerificationCodeInCandidateService {

	DataResult<List<VerificationCodeInCandidate>> getAll();
	
	Result send(Integer userId);
	
}
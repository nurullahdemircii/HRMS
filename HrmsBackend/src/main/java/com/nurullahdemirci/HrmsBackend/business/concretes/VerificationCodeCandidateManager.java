package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeCandidateService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.VerificationCodeCandidateDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService{

	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao, VerificationCodeService verificationCodeService){
		this.verificationCodeCandidateDao = verificationCodeCandidateDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<VerificationCodeCandidate>> getAll() {
		return new SuccessDataResult<List<VerificationCodeCandidate>>(this.verificationCodeCandidateDao.findAll(), "Verification Codes Listed.");
	}

	@Override
	public Result send(Integer candidateUserId) {
		
		String code;
		code = this.verificationCodeService.generatedCode();
		
		VerificationCodeCandidate newCode = new VerificationCodeCandidate();
		
		newCode.setCandidateId(candidateUserId);
		newCode.setCode(code);
		newCode.setIs_verified(true);
		
		this.verificationCodeCandidateDao.save(newCode);
		
		List<VerificationCodeCandidate> verificationCodeCandidates = getAll().getData();
		for(VerificationCodeCandidate verificationCodeCandidate : verificationCodeCandidates) {
			if(verificationCodeCandidate.getId().equals(newCode.getId())) {
				return new SuccessResult("Verification Codes has been Sent.");
			}				
		}
		return new ErrorResult("Verification Codes has not been Sent.");
	}

}

package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeInCandidateService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.VerificationCodeInCandidateDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeInCandidate;

@Service
public class VerificationCodeInCandidateManager implements VerificationCodeInCandidateService{

	private VerificationCodeInCandidateDao verificationCodeInCandidateDao;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public VerificationCodeInCandidateManager(VerificationCodeInCandidateDao verificationCodeInCandidateDao, VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeInCandidateDao = verificationCodeInCandidateDao;
		this.verificationCodeService = verificationCodeService;
	}
	
	@Override
	public DataResult<List<VerificationCodeInCandidate>> getAll() {
		return new SuccessDataResult<List<VerificationCodeInCandidate>>(this.verificationCodeInCandidateDao.findAll(), "Verification Codes Listed.");
	}

	@Override
	public Result send(Integer userId) {
		String code;
		code = this.verificationCodeService.generatedCode();
		
		VerificationCodeInCandidate newCode = new VerificationCodeInCandidate();
	
		newCode.setId(userId);
		newCode.getVerificationCodeIC().setCode(code);
		newCode.getVerificationCodeIC().setIsVerified(true);
		
		this.verificationCodeInCandidateDao.save(newCode);
		
		List<VerificationCodeInCandidate> verificationCodeInCandidates = getAll().getData();
		for(VerificationCodeInCandidate verificationCodeInCandidate : verificationCodeInCandidates) {
			if( verificationCodeInCandidate.getVerificationCodeIC().getId().equals(newCode.getVerificationCodeIC().getId()) )
				return new SuccessResult("Verification Codes has been Sent.");
		}
		return new ErrorResult("Verification Codes has not been Sent.");
	}

}
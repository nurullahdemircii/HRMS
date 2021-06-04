package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeEmployerService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.VerificationCodeEmployerDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService{

	private VerificationCodeEmployerDao verificationCodeEmployerDao;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao, VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeEmployerDao = verificationCodeEmployerDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<VerificationCodeEmployer>> getAll(){
		return new SuccessDataResult<List<VerificationCodeEmployer>>(this.verificationCodeEmployerDao.findAll(), "Verification Codes Listed.");
	}
	
	@Override
	public Result send(Integer employerUserId) {
		
		String code;
		code = this.verificationCodeService.generatedCode();
		
		VerificationCodeEmployer newCode = new VerificationCodeEmployer();
		
		newCode.setEmployerId(employerUserId);
		newCode.setCode(code);
		newCode.setIs_verified(true);
		
		this.verificationCodeEmployerDao.save(newCode);
		
		List<VerificationCodeEmployer> verificationCodeEmployers = getAll().getData();
		for(VerificationCodeEmployer verificationCodeEmployer : verificationCodeEmployers) {
			if( verificationCodeEmployer.getId().equals(newCode.getId()) )
				return new SuccessResult("Verification Codes has been Sent.");
		}
		return new ErrorResult("Verification Codes has not been Sent.");
	}
	
}

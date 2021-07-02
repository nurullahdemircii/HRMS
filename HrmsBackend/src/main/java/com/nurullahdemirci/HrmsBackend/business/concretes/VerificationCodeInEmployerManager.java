package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeInEmployerService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.EmployerDao;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.VerificationCodeDao;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.VerificationCodeInEmployerDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCode;
import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeInEmployer;

@Service
public class VerificationCodeInEmployerManager  implements VerificationCodeInEmployerService{

	private VerificationCodeInEmployerDao verificationCodeInEmployerDao;
	private VerificationCodeService verificationCodeService;
	private VerificationCodeDao verificationCodeDao;
	private EmployerDao employerDao;
	
	@Autowired
	public VerificationCodeInEmployerManager(EmployerDao employerDao, VerificationCodeInEmployerDao verificationCodeInEmployerDao, VerificationCodeService verificationCodeService, VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeInEmployerDao = verificationCodeInEmployerDao;
		this.verificationCodeService = verificationCodeService;
		this.verificationCodeDao = verificationCodeDao;
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<VerificationCodeInEmployer>> getAll() {
		return new SuccessDataResult<List<VerificationCodeInEmployer>>(this.verificationCodeInEmployerDao.findAll(), "Verification Codes Listed.");
	}

	@Override
	public Result send(Integer userId) {
		String code;
		code = this.verificationCodeService.generatedCode();
		
//		
		VerificationCode verificationCode = new VerificationCode();
		
		verificationCode.setCode(code);
		verificationCode.setIsVerified(true);
		
		this.verificationCodeDao.save(verificationCode);
		
//		
		VerificationCodeInEmployer newCode = new VerificationCodeInEmployer();
		
		newCode.setEmployerVCIE(employerDao.getById(userId));
		newCode.setVerificationCodeIE(verificationCode);
		
		this.verificationCodeInEmployerDao.save(newCode);
		
		List<VerificationCodeInEmployer> verificationCodeInEmployers = getAll().getData();
		for(VerificationCodeInEmployer verificationCodeInEmployer : verificationCodeInEmployers) {
			if( verificationCodeInEmployer.getVerificationCodeIE().getId().equals(newCode.getVerificationCodeIE().getId()) )
				return new SuccessResult("Verification Codes has been Sent.");
		}
		return new ErrorResult("Verification Codes has not been Sent.");
	}

}
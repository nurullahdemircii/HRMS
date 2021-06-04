package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.nurullahdemirci.HrmsBackend.business.abstracts.EmployerService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeEmployerService;
import com.nurullahdemirci.HrmsBackend.core.utilities.adapters.abstracts.EmailControlService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.AllDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.EmployerDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private VerificationCodeEmployerService verificationCodeEmployerService;
	private EmailControlService emailControlService;
	
	@Autowired
	EmployerManager(EmployerDao employerDao, VerificationCodeEmployerService verificationCodeEmployerService, EmailControlService emailControlService){
		this.employerDao = employerDao;
		this.verificationCodeEmployerService = verificationCodeEmployerService;
		this.emailControlService = emailControlService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer User Listed.");
	}

	@Override
	public List<Result> register(Employer employer) {
		AllDataResult<Employer> allDataResult = new AllDataResult<Employer>();
		allDataResult=checkAllFields(employer);
		
		if(allDataResult.getSuccess()) {
			
			this.employerDao.save(employer);
			allDataResult.addResult(new SuccessResult("Employer User Generated."));
			
			if(emailVerification(employer.getId()) == true) {
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
	public AllDataResult<Employer> checkAllFields(Employer employer) {
		AllDataResult<Employer> allDataResult = new AllDataResult<Employer>();
		
		if(Strings.isNullOrEmpty(employer.getEmail())==true)
			allDataResult.addResult(new ErrorResult("Email Address is Empty."));
		
		if(checkEmailControl(employer.getEmail(), employer.getWebAddress()) == false)
			allDataResult.addResult(new ErrorResult("Email Address not Correct!"));

		if(checkEmail(employer.getEmail()) == false)
			allDataResult.addResult(new ErrorResult("In Memory has this Email Address!"));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(employer.getPassword())==true)
			allDataResult.addResult(new ErrorResult("Password is Empty. Do not empty!"));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(employer.getCompanyName())==true)
			allDataResult.addResult(new ErrorResult("Company Name is Empty."));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(employer.getWebAddress())==true)
			allDataResult.addResult(new ErrorResult("Web Address is Empty."));
		
		/* ----------------------------------------------------------------------------- */
		
		if(Strings.isNullOrEmpty(employer.getPhoneNumber())==true)
			allDataResult.addResult(new ErrorResult("Phone Number is Empty."));
		
		/* ----------------------------------------------------------------------------- */
		
		return allDataResult;
	}

	@Override
	public Boolean checkEmail(String email) {
		List<Employer> employers = getAll().getData();
		for(Employer employer : employers) {
			if(employer.getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean checkEmailControl(String email, String web) {
		return this.emailControlService.emailControlCompany(email, web);
	}

	@Override
	public Boolean emailVerification(Integer employerUserId) {
		if(this.verificationCodeEmployerService.send(employerUserId).getSuccess())
			return true;
		else
			return false;
	}

}

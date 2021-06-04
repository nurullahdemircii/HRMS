package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.AllDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Employer;

public interface EmployerService {

	List<Result> register(Employer employer);
	
	DataResult<List<Employer>> getAll();
	
	AllDataResult<Employer> checkAllFields(Employer employer);
	
	Boolean checkEmail(String email);
	
	Boolean emailVerification(Integer employerUserId);
	
	Boolean checkEmailControl(String email, String web);
	
}

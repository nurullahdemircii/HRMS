package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeLanguage;

public interface ResumeLanguageService {

	DataResult<List<ResumeLanguage>> getAll();
	
	Result create(ResumeLanguage resumeLanguage);
	
}
package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeLanguageService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.ResumeLanguageDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeLanguage;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeLanguageDto;

@Service
public class ResumeLanguageManager implements ResumeLanguageService {
	
	private ResumeLanguageDao resumeLanguageDao;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.findAll(), "");
	}

	@Override
	public Result create(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<ResumeLanguageDto>> getByResumeLanguageInCandidateId(Integer candidateId) {
		return new SuccessDataResult<List<ResumeLanguageDto>>(this.resumeLanguageDao.getByResumeLanguageInCandidateId(candidateId), "");
	}

}

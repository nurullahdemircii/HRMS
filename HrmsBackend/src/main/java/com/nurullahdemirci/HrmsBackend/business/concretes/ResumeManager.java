package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.ResumeDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Resume;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public Result create(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("");
	}
		
	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "");
	}

	@Override
	public DataResult<List<ResumeDto>> getAllResumeInCandidate(Integer candidateId) {
		return new SuccessDataResult<List<ResumeDto>>(this.resumeDao.getAllResumeInCandidate(candidateId));
	}
	
}
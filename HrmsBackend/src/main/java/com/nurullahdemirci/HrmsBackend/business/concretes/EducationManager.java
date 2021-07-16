package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.EducationService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.EducationDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Education;
import com.nurullahdemirci.HrmsBackend.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result create(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("");
	}
	
	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "");
	}

	@Override
	public DataResult<List<EducationDto>> getAllEducationsWithCandidateOrderByGraduationDate() {
		return new SuccessDataResult<List<EducationDto>>(this.educationDao.getAllEducationsWithCandidateOrderByGraduationDate());
	}

	@Override
	public DataResult<List<EducationDto>> getByEducationInCandidateId(Integer candidateId) {
		return new SuccessDataResult<List<EducationDto>>(this.educationDao.getByEducationInCandidateId(candidateId), "");
	}
	
}

package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.ExperienceService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.ExperienceDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Experience;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ExperienceDto;

@Service
public class ExperienceManager implements ExperienceService {

private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result create(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("");
	}
	
	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "");
	}

	@Override
	public DataResult<List<ExperienceDto>> getByExperienceInCandidateId(Integer candidateId) {
		return new SuccessDataResult<List<ExperienceDto>>(this.experienceDao.getByExperienceInCandidateId(candidateId), "");
	}
	
}

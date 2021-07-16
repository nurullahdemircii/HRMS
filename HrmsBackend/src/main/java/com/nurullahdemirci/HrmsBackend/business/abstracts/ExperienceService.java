package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Experience;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ExperienceDto;

public interface ExperienceService {
	
	DataResult<List<Experience>> getAll();
	
	Result create(Experience experience);
	
	DataResult<List<ExperienceDto>> getByExperienceInCandidateId(Integer candidateId);
	
}

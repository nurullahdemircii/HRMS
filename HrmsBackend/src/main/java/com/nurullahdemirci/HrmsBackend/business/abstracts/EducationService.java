package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Education;
import com.nurullahdemirci.HrmsBackend.entities.dtos.EducationDto;

public interface EducationService {
	
	DataResult<List<Education>> getAll();
	
	Result create(Education education);
	
	DataResult<List<EducationDto>> getAllEducationsWithCandidateOrderByGraduationDate();
	
	DataResult<List<EducationDto>> getByEducationInCandidateId(Integer candidateId);

}

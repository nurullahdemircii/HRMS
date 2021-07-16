package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeTechnology;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeTechnologyDto;

public interface ResumeTechnologyService {

	DataResult<List<ResumeTechnology>> getAll();
	
	Result create(ResumeTechnology resumeTechnology);
	
	DataResult<List<ResumeTechnologyDto>> getByResumeTechnologyInCandidateId(Integer candidateId);
	
}
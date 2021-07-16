package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeSocialMedia;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeSocialMediaDto;

public interface ResumeSocialMediaService {

	DataResult<List<ResumeSocialMedia>> getAll();
	
	Result create(ResumeSocialMedia resumeSocialMedia);
	
	DataResult<List<ResumeSocialMediaDto>> getByResumeSocialMediaInCandidateId(Integer candidateId);
	
}
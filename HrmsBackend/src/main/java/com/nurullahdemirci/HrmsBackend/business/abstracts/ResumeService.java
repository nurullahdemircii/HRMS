package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Resume;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeDto;

public interface ResumeService {

	DataResult<List<Resume>> getAll();
	
	Result create(Resume resume);
	
	DataResult<List<ResumeDto>> getAllResumeInCandidate(Integer candidateId);
	
}

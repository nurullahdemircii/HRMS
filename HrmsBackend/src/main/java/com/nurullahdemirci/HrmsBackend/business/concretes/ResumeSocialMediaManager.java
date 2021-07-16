package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeSocialMediaService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.ResumeSocialMediaDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeSocialMedia;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeSocialMediaDto;

@Service
public class ResumeSocialMediaManager implements ResumeSocialMediaService {

	private ResumeSocialMediaDao resumeSocialMediaDao;
	
	@Autowired
	public ResumeSocialMediaManager(ResumeSocialMediaDao resumeSocialMediaDao) {
		super();
		this.resumeSocialMediaDao = resumeSocialMediaDao;
	}

	@Override
	public DataResult<List<ResumeSocialMedia>> getAll() {
		return new SuccessDataResult<List<ResumeSocialMedia>>(this.resumeSocialMediaDao.findAll(), "");
	}

	@Override
	public Result create(ResumeSocialMedia resumeSocialMedia) {
		this.resumeSocialMediaDao.save(resumeSocialMedia);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<ResumeSocialMediaDto>> getByResumeSocialMediaInCandidateId(Integer candidateId) {
		return new SuccessDataResult<List<ResumeSocialMediaDto>>(this.resumeSocialMediaDao.getByResumeSocialMediaInCandidateId(candidateId), "");
	}
	
}

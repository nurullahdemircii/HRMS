package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeTechnologyService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.ResumeTechnologyDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeTechnology;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeTechnologyDto;

@Service
public class ResumeTechnologyManager implements ResumeTechnologyService {

	private ResumeTechnologyDao resumeTechnologyDao;
	
	@Autowired
	public ResumeTechnologyManager(ResumeTechnologyDao resumeTechnologyDao) {
		super();
		this.resumeTechnologyDao = resumeTechnologyDao;
	}
	
	@Override
	public DataResult<List<ResumeTechnology>> getAll() {
		return new SuccessDataResult<List<ResumeTechnology>>(this.resumeTechnologyDao.findAll(), "") ;
	}

	@Override
	public Result create(ResumeTechnology resumeTechnology) {
		this.resumeTechnologyDao.save(resumeTechnology);
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<ResumeTechnologyDto>> getByResumeTechnologyInCandidateId(Integer candidateId) {
		return new SuccessDataResult<List<ResumeTechnologyDto>>(this.resumeTechnologyDao.getByResumeTechnologyInCandidateId(candidateId), "");
	}

}

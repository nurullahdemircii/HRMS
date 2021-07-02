package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.JobAdvertisementService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.JobAdvertisementDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.JobAdvertisement;
import com.nurullahdemirci.HrmsBackend.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllIsActiveFalse() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
			this.jobAdvertisementDao.getAllIsActive(false),
			"1 Data Listed."
		);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
			this.jobAdvertisementDao.getAllIsActive(true),
			"2 Data Listed."
		);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllCreatedAtAndIsActiveTrue(LocalDate createdAt) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
			this.jobAdvertisementDao.getAllCreatedAtAndIsActive(createdAt, true),
			"3 Data Listed."
		);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllEmployerIdAndIsActiveTrue(Integer employerId) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
			this.jobAdvertisementDao.getAllEmployerIdAndIsActive(employerId, true),
			"4 Data Listed."
		);
	}

	@Override
	public Result setIsActiveFalse(Integer jobAdvertisementId) {
		this.jobAdvertisementDao.setIsActive(false, jobAdvertisementId);
		return new SuccessResult("Job Advertisement is Set to Passive.");
	}

	@Override
	public Result setIsActiveTrue(Integer jobAdvertisementId) {
		this.jobAdvertisementDao.setIsActive(true, jobAdvertisementId);
		return new SuccessResult("Job Advertisement is Set to Active.");
	}

}

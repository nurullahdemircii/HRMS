package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.JobAdvertisement;
import com.nurullahdemirci.HrmsBackend.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
//	DTOS
	
	DataResult<List<JobAdvertisementDto>> getAllIsActiveFalse();
	
	DataResult<List<JobAdvertisementDto>> getAllIsActiveTrue();
	
	DataResult<List<JobAdvertisementDto>> getAllCreatedAtAndIsActiveTrue(LocalDate createdAt);
	
	DataResult<List<JobAdvertisementDto>> getAllEmployerIdAndIsActiveTrue(Integer employerId);
	
	Result setIsActiveFalse(Integer jobAdvertisementId);
	
	Result setIsActiveTrue(Integer jobAdvertisementId);
	
}

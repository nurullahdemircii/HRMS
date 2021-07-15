package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.SchoolTypeService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.SchoolTypeDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.SchoolType;

@Service
public class SchoolTypeManager implements SchoolTypeService{

	private SchoolTypeDao schoolTypeDao;
	
	@Autowired
	public SchoolTypeManager(SchoolTypeDao schoolTypeDao) {
		super();
		this.schoolTypeDao = schoolTypeDao;
	}

	@Override
	public Result create(SchoolType schoolType) {
		this.schoolTypeDao.save(schoolType);
		return new SuccessResult("");
	}
	
	@Override
	public DataResult<List<SchoolType>> getAll() {
		return new SuccessDataResult<List<SchoolType>>(this.schoolTypeDao.findAll(), "");
	}
	
}

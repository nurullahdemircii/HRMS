package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.CityService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.CityDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao; 
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("City Added.");
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "City Listed.");
	}
	
}

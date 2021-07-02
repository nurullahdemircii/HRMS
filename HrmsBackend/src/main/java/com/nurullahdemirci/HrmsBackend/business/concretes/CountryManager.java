package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.CountryService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.CountryDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Country;

@Service
public class CountryManager implements CountryService{

	private CountryDao countryDao;
	
	@Autowired
	public CountryManager(CountryDao countryDao) {
		super();
		this.countryDao = countryDao;
	}
	
	@Override
	public Result add(Country country) {
		this.countryDao.save(country);
		return new SuccessResult("Country Added.");
	}

	@Override
	public DataResult<List<Country>> getAll() {
		return new SuccessDataResult<List<Country>>(this.countryDao.findAll(), "Country Listed.");
	}

}

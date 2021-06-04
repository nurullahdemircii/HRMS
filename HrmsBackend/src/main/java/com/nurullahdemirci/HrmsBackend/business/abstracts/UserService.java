package com.nurullahdemirci.HrmsBackend.business.abstracts;

import java.util.List;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.entities.concretes.User;

public interface UserService {
	
	public DataResult<List<User>> getAll();

}

package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.BranchService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.BranchDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Branch;

@Service
public class BranchManager implements BranchService {

	private BranchDao branchDao;
	
	@Autowired
	public BranchManager(BranchDao branchDao) {
		super();
		this.branchDao = branchDao;
	}

	@Override
	public Result create(Branch branch) {
		this.branchDao.save(branch);
		return new SuccessResult("");
	}
	
	@Override
	public DataResult<List<Branch>> getAll() {
		return new SuccessDataResult<List<Branch>>(this.branchDao.findAll(), "");
	}
	
}

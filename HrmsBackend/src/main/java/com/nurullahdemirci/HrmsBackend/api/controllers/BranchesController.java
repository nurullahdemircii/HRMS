package com.nurullahdemirci.HrmsBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.business.abstracts.BranchService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Branch;

@RestController
@RequestMapping("/api/branches")
public class BranchesController {
	
	private BranchService branchService;

	@Autowired
	public BranchesController(BranchService branchService) {
		this.branchService = branchService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Branch>> getAll(){
		return this.branchService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Branch branch) {
		return this.branchService.create(branch);
	}
	
}
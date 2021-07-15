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
import com.nurullahdemirci.HrmsBackend.business.abstracts.SchoolTypeService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.SchoolType;

@RestController
@RequestMapping("/api/school_types")
public class SchoolTypesController {
	
	private SchoolTypeService schoolTypeService;

	@Autowired
	public SchoolTypesController(SchoolTypeService schoolTypesService) {
		this.schoolTypeService = schoolTypesService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SchoolType>> getAll(){
		return this.schoolTypeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SchoolType schoolType) {
		return this.schoolTypeService.create(schoolType);
	}
	
}

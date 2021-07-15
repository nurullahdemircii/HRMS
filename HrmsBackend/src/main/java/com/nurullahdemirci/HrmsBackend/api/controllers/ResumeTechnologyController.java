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
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeTechnologyService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeTechnology;

@RestController
@RequestMapping("/api/resume_technologies")
public class ResumeTechnologyController {
	
	private ResumeTechnologyService resumeTechnologyService;

	@Autowired
	public ResumeTechnologyController(ResumeTechnologyService resumeTechnologyService) {
		this.resumeTechnologyService = resumeTechnologyService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeTechnology>> getAll(){
		return this.resumeTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeTechnology resumeTechnology) {
		return this.resumeTechnologyService.create(resumeTechnology);
	}
	
}

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
import com.nurullahdemirci.HrmsBackend.business.abstracts.ExperienceService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.create(experience);
	}
	
}

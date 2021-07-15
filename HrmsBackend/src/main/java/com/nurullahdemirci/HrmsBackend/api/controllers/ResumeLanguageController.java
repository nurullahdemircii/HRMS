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
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeLanguageService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeLanguage;

@RestController
@RequestMapping("/api/resume_languages")
public class ResumeLanguageController {
	
	private ResumeLanguageService resumeLanguageService;

	@Autowired
	public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
		this.resumeLanguageService = resumeLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeLanguage>> getAll(){
		return this.resumeLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeLanguage resumeLanguage) {
		return this.resumeLanguageService.create(resumeLanguage);
	}
	
}

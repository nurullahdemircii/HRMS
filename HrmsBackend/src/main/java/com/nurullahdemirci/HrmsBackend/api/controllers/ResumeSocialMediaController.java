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
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeSocialMediaService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeSocialMedia;

@RestController
@RequestMapping("/api/resume_social_medias")
public class ResumeSocialMediaController {
	
	private ResumeSocialMediaService resumeSocialMediaService;

	@Autowired
	public ResumeSocialMediaController(ResumeSocialMediaService resumeSocialMediaService) {
		this.resumeSocialMediaService = resumeSocialMediaService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeSocialMedia>> getAll(){
		return this.resumeSocialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeSocialMedia resumeSocialMedia) {
		return this.resumeSocialMediaService.create(resumeSocialMedia);
	}
	
}
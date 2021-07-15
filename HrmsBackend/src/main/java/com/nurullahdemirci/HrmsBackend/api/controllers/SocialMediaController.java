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
import com.nurullahdemirci.HrmsBackend.business.abstracts.SocialMediaService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/social_medias")
public class SocialMediaController {
	
	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediaController(SocialMediaService socialMediaService) {
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.create(socialMedia);
	}
	
}
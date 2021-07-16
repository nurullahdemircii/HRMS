package com.nurullahdemirci.HrmsBackend.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorDataResult;
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Resume;

@RestController
@RequestMapping("/api/")
public class ResumesController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.resumeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Resume resume) {
		return ResponseEntity.ok(this.resumeService.create(resume));
	}
	
	@GetMapping(value = "/getall_details_by_candidate")
	public ResponseEntity<?> getByCandidateIdResumeDetails(@RequestParam("candidateId") Integer candidateId){
		return ResponseEntity.ok(this.resumeService.getAllResumeDetailsByCandidateId(candidateId));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>(); // Map<keyValue, errorMessage>
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		
		return errors;
	}
	
}

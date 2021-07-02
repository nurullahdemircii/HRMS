package com.nurullahdemirci.HrmsBackend.api.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.nurullahdemirci.HrmsBackend.business.abstracts.JobAdvertisementService;
import com.nurullahdemirci.HrmsBackend.entities.concretes.JobAdvertisement;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping(value="/api/jobAdvertisements")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	@GetMapping("/getAllIsActiveFalse")
	public ResponseEntity<?> getAllIsActiveFalse(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllIsActiveFalse());
	}
	
	@GetMapping("/getAllIsActiveTrue")
	public ResponseEntity<?> getAllIsActiveTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllIsActiveTrue());
	}
	
	@GetMapping(value="/getAllCreatedAt")
	public ResponseEntity<?> getAllCreatedAt(@RequestParam("createdAt") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdAt){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllCreatedAtAndIsActiveTrue(createdAt));
	}
	
	@GetMapping(value = "/getByEmployerId")
	public ResponseEntity<?> getByEmployerId(@RequestParam("employerId") Integer employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllEmployerIdAndIsActiveTrue(employerId));
	}
	
	@PostMapping(value = "/setIsActiveFalse")
	public ResponseEntity<?> setIsactiveFalse(@RequestParam("jobAdvertisementId") Integer jobAdvertisementId){
		return ResponseEntity.ok(this.jobAdvertisementService.setIsActiveFalse(jobAdvertisementId));
	}
	
	@PostMapping(value = "/setIsActiveTrue")
	public ResponseEntity<?> setIsactiveTrue(@RequestParam("jobAdvertisementId") Integer jobAdvertisementId){
		return ResponseEntity.ok(this.jobAdvertisementService.setIsActiveTrue(jobAdvertisementId));
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

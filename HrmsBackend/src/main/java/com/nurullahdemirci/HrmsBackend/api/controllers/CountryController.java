package com.nurullahdemirci.HrmsBackend.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nurullahdemirci.HrmsBackend.business.abstracts.CountryService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.ErrorDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Country;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	private CountryService countryService;
	
	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
	
	@PostMapping(value="/add")
	public Result add(@Valid @RequestBody Country country) {
		return this.countryService.add(country);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<Country>> getAll(){
		return this.countryService.getAll();
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

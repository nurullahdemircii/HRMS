package com.nurullahdemirci.HrmsBackend.core.utilities.adapters.abstracts;

public interface EmailControlService {

	public Boolean emailControl(String email);
	
	public Boolean emailControlCompany(String email, String web);
	
}

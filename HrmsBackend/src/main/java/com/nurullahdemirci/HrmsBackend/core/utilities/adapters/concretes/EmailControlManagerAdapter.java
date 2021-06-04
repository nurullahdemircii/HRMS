package com.nurullahdemirci.HrmsBackend.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.core.utilities.adapters.abstracts.EmailControlService;
import com.nurullahdemirci.HrmsBackend.emailControl.EmailControlManager;

@Service
public class EmailControlManagerAdapter implements EmailControlService{

	private EmailControlManager emailControlManager = new EmailControlManager();
	
	@Override
	public Boolean emailControl(String email) {
		return emailControlManager.emailControl(email);
	}

	@Override
	public Boolean emailControlCompany(String email, String web) {
		return emailControlManager.emailControlCompany(email, web);
	}
	
}

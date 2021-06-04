package com.nurullahdemirci.HrmsBackend.emailControl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailControlManager {
	
	public Boolean emailControl(String email) {
		String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
			
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
			
		if(matcher.matches())
			return true;
		else
			return false;	
	}
	
	public Boolean emailControlCompany(String email, String web) {
		if(emailControl(email) == true) {
			String[] result = email.split("@");
			if(result[1].equals(web))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
}

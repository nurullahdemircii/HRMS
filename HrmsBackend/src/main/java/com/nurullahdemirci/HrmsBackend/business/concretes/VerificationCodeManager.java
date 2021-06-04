package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.VerificationCodeService;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Override
	public String generatedCode() {
		List<Character> alphabet = new ArrayList<Character>();
		String code="";
		
		for(char i = 'a'; i < 'z'; i++)
			alphabet.add(i);
		
		for(char i = 'A'; i < 'Z'; i++)
			alphabet.add(i);
		
		for(char i = '0'; i < '9'; i++)
			alphabet.add(i);
		
		for (int i=0; i<6; i++){
			String ch = Character.toString(alphabet.get( ((int)(Math.random()*61)) ));
			code = code + ch;
		}
		
		return code;
	}

}

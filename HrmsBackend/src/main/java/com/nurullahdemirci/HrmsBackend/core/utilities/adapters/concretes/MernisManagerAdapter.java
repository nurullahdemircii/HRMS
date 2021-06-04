package com.nurullahdemirci.HrmsBackend.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.core.utilities.adapters.abstracts.MernisService;
import com.nurullahdemirci.HrmsBackend.mernis.MernisManager;

@Service
public class MernisManagerAdapter implements MernisService{

	private MernisManager mernisManager = new MernisManager();
	
	@Override
	public Boolean verification(String identityNumber) {
		return mernisManager.verification(identityNumber);
	}
	
}

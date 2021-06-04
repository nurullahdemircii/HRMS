package com.nurullahdemirci.HrmsBackend.mernis;

public class MernisManager {

	public Boolean verification(String identityNumber) {
		
		if(identityNumber.length() == 11) {
//			long _identityNumber = Long.parseLong(identityNumber);
//			
//			long[] __identityNumber = new long[11];
//			
//			long odd = 0, even = 0, firstTen = 0;
//			
//			for(int i = 10; i >= 0; i--) {
//				__identityNumber[i] = _identityNumber % 10;
//				_identityNumber /= 10;
//			}
//			
//			for(int i = 0; i < 10; i++)
//				firstTen += __identityNumber[i];
//			
//			for(int i = 0; i < 9; i+=2)
//				odd += __identityNumber[i];
//			
//			for(int i = 1; i < 8; i+=2)
//				even += __identityNumber[i];
//			
//			if(__identityNumber[9] == (((odd * 7) + (even * 9)) % 10) ) {
//				if(	__identityNumber[10] == (firstTen % 10) &&
//					__identityNumber[10] == ((odd * 8) % 10)
//				) {
//					return true;
//				}
//				else
//					return false;
//			}
//			else
//				return false;
			
			return true;
		}
		else
			return false;
			
	}
	
}

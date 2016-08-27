package com.ezequiel.training.codingtests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tentativa3 {

	public static void main(String[] args) {
		
		int A = 3;
		int B = 3;
		
		
		System.out.println(testeInteger(A, B));
		
		A = 3;
		B = 28;
		
		System.out.println(testeInteger(A, B));
		
		

		A = 1;
		B = 4;
		
		System.out.println(testeInteger(A, B));
		
		
//		0.10(714285)		
//		0.10 714285714285714

		
	}
	
	
	static String testeInteger(int A, int B){
		
		Pattern integerPattern = Pattern.compile("([0-9])+\\.0+");
		Pattern doublePatternTerminadoEmZero = Pattern.compile("^([0-9])+\\.([0])+([^0])+(0+)$");
		
		
		double d = A/(double)B;
		Matcher matcherInteger = integerPattern.matcher(String.valueOf(d));
		Matcher matcherDouble = doublePatternTerminadoEmZero.matcher(String.valueOf(d));
		
		if(matcherInteger.matches()){
			return matcherInteger.group(1);
		}else if(matcherDouble.matches()){
			return matcherDouble.group(1) + matcherDouble.group(2);
		}
		return "";
	}
}

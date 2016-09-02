package com.ezequiel.training.codingtests.zooplus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.solution("00-44  48 5555 8361"));//new String[]{"", "", ""});
		System.out.println(solution.solution("0 - 22 1985--324"));
		System.out.println(solution.solution("555372654"));
	}

	public String solution(String S) {
		S = S.replaceAll("[\\ \\-]", "");
	
		char[] charArray = S.toCharArray();
		
		StringBuilder sb = new StringBuilder(); 
		if(charArray.length % 3 == 0){
			for (int i = 0; i < charArray.length; i++) {
				if(i%3 == 0 && i != 0){
					sb.append("-");
				}
				sb.append(charArray[i]);
			}
		} else {
			for (int i = 0; i < charArray.length; i++) {
				if(i%3 == 0 && i != 0){
					sb.append("-");
				}
				
				if(charArray.length - i == 4){
					sb.append(charArray[i++]);
					sb.append(charArray[i++]);
					sb.append("-");
					sb.append(charArray[i++]);
					sb.append(charArray[i]);
				} else {
					sb.append(charArray[i]);
				}
			}			
		}
		return sb.toString();
	}
	
	
	public void solution2(String S){
		System.out.println("S: " + S);
		
		S = S.replaceAll("[\\ \\-]", "");
		
		Pattern pattern = Pattern.compile("([0-9]{3})");
		Matcher matcher = pattern.matcher(S);
		
		if(matcher.matches()){
			for (int i = 0; i < matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}
}


//
//System.out.println("S: " + S);
//
//String join = String.join("-", S.split("(^[0-9]{3})+"));
//
//System.out.println("join: " + join);
//
//String[] split = S.split("(^[\\ \\-]{3})");
//
//for (String string : split) {
//	System.out.println(string);
//}


//
//if(charArray.length - i == 4)
//{
//	sb.append(charArray[i++]);
//	sb.append(charArray[i++]);
//	sb.append("-");
//	sb.append(charArray[i++]);
//	sb.append(charArray[i]);
//}
//else if(i%3 == 0 && i != 0)
//{
//	sb.append(charArray[i]);
//} else {
//	sb.append(charArray[i]);
//}
package com.ezequiel.training.codingtests.citi;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	public int solution(String S) {	
		Map<String, Call> callMap = new HashMap<>();
		String[] logLines = S.split("\n");
		
		long theGreatest = 0L;
		String theGreatestKey = null;
		
		for (final String line : logLines) {
			final String[] parts = line.split(",");
			final String key = parts[1];
			long duration = getTime(parts[0]);
			
			Call call = null;
			
			if(callMap.containsKey(key)){
				call = callMap.get(key);
				call.calculate(duration);
			} else {
				call = new Call(key, duration);
				callMap.put(key, call);
			}
			
			if (call.getDuration() > theGreatest || theGreatest == 0) {
				theGreatest = call.getDuration();
				theGreatestKey = call.getNumber();
			} else if(call.getDuration() == theGreatest){
				Integer contestant1 = Integer.parseInt(call.getNumber().replaceAll("-", ""));
				Integer contestant2 = Integer.parseInt(theGreatestKey.replaceAll("-", ""));
				theGreatestKey = contestant1.compareTo(contestant2) < 0 ? call.getNumber() : theGreatestKey; 
			}
		}
		
		callMap.remove(theGreatestKey);
		
		int accumulator = 0;
		for (final Call c : callMap.values()) {
			System.out.println(c);
			accumulator += c.getTotalPrice();
		}
		return accumulator;
	}
	
	private static long getTime(String string) {
		
		String[] split = string.split(":");
		
		long time = 0L;
		
		time += (Long.parseLong(split[0]) * 60 * 60);
		time += (Long.parseLong(split[1]) * 60);
		time += (Long.parseLong(split[2]));
		
		return time;
	}
	

	public static void main(String[] args) {

		final String S = "00:01:07,400-234-090\n"//67 * 3 = 201
				+ "00:05:01,701-080-080\n" //150 * 6 = 900
				+ "00:05:00,400-234-090\n" //150 * 5 = 750   --> 1851
				+ "00:10:00,500-234-090\n"
				+ "01:00:00,666-666-666";

		Solution2 solution = new Solution2();
		System.out.println(solution.solution(S));
	}
}

class Call {
	private final String number;
	private long totalPrice = 0L;
	
	private long totalDuration = 0L;
	private long price;
	
	public Call(final String number, final long duration) {
		this.number = number;
		this.calculate(duration);
	}

	public void calculate(long duration) {
		this.totalDuration += duration; 
		if(duration < 300){
			price = duration * 3;
		} else {
			long minutes = (long)Math.ceil(duration / 60.0);
			price = minutes * 150;
		}
		this.totalPrice += price;
	}

	public long getDuration() {
		return totalDuration;
	}

	public String getNumber() {
		return number;
	}
	
	public long getTotalPrice(){
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "Price: " + price + "; Duration: " + totalDuration + "; Number: " + number;
	}
}




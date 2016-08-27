package com.ezequiel.training.codingtests.citi;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {
	
	static final int MAX_VALUE = Double.valueOf(Math.pow(2, 20)).intValue();

	private static final OperationFactory OPERATION_FACTORY = new OperationFactory(); 
	
	public int solution(final String strings) {		
		
		final Stack<Integer> stack = new Stack<>();
		
		for (final String string : strings.split(" ")) {
			final Operation operation = OPERATION_FACTORY.createOperation(string);
			try {
				operation.execute(stack);				
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}	
		}
		
		if(!stack.isEmpty()){
			return stack.pop();
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("13 DUP 4 POP 5 DUP + DUP + -"));
	}	
}

class OperationFactory{	
	Operation createOperation(String op){
		switch (op) {
		case "POP":
			return new Pop();
		case "DUP":
			return new Dup();
		case "+":
			return new Sum();
		case "-":
			return new Sub();
		default:
			try {
				int value = Integer.parseInt(op);
				return new Push(value);
			} catch (Exception e) {
				return null;
			}
		}
	}
}

interface Operation{
	void execute(Stack<Integer> stack);
}

class Push implements Operation{
	int value;
	public Push(int value) {
		this.value = value;
	}
	@Override
	public void execute(Stack<Integer> stack) {
		stack.push(value);
	}
}

class Pop implements Operation{
	@Override
	public void execute(Stack<Integer> stack) {
		stack.pop();
	}	
}

class Dup implements Operation {
	@Override
	public void execute(Stack<Integer> stack) {
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		stack.push(stack.peek());
	}
}

class Sum implements Operation {

	@Override
	public void execute(Stack<Integer> stack) {
		if (stack.size() < 2) {
			throw new RuntimeException();
		}
		
		final Integer first = stack.pop();
		final Integer second = stack.pop();
		
		int sum = Math.addExact(first, second);
		
		if (sum > Solution.MAX_VALUE) {//1048576
			throw new RuntimeException();
		}
		stack.push(sum);
	}
}

class Sub implements Operation {

	@Override
	public void execute(Stack<Integer> stack) {
		if (stack.size() < 2) {
			throw new RuntimeException();
		}
		int value = stack.pop() - stack.pop();
		
		if (value < 0) {
			throw new RuntimeException();
		}
		
		stack.push(value);
	}
}


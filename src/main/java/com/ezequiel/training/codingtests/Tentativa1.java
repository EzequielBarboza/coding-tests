package com.ezequiel.training.codingtests;

public class Tentativa1 {

	
	public static void main(String[] args) {
		
		int [] A  = {-1, 3, -4, 5, 1, -6, 2, 1};
		System.out.println(resposta(A));
		
//		List<Integer> respostas = new ArrayList<>();
//		
//		for (int i = 0; i < A.length; i++) {
//			long left = 0;
//			long right = 0;
//			for (int j = 0; j < i; j++) {
//				left+=A[j];
//			}
//			for (int j = i+1; j < A.length; j++) {
//				right+=A[j];
//			}
//			if(left == right) {
//				System.out.println("Achou!!! " + i);
//				respostas.add(i);
//			}
//		}
//		if (respostas.isEmpty()) {
//			System.out.println("Nao achou!!!");			
//		}else{
//			System.out.println(Arrays.toString(respostas.toArray()));
//		}
	}
	
	
	private static int resposta(int [] A ) {
		for (int i = 0; i < A.length; i++) {
			long left = 0;
			long right = 0;
			for (int j = 0; j < i; j++) {
				left+=A[j];
			}
			for (int j = i+1; j < A.length; j++) {
				right+=A[j];
			}
			if(left == right) {
				return i;
			}
		}
		return -1;
	}
	
	
}

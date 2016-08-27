package com.ezequiel.training.codingtests;

import java.util.HashSet;


public class Solution2
{
	public int solution(final int[] A)
	{
		int remaining = A.length;

		int largest = 0;
		int localCounter = 0;

		int i = 0;

		BiValue biValue = null;

		while (i < A.length)
		{
			if (biValue == null)
			{
				biValue = new BiValue();
			}

			if (biValue.canInsert(A[i]))
			{
				biValue.add(A[i]);
				localCounter++;
			}
			else
			{
				biValue = null;
				localCounter = 0;
				i--;
				continue;
			}
			if (largest < localCounter)
			{
				largest = localCounter;
			}
			i++;
			remaining--;
			if (largest >= (remaining + localCounter))
			{
				return largest;
			}
		}
		return largest;
	}

	private static class BiValue extends HashSet<Integer>
	{
		public boolean canInsert(final Integer o)
		{
			if (size() < 2)
			{
				return true;
			}
			else
			{
				return super.contains(o);
			}
		}
	}


	public static void main(final String[] args)
	{
		final Solution2 solution2 = new Solution2();

		System.out.println(solution2.solution(new int[]
		{ 5, 4, 4, 5, -1, 6, 7, 8, 9, 10, 11, 12, 13, 1, 3, 2, 9, 10, -12, -11 }));


		System.out.println(solution2.solution(new int[]
		{ 5, 4, 4, 5, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 3, 2, 9, 10, -12, -11 }));


		System.out.println(solution2.solution(new int[]
		{ 5, 4, 4, 5, 4, 5, -11, 5, 4, 4, 5, 4, 5, 4, 5 }));




	}


}

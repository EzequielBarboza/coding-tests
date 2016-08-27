package com.ezequiel.training.codingtests;

class Solution
{
	public int solution(final int[] S)
	{
		int max_sum = 0;
		int current_sum = 0;
		boolean positive = false;
		final int n = S.length;

		for (int i = 0; i < n; ++i)
		{
			final int item = S[i];

			if (item < 0)
			{
				if (max_sum < current_sum)
				{
					max_sum = current_sum;
				}
				current_sum = 0;
			}
			else
			{
				positive = true;
				current_sum += item;
			}
		}
		if (current_sum > max_sum)
		{
			max_sum = current_sum;
		}
		if (positive)
		{
			return max_sum;
		}
		return -1;
	}

	public static void main(final String[] args)
	{
		final Solution solution = new Solution();

		System.out.println(solution.solution(new int[]
		{ 1, 2, 3, -1, 4, 5 }));


		System.out.println(solution.solution(new int[]
		{ -1, -1, -2, 10, 11, -1 }));

		System.out.println(solution.solution(new int[]
		{ -1, 5, -2, 3, -1, 4 }));

	}
}

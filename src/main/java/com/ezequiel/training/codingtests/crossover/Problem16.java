package com.ezequiel.training.codingtests.crossover;

/**
 * @user ezequiel
 * @since 5 de mar de 2016
 */
public class Problem16
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		String fizzBuzz = FizzBuzz(5);
		System.out.println(fizzBuzz);

		System.out.println(FizzBuzz(0));

		System.out.println(FizzBuzz(15));

		System.out.println(FizzBuzz(100));

	}



	static String FizzBuzz(int untilVal)
	{
		final StringBuilder result = new StringBuilder();


		for (int i = 1; i <= untilVal; i++)
		{
			String lineOutput = "";
			if ((i % 3) == 0)
			{
				lineOutput = "Fizz";
			}
			if ((i % 5) == 0)
			{
				lineOutput += "Buzz";
			}
			if (lineOutput.length() == 0)
			{
				lineOutput += String.valueOf(i);
			}
			result.append(lineOutput);

			if (i < untilVal)
			{
				result.append("\n");
			}
		}
		return result.toString();
	}




}

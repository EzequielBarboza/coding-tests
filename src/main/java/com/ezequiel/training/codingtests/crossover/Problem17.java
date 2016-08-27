package com.ezequiel.training.codingtests.crossover;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * @user ezequiel
 * @since 5 de mar de 2016
 */
public class Problem17
{
	
	
	public static void main(String[] args)
	{
		String array[] = new String[]{"foo", "bar", "..", "test/thing", "../bob"};
		System.out.println(createPath(array));
		
		String array2[] = new String[]{"foo", "bar", "..", "test/../thing", "../bob"};
		System.out.println(createPath(array2));
		
	}
	

	static String createPath(String[] pathSegments)
	{
		// You should replace or update the below
		String result  = '/' + Arrays.asList(pathSegments).stream().collect(Collectors.joining("/"));
		
		for (int i = 0; i < pathSegments.length; i++)
		{
			if (pathSegments[i] == null)
			{
				continue;
			}
	
			StringBuilder sb = new StringBuilder();
			for (String string : pathSegments[i].split("/"))
			{
				if("..".equals(string))
				{
					
				}
				sb.append(string);
			}
			
//			if()
		}
		
		
		return "/";
	}
}

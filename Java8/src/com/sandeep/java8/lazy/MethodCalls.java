package com.sandeep.java8.lazy;

import java.util.function.Supplier;

public class MethodCalls
{
	
	public void testMethodCall(Supplier<Integer> test1, Supplier<Integer> test2)
	{
		if(test1.get()>10 && test2.get()>13 )
		{
			System.out.println("Done");
		}
	}
	public static void main(String[] args) 
	{
		new MethodCalls().testMethodCall(() -> 11,()->22);
		
	}

}
  
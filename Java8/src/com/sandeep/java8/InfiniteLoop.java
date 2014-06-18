package com.sandeep.java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteLoop
{
	public static boolean isPrime( final int number)
	{
		return number >1 && IntStream.range(2, (int)Math.sqrt(number)).noneMatch(divisor -> number%divisor == 0);
	}
	
	public static int primeAfter(final int number)
	{
		if(isPrime(number+1))
		{
			return number +1; 
		}
			
		else
		{
			return primeAfter(number+1);
		}
	}
	public static void primes(final int fromNumber, final int count)
	{
		 Stream.iterate(fromNumber, InfiniteLoop::primeAfter).limit(count).collect(Collectors.toList()).forEach(System.out::println);;
	}
	
	public static void main(String[] args) 
	{
		primes(10, 250);
	}

}

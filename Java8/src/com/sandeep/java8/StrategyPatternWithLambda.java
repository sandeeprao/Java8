package com.sandeep.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPatternWithLambda 
{

	public static void main(String[] args)
	{
		
		List<Integer> prices = Arrays.asList(10,20,30,40,50);
		int sum = prices.stream().filter(p -> p <20).reduce(20, Integer::sum); //witout strategy 
		
		System.out.println(new StrategyPatternWithLambda().getTotalValue(prices, (price -> true)));
		System.out.println(new StrategyPatternWithLambda().getTotalValue(prices, (price -> price%2!=0))); // with strargey as predicate
		
		System.out.println(sum);
	}
	
	public int getTotalValue(final List<Integer> prices, Predicate<Integer> strategy)
	{
		return prices.stream().filter(strategy).reduce(0, Integer::sum);
	}
	
}

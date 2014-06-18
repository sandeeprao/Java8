package com.sandeep.java8.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RodCutterBasic 
{
	final List<Integer> prices;
	
	public RodCutterBasic(final List<Integer> pricesForLength)
	{
		prices = pricesForLength;
	}
	public int maxProfit(final int length)
	{
		int profit = (length<=prices.size())?prices.get(length-1):0;
		for (int i =1; i <length; i++)
		{
			int priceWhenCut = maxProfit(i)+maxProfit(length-i);
			if(profit < priceWhenCut) profit = priceWhenCut;
		}
		return profit;
	}
	
	public static void main(String[] args) {
		final List<Integer> cost = Arrays.asList(2,1,1,2,2,2,1,8,9,15);
		final RodCutterBasic rodCutterBasic = new RodCutterBasic(cost);
		System.out.println(rodCutterBasic.maxProfitWithMemoizing(500));
	}
	
	public int maxProfitWithMemoizing(final int rodLength)
	{
		BiFunction<Function<Integer, Integer>, Integer, Integer> compute = ( func, length) -> 
		{
			int profit = (length<=prices.size())?prices.get(length-1):0;
			for (int i =1; i <length; i++)
			{
				int priceWhenCut = func.apply(i) + func.apply(length-i);
				if(profit < priceWhenCut) profit = priceWhenCut;
			}
			return profit;
		};
		return Memoized.callMemoized(compute,rodLength);
	}

}

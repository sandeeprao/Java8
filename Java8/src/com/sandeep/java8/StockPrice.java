package com.sandeep.java8;

import java.math.BigDecimal;
import java.util.function.Function;

public class StockPrice
{
	Function<String,BigDecimal> priceFinder;
	public StockPrice(Function<String,BigDecimal> priceFinder)
	{
		this.priceFinder = priceFinder;
	}
	
	public BigDecimal getPrice(String name , int shares)
	{
		return priceFinder.apply(name).multiply(BigDecimal.valueOf(shares));
	}
	
	public static void main(String[] args) {
		
		StockPrice stockPrice = new StockPrice(name -> BigDecimal.valueOf(10.2));
		System.out.println(stockPrice.getPrice("Goog", 100));
		
		
	}
}

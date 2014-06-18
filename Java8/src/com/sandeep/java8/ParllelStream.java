package com.sandeep.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParllelStream 
{

	public static final List<String> symbols = Arrays.asList("AMD","IBM","VMW","AMZN","GOOG");


	public static void main(String[] args) {

	   long time = System.currentTimeMillis();
		System.out.println( symbols.stream().filter(symbol -> YahooFinance.getPrice(symbol).compareTo(new BigDecimal("100"))>0).sorted().collect(Collectors.joining(",")));
		long endtime = System.currentTimeMillis();
		System.out.println(endtime-time);
	}
}

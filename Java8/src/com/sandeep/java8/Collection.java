package com.sandeep.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Collection
{

	public static void main(String[] args)
	{
		List<String> names = Arrays.asList("Test", "Jav8", "Groovy","Scala");
		names.forEach(name -> System.out.println(name));
		names.forEach((final String name) -> System.out.println(name));
		
		names.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));
		names.stream().map(name -> name.length()).forEach(name -> System.out.println(name));
		names.stream().filter(name->name.length()>5).collect(Collectors.toList()).forEach(System.out::println);;
		
		Predicate<String> lengthGreaterThanFive = name -> name.length()>5;
		
		long count = names.stream().filter(lengthGreaterThanFive).count();
		System.out.println(count);
		
		 long greaterThan4 = names.stream().filter(Collection.checkLength(4)).count();
		 System.out.println(greaterThan4);
		 
		 final Function<Integer, Predicate<String>> checkLengthFunction = length -> name -> name.length() > length;
		 System.out.println(names.stream().filter(checkLengthFunction.apply(4)).count());
		 
		 final Function<Integer, Predicate<String>> checkLengthFunctionVerbose = 
				 ( final Integer length) -> {Predicate<String> greaterThanPredicate = (String name) -> name.length() > length; return greaterThanPredicate;};
				 System.out.println(names.stream().filter(checkLengthFunctionVerbose.apply(4)).count());
		Collection.printNames(2, names);
		
		names.stream().reduce((name1,name2) -> name1.length() >name2.length() ? name1 : name2).ifPresent(System.out::println);
		
		names.stream().mapToInt(name -> name.length()).sum();
		
		//Joining elements
		System.out.println(names.stream().collect(Collectors.joining(",")));;
	}
	
	public static Predicate<String> checkLength(int length)
	{
		return name -> name.length()>length;
	}
	
	public static void printNames(int length, List<String> names)
	{
		names.stream().filter(name -> name.length() > length).findFirst().ifPresent(System.out::println);
	}
	
	
	
}
   
package com.sandeep.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ComparatorAndFilters
{

	public static void main(String[] args) {
		
		String testString = "Java8";
		
		testString.chars().forEach(System.out::println);
		testString.chars().mapToObj(ch -> Character.valueOf((char) ch)).forEach(System.out::println);
		testString.chars().filter(ch -> Character.isDigit(ch)).mapToObj(ch -> Character.valueOf((char) ch)).forEach(System.out::println);
		
		List<Person> persons= Arrays.asList(new Person("Java", 15), new Person("Groovy", 5), new Person("C++", 20), new Person("C", 20));
		
		 persons.stream().sorted((person1,person2) -> person1.ageDiffirence(person2)).collect(Collectors.toList()).forEach(System.out::println);
		 
		 //with instance method
		 
		 persons.stream().sorted(Person::ageDiffirence).collect(Collectors.toList()).forEach(System.out::println);
		
		Comparator<Person> ascendingOrder = Person::ageDiffirence;
		Comparator<Person> descindingOrder = ascendingOrder.reversed();
		
		persons.stream().sorted(descindingOrder).collect(Collectors.toList()).forEach(System.out::println);
		
		Function<Person, String> byName = person -> person.getName();
		Function<Person, Integer> byAge = person -> person.getAge();
		    
		persons.stream().sorted(Comparator.comparing(byAge).thenComparing(byName)).collect(Collectors.toList()).forEach(System.out::println);
		
		//grouping of stmts
		
		persons.stream().filter(person -> person.getAge() > 10).collect(Collectors.groupingBy(Person::getAge)).forEach((k,v)-> System.out.println(k+ "  + " + v) );
		
		persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(byAge))))).forEach((k,v)-> System.out.println(k+ "  + " + v) );
		;
	}
}

package com.sandeep.java8.defaultmethods;

public interface Sail
{
	default void turn(){System.out.println("Sail: turn");}
	default void cruise(){System.out.println("Sail :cruise");}
}

package com.sandeep.java8.defaultmethods;

public interface Fly {

	default void takeoff()
	{ System.out.println("Fly::Take off");

	}
	default void land() { System.out.println("Fly:: land");}
	default void turn(){System.out.println("Fly: turn");}
	default void cruise(){System.out.println("Fly :cruise");}
}

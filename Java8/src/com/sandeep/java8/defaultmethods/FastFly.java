package com.sandeep.java8.defaultmethods;

public interface FastFly  extends Fly
{
	default void takeoff()
	{ System.out.println("FastFly::Take off");

	}

}

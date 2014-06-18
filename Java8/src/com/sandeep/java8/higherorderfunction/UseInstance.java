package com.sandeep.java8.higherorderfunction;

@FunctionalInterface
public interface UseInstance<X,Y extends Throwable>  {
	void accept(X instance) throws Y;

}

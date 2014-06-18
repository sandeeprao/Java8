package com.sandeep.java8.recursion;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Memoized 
{
	public static <T,R> R callMemoized( final BiFunction<Function<T, R>, T, R> function, final T input)
	{
		Function<T, R> memoized = new Function<T, R>() {
			private final HashMap<T,R> store =   new HashMap<T,R>();
			public R apply( final T input)
			{
				return store.computeIfAbsent(input, key->function.apply(this,key));
			}
		};
		return memoized.apply(input);
	}

}

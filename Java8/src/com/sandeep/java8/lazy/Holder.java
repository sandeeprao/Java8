package com.sandeep.java8.lazy;

import java.util.function.Supplier;

public class Holder
{
	private Supplier<Heavy> heavy = () -> createHeavy();

	public Holder()
	{
		System.out.println("Holder created");

	}

	public Heavy getHeavy()
	{
		return heavy.get();
	}

	
	private synchronized Heavy createHeavy()
	{
		class HeavyFactory implements Supplier<Heavy>
		{
			private final Heavy heavyInstance = new Heavy();

			@Override
			public Heavy get() {
				
				return heavyInstance;
			}
			
		}
		
		if(!HeavyFactory.class.isInstance(heavy))
		{
			heavy = new HeavyFactory();
		}
		
		return heavy.get();
	}
	
	public static void main(String[] args) {
		
		new Holder().getHeavy();
	}
}

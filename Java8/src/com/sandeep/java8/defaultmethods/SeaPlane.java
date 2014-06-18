package com.sandeep.java8.defaultmethods;

public class SeaPlane  extends Vehicle implements Sail, FastFly
{
	
	public void cruise(){
		
		System.out.println("Seaplane :cruise");
		FastFly.super.cruise();
		Sail.super.cruise();
		}
	public static void main(String[] args) {
		SeaPlane seaPlane = new SeaPlane();
		seaPlane.cruise();
		seaPlane.takeoff();
		seaPlane.land();
		seaPlane.turn();
		
	}
}

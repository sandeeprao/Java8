package com.sandeep.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListingFiles 
{

	public static void main(String[] args) throws IOException {

		Files.list(Paths.get(".")).forEach(System.out::println);
		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
		
		Files.newDirectoryStream(Paths.get("./src/"),path->path.toString().endsWith(".java")).forEach(System.out::println);
		
	}
}

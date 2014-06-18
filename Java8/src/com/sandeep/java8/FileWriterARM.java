package com.sandeep.java8;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterARM implements AutoCloseable
{
	private final FileWriter writer;
	
	public FileWriterARM(final String filename) throws IOException {
		super();
		this.writer = new FileWriter(filename);
	}
	
	public void writeStuff(String text) throws IOException
	{
		writer.write(text);
	}

	public static void main(String[] args) throws IOException, Exception {
	
		try(final FileWriterARM writerARM = new FileWriterARM("TestFile")){
			writerARM.writeStuff("TESTing");
			
		}
	}

	@Override
	public void close() throws Exception {
		writer.close();
		 
	}

}

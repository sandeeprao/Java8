package com.sandeep.java8.higherorderfunction;

import java.io.FileWriter;
import java.io.IOException;

import com.sandeep.java8.FileWriterARM;

public class FileWriterEAM
{
	private final FileWriter writer;

	public FileWriterEAM(final String filename) throws IOException {
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


	private void close() throws Exception {
		writer.close();

	}
	
	public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws Exception
	{
		final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
		try
		{
			block.accept(writerEAM);
		}
		finally
		{
			writerEAM.close();
		}
	}
	
	




}

package com.techelevator.filesplitter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TextFileSegmentWriter implements FileSegmentWriter {

	private String filename;
	
	public TextFileSegmentWriter(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void write(List<String> lines, int segmentNumber) throws SegmentWriteException {
		
		File segmentFile = new File(filename + "-" + segmentNumber);
	
		try ( PrintWriter printWriter = new PrintWriter( segmentFile );
				BufferedWriter writer = new BufferedWriter( printWriter ) ) {
			
			for (String line: lines) {
				writer.write(line);
				writer.newLine();
			}
			
		} catch (IOException e) {
			throw new SegmentWriteException(e);
		}
				
	}

}

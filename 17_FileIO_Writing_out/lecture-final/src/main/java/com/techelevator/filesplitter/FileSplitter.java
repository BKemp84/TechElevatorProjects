package com.techelevator.filesplitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

	public void split(File fileToSplit, int countToSplit) throws FileNotFoundException, SegmentWriteException {
		
		// loop to write to new file until line count
		// create files
		// writer buffered
	// repeat for next segment
		FileSegmentWriter segmentWriter = new TextFileSegmentWriter( fileToSplit.getAbsolutePath() );
		
		try (Scanner fileScanner = new Scanner(fileToSplit)) {
			// track the line number
			int segment = 0;
			// read the file
			while ( fileScanner.hasNextLine() ) {
				
				List<String> lines = new ArrayList<String>();
				int count = countToSplit;
				while ( count > 0 && fileScanner.hasNextLine() ) {
					lines.add( fileScanner.nextLine() );
					count--;
				}
				
				segment++;
				segmentWriter.write(lines, segment);
				lines = new ArrayList<String>();
				
			}
		

		}
		
	}
	
}

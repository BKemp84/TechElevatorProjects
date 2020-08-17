package com.techelevator.filesplitter;

import java.io.File;
import java.io.FileNotFoundException;

import com.techelevator.filesplitter.view.Menu;

public class FileSplitterCLI {

	private Menu menu = new Menu();
	
	public void run() {
		
		// Ask the user for the filename and the line count
		File inputFile = getInputFile();
		int lineCount = menu.getLineCountToSplitFromUser();
		
		// split the file
		FileSplitter splitter = new FileSplitter();
		try {
			splitter.split(inputFile, lineCount);
		} catch (Exception e) {
			menu.displayUserMessage("An unexpected error occurred");
			throw new RuntimeException(e);
		}
		// write the new files
		
		// tell the user its done
		menu.displayUserMessage("The file has been split");
	}
	
	
	private File getInputFile() {
		File file = null;
		
		while (file == null) {
			String filePath = menu.getFilePathFromUser();
			file = new File(filePath);
			if (!file.exists() || !file.isFile()) {
				file = null;
			}
		}
		
		return file;
	}
	
	
	
	
	public static void main(String[] args) {
		FileSplitterCLI cli = new FileSplitterCLI();
		cli.run();
	}
	
}

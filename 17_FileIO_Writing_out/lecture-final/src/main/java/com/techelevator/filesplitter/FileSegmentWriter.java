package com.techelevator.filesplitter;

import java.util.List;

public interface FileSegmentWriter {
	
	void write(List<String> lines, int segmentNumber) throws SegmentWriteException;
}

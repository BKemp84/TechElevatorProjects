package com.techelevator;

public class HomeworkAssignment {
	private int totalMarks ;
	private int possibleMarks ;
    private String submitterName;
    private String letterGrade;
    
    // constuctor 1 arguments
     public HomeworkAssignment (int possibleMarks) {
          this.possibleMarks = possibleMarks;
          
     }
    
    public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getLetterGrade() {
		//possibleMarks - totalmarks == letterGrade;
		double currentGrade = (double) totalMarks/possibleMarks;
		
		if (currentGrade >= 0.9) {
			return "A";
		}else if (currentGrade >= 0.8) {
			return "B";
		} else if (currentGrade >= 0.7) {
			return "C";
		}else if (currentGrade >= 0.6) {
			return "D";
		}
		
		
		return "F";
	}
    
	

}

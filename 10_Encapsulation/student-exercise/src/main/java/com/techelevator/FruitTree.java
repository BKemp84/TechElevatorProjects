package com.techelevator;

public class FruitTree {
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	
	// constructor 1 argument
   public FruitTree (String typeOfFruit, int startingPiecesOfFruit){
	   this.typeOfFruit = typeOfFruit;
	   this.piecesOfFruitLeft = startingPiecesOfFruit;
  }
	//methods
   public boolean pickFruit(int numberOfPiecesOfToRemove){ 
    	if (piecesOfFruitLeft >= numberOfPiecesOfToRemove) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesOfToRemove;
             return true;
   	} else  { 
   		return false;
   	}
    }

    
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}

	
	
}

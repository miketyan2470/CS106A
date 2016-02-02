/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * Program moves Karel row by row and laying down a beeper on every
 * other corner. 
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		putBeeper();
		fillEast();
	}
	
	private void fillEast() {
		while(frontIsClear()) {
			layBeepers();
		}
		turnLeft();
		if(frontIsClear()) {
			checkCeiling();		
			turnLeft();
			fillWest();
		}
	}

/*
 * layBeepers()
 * Karel moves forward and places beepers on every other corner.
 */
	private void layBeepers() {
		if(beepersPresent()) {
			move();
		} else {
			move();
			putBeeper();
		}
	}

/*
 * checkCeiling() 
 * determines if Karel has reached the top of board and 
 * determines whether or not there will be a beeper on the start of new
 * row.
 */
	private void checkCeiling() {
		if(frontIsClear()) {
			if(beepersPresent()) {
				move();
			} else {
				move();
				putBeeper();
			}
		}
	}
	
	private void fillWest() {
		while(frontIsClear()) {
			layBeepers();
		}
		turnRight();
		if(frontIsClear()) {
			checkCeiling();
			turnRight();
			fillEast();
		}
	}
	
	
}

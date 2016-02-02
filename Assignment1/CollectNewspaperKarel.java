/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * Program will guide Karel to Beeper, pick up beeper, and then return
 * to the starting point in the NW corner of house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		findPaper();
		pickUpPaper();
		backToStart();
	}
	
	private void findPaper() {
		moveToWall();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	
	private void pickUpPaper() {
		pickBeeper();
		turnAround();
	}
	
	private void backToStart() {
		moveToWall();
		turnRight();
		move();
		turnRight();
	}

}

/*
 * File:Katrina.java
 * -----------------
 * Program sends Karel to find debris of homes destroyed by 
 * hurricane Katrina. Karel will then clean up the debris and
 * build a new home centered around the location of debris.
 */

package misc;

import stanford.karel.*;

public class Katrina extends SuperKarel {
	
	public void run() {
		while(frontIsClear()) {
			findDebris();
			clearDebris();
			buildHouse();
		}
	}

/*
 * Moves Karel forward until he finds beeper/debris. 
 */
	
	private void findDebris() {
		while(noBeepersPresent()) {
			move();
		}
	}
	
/*
 * Karel to pick up debris and to position at starting location to build new house.
 */
	
	private void clearDebris() {
		pickBeeper();
		moveBack();
	}

/*
 * Moves Karel one space back and faces forward.
 */
	
	private void moveBack() {
		turnAround();
		move();
		turnAround();
	}
	
/*
 * Karel builds the house from the bottom left corner and ends facing East. If 
 * there is no wall when finished, then Karel will proceed forward. The final if()
 * method prevents Karel from running into wall.
 */
	
	private void buildHouse() {
		turnLeft();
		put3Beepers();
		turnRight();
		move();
		turnRight();
		put3Beepers();
		turnLeft();
		move();
		turnLeft();
		put3Beepers();
		turnAround();
		moveToWall();
		turnLeft();
		if(frontIsClear()) {
			move();
		}
	}
	
/*
 * Karel will place a line of 3 beepers in the direction he is facing.
 */
	
	private void put3Beepers() {
		for (int i = 0; i < 3; i++) {
			putBeeper();
			move();
		}
	}
	
/*
 * Karel will process forward until blocked by a wall.
 */
	
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
}
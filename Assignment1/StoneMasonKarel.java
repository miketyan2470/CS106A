/*
 * File: StoneMasonKarel.java
 * --------------------------
 * Program guides Karel to each column and climbs up while replacing missing stone.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while(frontIsClear()) {
			fixColumn();
			findColumn();
		}
		fixColumn(); //prevents "fencepost" bug by calling method fixColumn at the end of the quad.
	}
	
/*
 * Karel will climb up the column while filling holes and turn around once the ceiling is reached
 * and proceed down until ground floor is reached. The orientation will then be adjusted to face
 * east.
 */
	private void fixColumn() {
		turnLeft();
		findHoles();
		turnAround();
		moveToWall();
		turnLeft();
	}
	
/*
 * Karel will replace missing stones until the ceiling is reached.
 */
	private void findHoles() {
		while(frontIsClear()) {
			fillHoles();
			move();
		}
		fillHoles();
	}
	
/*
 * Method used to check each "nod" for missing stone. No second stone will be placed if stone 
 * already is in place.
 */
	private void fillHoles() {
		if(noBeepersPresent()) {
			putBeeper();
		}
	}
	
/*
 * Method to move Karel to wall.
 */
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	
/*
 * Moves Karel 4 spaces forward to find the next column in any quad with 4 space intervals 
 * between columns.
 */
	private void findColumn() {
		for (int i=0; i<4; i++) {
			move();
		}
	}
	
}

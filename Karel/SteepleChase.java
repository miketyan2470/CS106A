package misc;
/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class SteepleChase extends SuperKarel {

	public void run() {
		for (int i = 0; i < 8; i++) {
			if (frontIsClear()) {
				move();
			} else {
				climbsteeple();
			}
		}
	}
	
	private void climbsteeple() {
		ascendsteeple();
		move();
		descendsteeple();
	}
	
	private void ascendsteeple() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
		turnRight();
	}
	
	private void descendsteeple () {
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
}
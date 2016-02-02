/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * Program will allow Karel to locate the "middle" of the street by using a "shrinking" algorithm that 
 * places beepers on both ends moving one corner closer until middle  is reached. Karel will then 
 * proceed to pick up beepers from each side and stops on "middle" with beeper.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		putBeeper(); //gives Karel a starting marker
		layBeeperRow();
		clearOneSide();
		move();
		clearOneSide();
	}

	private void clearOneSide() {
		clearBeeperRow();
		findMiddle();
	}

/*
 * Method: layBeeperRow() Karel will fill the row with beepers starting from the outside inwards
 * until the middle is reached.
 * Pre-Conditions:
 * - Karel facing east at 1,1 with beeper at corner.
 * Post-Conditions: 
 * - Karel will fill the row from the outside inwards by using method putEndBeeper().
 * - Karel will finish as center position of x axis (if odd number of avenues).
 * - Karel's direction will vary due to number of avenues.
 */
	private void layBeeperRow() {
		while(frontIsClear()) {
			move();
		}
		putBeeper();
		turnAround();
		move();
		while(noBeepersPresent()) {
			putEndBeeper();
		}
	}

/*
 * Method: putEndBeeper() Karel finds the end beeper and moves one step inwards to place new beeper.
 * Pre-Conditions:
 * - Karel will be on a corner with no Beeper present.
 * Post-Conditions:
 * - Karel will stop once he no longer lands on an empty corner.
 */
	private void putEndBeeper() {
		while(noBeepersPresent()) {
			move();
		}
		turnAround();
		move();
		putBeeper();
		move();
	}

/*
 * Method clearBeeperRow() Karel will pick up beepers from the middle of street until he hits the wall.
 * Pre-Conditions:
 * -Karel is standing on middle of street.
 * Post-Conditions:
 * -Karel will be facing back towards the middle of street.
 * -Beepers will not only be on the other half of street.
 */
	private void clearBeeperRow() {
		while(frontIsClear()) {
			pickBeeper();
			move();
		}
		pickBeeper(); //prevents OBOB
		turnAround();
	}
	
/*
 * Method findMiddle() Karel walks towards the middle of street and stops when he comes across a beeper.
 * Pre-Conditions:
 * -Karel is at end of street facing the middle (direction does not matter)
 * Post-Conditions:
 * -Karel will be standing on the middle corner and facing the same direction as Pre-Condition.
 */
	private void findMiddle() {
		while(noBeepersPresent()) {
			move();
		}
	}
}

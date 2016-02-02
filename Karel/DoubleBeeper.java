package misc;

import stanford.karel.*;

public class DoubleBeeper extends SuperKarel {
	
	public void run() {
		while (noBeepersPresent()) {
			move();
		}
		doubleBeeper();
		returnHome();
	}
		
	private void doubleBeeper() {	
		doubleIntoStorage();
		moveStorage();
	}
		
	private void doubleIntoStorage() {
		while (beepersPresent()) {
		pickBeeper();
		move();
		putBeeper();
		putBeeper();
		turnAround();
		move();
		turnAround();
		}
	}
	
	private void moveStorage() {
		move();
		while (beepersPresent()) {
			turnAround();
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
		}
	}
	
	private void returnHome() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
}

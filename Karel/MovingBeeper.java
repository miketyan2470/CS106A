package misc;

import stanford.karel.*;

public class MovingBeeper extends SuperKarel {
	
	public void run() {
		move();
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		move();
		turnRight();
		move();
		move(); 
		putBeeper();
		move();
		move();
		move();
		move();
		
		turnAround();
		while (noBeepersPresent()) {
			move();
		}
		pickBeeper();
		move();
		move();
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		turnRight();
		move();
		putBeeper();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
}

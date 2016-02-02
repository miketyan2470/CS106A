package misc;

import stanford.karel.*;

public class ClimbHill extends SuperKarel {
	
	public void run() {
		while (frontIsClear()) {
			move();
		}
		climb();
	}
	
	private void climb() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
		turnRight();
		while (frontIsClear()) {
			move();
		}
		
	}
}


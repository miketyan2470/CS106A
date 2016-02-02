package misc;

import stanford.karel.*;

public class CollectBeepers extends SuperKarel {
	
	public void run() {
		collectAllBeepers();
		dropAllBeepers();
		returnHome();
	}
	
	private void collectAllBeepers() {
		while (frontIsClear()) {
			collectTower();
			move();
		}
		collectTower();
	}
	
	private void collectTower() {
		turnLeft();
		collectLineOfBeepers();
		turnAround();
		moveToWall();
		turnLeft();
	}
	
	private void collectLineOfBeepers() {
		while (beepersPresent()) {
			pickBeeper();
			if (frontIsClear()) {
				move();
			}
		}
	}
	
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	
	private void dropAllBeepers() {
		while (beepersInBag()) {
			putBeeper();
		}
	}
	
	private void returnHome() {
		turnAround();
		moveToWall();
		turnAround();
	}
}


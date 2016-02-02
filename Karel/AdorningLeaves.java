package misc;

import stanford.karel.*;

public class AdorningLeaves extends SuperKarel {
	
	public void run() {
		while (beepersInBag()) {
			FindTree();
			AscendTree();
			PlaceLeaves();
			DescendTree();
		}
	}
	
	private void FindTree() {
		MoveToWall();
	}
	
	private void MoveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	
	private void AscendTree() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
	}
	
	private void PlaceLeaves() {
		for (int i=0; i<3; i++) {
			putBeeper();
			move();
			turnRight();
		}
		putBeeper();
		turnLeft();
		move();
	}
	
	private void DescendTree() {
		MoveToWall();
		turnLeft();
	}
}


/*
 * File: Breakout.java
 * -------------------
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/* Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/* Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/* Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/* Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/* Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/* Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/* Separation between bricks */
	private static final int BRICK_SEP = 4;

/* Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/* Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/* Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/* Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/* Number of turns */
	private static final int NTURNS = 3;

/* Runs the Breakout program. */
	public void run() {
		setup();
	}
	
	private void setup() {
		drawBricks();
	}
	
	private void drawBricks() {
		double startX = (getWidth() / 2) - (((NBRICKS_PER_ROW * BRICK_WIDTH) / 2) + (((NBRICKS_PER_ROW - 1) * BRICK_SEP) / 2));
		double startY = BRICK_Y_OFFSET;
		for (int row = 0; row < NBRICK_ROWS; row++) {
			for (int column = 0; column < NBRICKS_PER_ROW; column++) {
				double x = startX + ((column * BRICK_WIDTH) + (column * BRICK_SEP));
				double y = startY + ((row * BRICK_HEIGHT) + (row * BRICK_SEP));
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setFillColor(getColor(row));
				add(brick);
			}
		}
	}
	
	private Color getColor(int n) {
		switch (n % 10) {
			default: return Color.RED;
			case 1: return Color.RED;
			case 2: return Color.ORANGE;
			case 3: return Color.ORANGE;
			case 4: return Color.YELLOW;
			case 5: return Color.YELLOW;
			case 6: return Color.GREEN;
			case 7: return Color.GREEN;
			case 8: return Color.CYAN;
			case 9: return Color.CYAN;
		}
	}

}

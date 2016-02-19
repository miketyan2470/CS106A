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


	public static final int APPLICATION_WIDTH = 400; 	/* Width and height of application window in pixels */
	public static final int APPLICATION_HEIGHT = 600;
	private static final int WIDTH = APPLICATION_WIDTH; /* Dimensions of game board (usually the same) */
	private static final int HEIGHT = APPLICATION_HEIGHT;
	private static final int PADDLE_WIDTH = 60; 		/* Dimensions of the paddle */
	private static final int PADDLE_HEIGHT = 10;
	private static final int PADDLE_Y_OFFSET = 30; 		/* Offset of the paddle up from the bottom */
	private static final int NBRICKS_PER_ROW = 10; 		/* Number of bricks per row */
	private static final int NBRICK_ROWS = 10; 			/* Number of rows of bricks */
	private static final int BRICK_SEP = 4; 			/* Separation between bricks */
	private static final int BRICK_WIDTH = 				/* Width of a brick */
		(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW; 
	private static final int BRICK_HEIGHT = 8;			/* Height of a brick */
	private static final int BALL_RADIUS = 10; 			/* Radius of the ball in pixels */
	private static final int BRICK_Y_OFFSET = 70;		/* Offset of the top brick row from the top */
	private static final int NTURNS = 3; 				/* Number of turns */
	private static final double MAX_X_VELOCITY = 3.0; 	/* Maximum and minimum velocity for x */
	private static final double MIN_X_VELOCITY = 1.0;
	private static final int SPEED = 10;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private double vy;
	private double vx;
	public GRect paddle;
	public GOval ball;
	
/* Runs the Breakout program. */
	public void run() {
		setBackground(Color.BLACK);
		setup();
		while (NTURNS > 0) {
			play();
		}
	}
	
	private void play() {
		waitForClick();
		moveBall();
	}
	
	private void moveBall() {
		vy = 3.0;
		vx = rgen.nextDouble(MIN_X_VELOCITY, MAX_X_VELOCITY);
		while (true) {
			ball.move(vx, vy);
			pause(SPEED);
			double x = ball.getX();
			double y = ball.getY();
			if ((x >= (getWidth() - BALL_RADIUS * 2)) || (x <= 0)) {
				vx = -vx;
			}
			if ((y >= (getHeight() - BALL_RADIUS * 2)) || (y <= 0)) {
				vy = -vy;
			}
		}
		
	}
	
	private void setup() {
		drawBricks();
		drawPaddle();
		drawBall();
	}
	
	private void drawBall() {
		double x = getWidth() / 2 - BALL_RADIUS;
		double y = getHeight() / 2 - BALL_RADIUS;
		ball = new GOval(x, y, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.setFillColor(Color.WHITE);
		add(ball);
	}
	
	private void drawPaddle() {
		paddle = new GRect(0, getHeight() - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setFillColor(Color.WHITE);
		add(paddle);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e) {
		if (e.getX() > PADDLE_WIDTH / 2 && e.getX() < getWidth() - PADDLE_WIDTH / 2) {
			paddle.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET);
		}
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

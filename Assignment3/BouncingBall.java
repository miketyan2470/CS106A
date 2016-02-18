// Code is courtesy of example by MEHRAN SAHAMI, professor of CS106A at Stanford University.

package Sections;

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
/**
 * File : BouncingBall.java
 * ------------------------
 * Graphics program that bounces a ball across the screen that simulates effect
 * of both gravity and velocity lost upon 'bounce'.
 */
public class BouncingBall extends GraphicsProgram {
	// Private constants.
	private static final int BALL_SIZE = 50;
	private static final int GRAVITY = 3;
	private static final int SPEED = 50;
	private static final double START_X = BALL_SIZE;
	private static final double START_Y = 100;
	private static final double VELOCITY = 5;
	private static final double VELOCITY_LOST = 0.9;
	// Private instance variables.
	private double velocityX = VELOCITY;
	private double velocityY = 0.0;
	private GOval ball;

	public void run() {
		setup();
		// Loops until ball goes off right side of window.
		while (ball.getX() < getWidth()) {
			moveBall();
			checkForCollision();
			pause(SPEED);
		}
	}
	/**
	 * Checks for collision with floor and updates velocity accordingly.
	 */
	private void checkForCollision() {
		if (ball.getY() > getHeight() - BALL_SIZE) {
			// Velocity lost due to impact calculated at 90% of original velocity.
			velocityY = -velocityY * VELOCITY_LOST;
			double diff = ball.getY() - (getHeight() - BALL_SIZE);
			ball.move(0,  -2 * diff);
		}
	}
	/**
	 * Updates velocity and moves ball.
	 */
	private void moveBall() {
		velocityY += GRAVITY;
		ball.move(velocityX, velocityY);
	}
	/**
	 * Creates and places ball on canvas.
	 */
	private void setup() {
		ball = new GOval(START_X, START_Y, BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		ball.setFillColor(Color.BLACK);
		add(ball);
	}
}
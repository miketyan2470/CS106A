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
	@SuppressWarnings("unused")
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
	private static final int SPEED = 8;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private AudioClip gameOverClip = MediaTools.loadAudioClip("gameover.wav");
	private AudioClip congrats = MediaTools.loadAudioClip("winner.wav");
	
	private double vy;
	private double vx;
	public GRect paddle;
	public GOval ball;
	public GLabel gameOver;
	public GLabel results;
	public GLabel retry;
	public GLabel info;
	int score;
	int credits;
	int brickCount;
	
/* Runs the Breakout program. */
	public void run() {
		credits = NTURNS;
		brickCount = NBRICKS_PER_ROW * NBRICK_ROWS;
		score = 0;
		setBackground(Color.BLACK);
		setup();
		play();
	}
	
	private void play() {
		checkCredits();
		waitForClick();
		moveBall();
	}
	
	private void checkCredits() {
		if (credits == 0) {
			remove(ball);
			gameOverClip.play();
			displayResults();
			displayGameOver();
			displayRetry();
			waitForClick();
			removeAll();
			run();
		}
	}
	
	private void displayRetry() {
		retry = new GLabel("Click anywhere to retry.");
		retry.setColor(Color.WHITE);
		retry.setFont("ComicSans-16");
		add(retry, (getWidth() - retry.getWidth()) / 2, (getHeight() / 2 + (2 * retry.getAscent())));
	}
	
	private void displayGameOver() {
		gameOver = new GLabel("GAMEOVER");
		gameOver.setColor(Color.RED);
		gameOver.setFont("ComicSans-bold-36");
		add(gameOver, (getWidth() - gameOver.getWidth()) / 2, (getHeight() - gameOver.getAscent()) / 2);
	}
	
	private void displayResults() {
		results = new GLabel("You only had " + brickCount + " bricks left!");
		results.setColor(Color.RED);
		results.setFont("ComicSans-bold-24");
		add(results, (getWidth() - results.getWidth()) / 2, (getHeight() + results.getAscent()) / 2);
	}
	
	private void moveBall() {
		vy = 3.0;
		vx = rgen.nextDouble(MIN_X_VELOCITY, MAX_X_VELOCITY);
		while (credits > 0) {
			ball.move(vx, vy);
			pause(SPEED);
			double x = ball.getX();
			double y = ball.getY();
			if ((x >= (getWidth() - BALL_RADIUS * 2)) || (x <= 0)) {
				vx = -vx;
			}
			if (y <= 0) {
				vy = -vy;
			}
			checkForCollision();
			if (y > getHeight()) {
				credits--;
				remove(ball);
				remove(info);
				drawInfo();
				break;
			}
		}
		drawBall();
		play();
	}
	
	private void checkForCollision() {
		GObject collider = getCollidingObject();
		if (collider == paddle) {
			double paddleYEdge = (getHeight() - (PADDLE_Y_OFFSET + PADDLE_HEIGHT) - BALL_RADIUS * 2);
			if (ball.getY() >= paddleYEdge && ball.getY() < paddleYEdge + 4){ 			
				vy = -vy;
				bounceClip.play();
			} else {
				vy = -vy;
				bounceClip.play();
			}
		} else if ((collider != null) && (collider != info)) {
			remove(collider);
			vy = -vy;
			brickCount--;
			score++;
			remove(info);
			drawInfo();
			bounceClip.play();
			if (brickCount == 0) {
				displayWinner();
			}
		}
	}
	
	private void displayWinner() {
		remove(ball);
		congrats.play();
		GLabel winner = new GLabel("YOU WIN!! CONGRATS!");
		winner.setColor(Color.RED);
		winner.setFont("ComicSans-bold-36");
		add(winner, (getWidth() - winner.getWidth()) / 2, (getHeight() - winner.getAscent()) / 2);
		waitForClick();
		run();
	}
	
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY());
		} else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()) != null) {
			return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
		} else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2) != null) {
			return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
		} else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2) != null) {
			return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
		} else {
			return null;
		}
	}
	
	private void setup() {
		drawBricks();
		drawInfo();
		drawPaddle();
		drawWelcome();
		drawBall();
	}
	
	private void drawInfo() {
		info = new GLabel(" Credits : " + credits + "                                  Score : " + score);
		info.setColor(Color.WHITE);
		info.setFont("Arial-14");
		add(info, 0, getHeight() - info.getAscent() / 2);
	}
	
	private void drawBall() {
		double x = getWidth() / 2 - BALL_RADIUS;
		double y = getHeight() / 2 - BALL_RADIUS;
		ball = new GOval(x, y, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.setFillColor(Color.WHITE);
		add(ball);
	}
	
	private void drawWelcome() {
		GLabel welcome = new GLabel("WELCOME TO BREAKOUT");
		GLabel welcome2 = new GLabel("Click anywhere to start!");
		welcome.setColor(Color.WHITE);
		welcome2.setColor(Color.WHITE);
		welcome.setFont("TimesNewRoman-24");
		welcome.setFont("TimesNewRoman-24");
		add(welcome, (getWidth() - welcome.getWidth()) / 2, getHeight() / 2);
		add(welcome2, (getWidth() - welcome2.getWidth()) / 2, getHeight() / 2 + welcome.getHeight());
		waitForClick();
		remove(welcome);
		remove(welcome2);
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

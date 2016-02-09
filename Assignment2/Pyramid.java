/**
 * File : Pyramid.java
 * -------------------
 * Program draws a pyramid that is centered in the graphics window
 * on the x axis.
 * -BRICK_BASE constant defines number of bricks on bottom row. 
 * -BRICK_HEIGHT constant defines height of each brick.
 * -BRICK_WIDTH constant defines width of each brick.
 * -Each row upwards will have one less brick.
 */

import acm.program.*;
import acm.graphics.*;

public class Pyramid extends GraphicsProgram {
	
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_BASE = 12;
	
	public void run() {
		
/**
 * Variables are not assigned, so values can be changed as 
 * needed throughout the method.
 */
		int bh = BRICK_HEIGHT;
		int bw = BRICK_WIDTH;
		int br = BRICK_BASE; // Added to correct issue with y-axis calculations.
		int bb = BRICK_BASE;
		
		for (int row = 0; row < BRICK_BASE; row++) {
			double x = (getWidth() / 2) - ((bb * bw) / 2); // Sets X-axis as center offset by bricks.
			double y = (getHeight() / 2) + ((bh * br) / 2); // Sets Y-axis as center offset by bricks.
			for (int column = 0; column < bb; column++) {
				GRect brick = new GRect (x,y,bw,bh);
				add(brick);
				x += bw; // Offsets next GRect by moving one brick width on the x-axis.
			}
			bb -= 1; // Sets new values to progress the 'build' upwards.
			br -= 2;
		}
	}
}
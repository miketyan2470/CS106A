package Sections;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
/**
 * File : RandomCircles.java
 * -------------------------
 * Graphics program draws ten random circles on the canvas.
 * -Minimum and maximum value of radius is a set constant.
 * -Colors of circles should be random.
 * -Circles do not extend the edge of graphics window.
 */
public class RandomCircles extends GraphicsProgram {
	// Private constants.
	private static final int MIN_RADIUS = 20;
	private static final int MAX_RADIUS = 125;
	private static final int NUMBER_OF_CIRCLES = 10;
	// Initializes random generator.
	private RandomGenerator rgen = RandomGenerator.getInstance();
	/**
	 * Runs program RandomCircles.
	 */
	public void run() {
		for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
			int radius = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			drawCircle(radius);
		}
	}
	/**
	 * Draws circle that is filled with random color.
	 * @param radius Integer value of the radius.
	 */
	private void drawCircle(int radius) {
		int x = rgen.nextInt(0, getWidth() - 2 * radius);
		int y = rgen.nextInt(0, getHeight() - 2 * radius);
		GOval circle = new GOval(radius * 2, radius * 2);
		circle.setFilled(true);
		circle.setFillColor(rgen.nextColor());
		add(circle, x, y);
	}
}
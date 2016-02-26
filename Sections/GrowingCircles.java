package Sections;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
/**
 * File : GrowingCircles.java
 * --------------------------
 * Graphics program draws ten random circles on the canvas.
 * -Minimum and maximum value of radius is a set constant.
 * -Colors of circles and location should be random.
 * -Circles do not extend the edge of the graphics window.
 * -Circles appear as a dot and 'grows' while centered at the same spot.
 */
public class GrowingCircles extends GraphicsProgram {
	// Private constants.
	private static final int MIN_RADIUS = 20;
	private static final int MAX_RADIUS = 125;
	private static final int NUMBER_OF_CIRCLES = 10;
	private static final int PAUSE = 25;
	private static final int DELTA_RADIUS = 1;
	// Initializes random generator.
	private RandomGenerator rgen = RandomGenerator.getInstance();	
	/**
	 * Runs program GrowingCircles.
	 */
	public void run() {
		for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
			int radius = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			int x = rgen.nextInt(0, getWidth() - 2 * radius);
			int y = rgen.nextInt(0, getHeight() - 2 * radius);
			drawCircle(radius, x, y);
		}
	}
	/**
	 * Draws a circle that is filled with random color.
	 * @param radius Integer value of the radius.
	 * @param x Integer randomly generated that represents x axis coordinate.
	 * @param y Integer randomly generated that represents y axis coordinate.
	 */
	private void drawCircle(int radius, int x, int y) {
		GOval circle = new GOval(1, 1);
		circle.setFilled(true);
		circle.setFillColor(rgen.nextColor());
		add(circle, x + radius, y + radius);
		growCircle(circle, radius, x, y);
	}
	/**
	 * Grows circle from the same position as center until reaches it 
	 * reaches size determined by randomly generated radius.
	 * @param circle GOval that is to be called.
	 * @param radius Integer randomly generated that represents radius.
	 * @param x Integer randomly generated that represents x axis coordinate.
	 * @param y Integer randomly generated that represents y axis corrdinate.
	 */
	private void growCircle(GOval circle, int radius, int x, int y) {
		for (int i = 1; i <= radius / 2; i++) {
			circle.setSize(2 * i, 2 * i);
			circle.move(-DELTA_RADIUS, -DELTA_RADIUS);
			pause(PAUSE);
		}
	}
}
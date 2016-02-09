/**
 * File : GraphicsHierarchy.java
 * -----------------------------
 * Graphics program draws the partial hierarchy of acm.graphics class. 
 * -Width and height of class boxes are specified as constants so values can be easily changed.
 * -Labels are centered in their boxes.
 * -Connecting lines start and end at center of appropriate edge of box.
 * -The entire figure is centered in the window. 
 */

import acm.program.*;
import acm.graphics.*;

public class GraphicsHierarchy extends GraphicsProgram {
	//Sets value for constants.
	private static final double WIDTH = 80;
	private static final double HEIGHT = 40;
	private static final double ROW_OFFSET = 150;
	private static final double COLUMN_OFFSET = 40;
	//Main method run.
	public void run() {
		double x = (getWidth() / 2);
		double y = (getHeight() / 2);
		//Calls method 'drawBox' for each GRect.
		drawBox(x - (WIDTH / 2), y - (ROW_OFFSET / 2) - HEIGHT, "GObject");
		drawBox(x - ((2 * WIDTH) + (COLUMN_OFFSET * 1.5)), y + (ROW_OFFSET / 2), "GLabel");
		drawBox(x - (WIDTH + (COLUMN_OFFSET / 2)), y + (ROW_OFFSET / 2), "GLine");
		drawBox(x + (COLUMN_OFFSET / 2), y + (ROW_OFFSET / 2), "GOval");
		drawBox(x + (WIDTH + (COLUMN_OFFSET * 1.5)), y + (ROW_OFFSET / 2), "GRect");
	}
	//Method drawBox creates GRect with GLabel set by parameters defined within 'run' method.
	private void drawBox(double x, double y, String label) {
		GRect box = new GRect(x, y, WIDTH, HEIGHT); 
		GLabel object = new GLabel(label);
		//Sets new values for GLabel 'object' to be centered within GRect 'box'.
		double x2 = (x + (WIDTH - object.getWidth()) / 2);
		double y2 = (y + object.getAscent() + (HEIGHT - object.getAscent()) / 2);
		double linex = (getWidth() / 2);
		double liney = ((getHeight() / 2) - (ROW_OFFSET / 2));
		//Draws 'box' and then draws 'object'.
		add(box);
		add(object, x2, y2);
		//Draws a line to connect each box following 'box' with 'GObject' as 'label'.
		if (label.equals("GObject")) {
			return;
		} else {
			add(new GLine(linex, liney, x + (WIDTH / 2), y));
		}
	}

}

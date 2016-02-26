package Sections;

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
/**
 * File : DrawRectangle.java
 * -------------------------
 * Graphics program allows users to draw rectangles on canvas with mouse clicks.
 * -Program is too buggy to be considered fully functioning.
 * -Rectangles do not move into the quadrants of -y.
 * -Rectangles scale unpredictably when approaching 0 on the x axis.
 */
public class DrawRectangle extends GraphicsProgram {
	// Private instance variables.
	private GRect rect;
	private double x1;
	private double y1;
	private double width;
	private double height;
	private boolean dragging;
	/** Initializes mouse listeners.*/
	public void init() {
		addMouseListeners();
	}
	/**
	 * Records x and y coordinates when mouse is pressed and also determines
	 * if there is a GRect at clicked position.
	 */
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		rect = (GRect) getElementAt(x1, y1);
		dragging = (rect != null);
		if (!dragging) {
			rect = new GRect(x1, y1, 0, 0);	
			rect.setFilled(true);
			add(rect);
		}
	}
	/**
	 * Records x and y coordinates when mouse is dragged and changes size
	 * and location of rectangle.
	 */
	public void mouseDragged(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if (dragging) {
			rect.move(x - x1, y - y1);
			x1 = x;
			y1 = y;
		} else {
			x = Math.min(x, x1);
			y = Math.min(x, y1);
		width = Math.abs(e.getX() - x1);
		height = Math.abs(e.getY() - y1);
		rect.setBounds(x, y, width, height);
		}
	}
}
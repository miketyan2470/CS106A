/*
 * File : Quadratic.java
 * ---------------------
 * Program calculates the two solutions for the quadratic equation with the three
 * coefficients entered by user.
 * -Checks for situations when there are no real solutions.
 */

import acm.program.*;

public class Quadratic extends ConsoleProgram {
	
	public void run() {
		println("This program calculates the two solutions for the Quadratic Equation.");
		println();
		println("Enter coefficients for the equation: ");
		//Initializes the values a,b, and c from user input.
		int a = readInt("a: ");
		int b = readInt("b: ");
		int c = readInt("c: ");
		//Checks to make sure the 'variant' is a positive number.
		if ((4 * a * c) > (b * b)) {
			println("The equation has no real solution.");
		} else {
			quadraticEquation(a, b, c);
		}
	}
	
	private void quadraticEquation(double a, double b, double c) {
		//Initializes double 'variant' so it can be interchanged as positive and negative.
		double variant = ((b * b) - (4 * a * c));
		double solution1 = (((-b) + Math.sqrt(variant)) / (2 * a));
		double solution2 = (((-b) - Math.sqrt(variant)) / (2 * a));
		//Displays solution on the screen.
		println("The first solution is " + solution1);
		println("The second solution is " + solution2);
	}
}
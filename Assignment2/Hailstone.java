/*
 * File : Hailstone.java
 * ---------------------
 * Console Program calculates the 'Hailstone Sequence' for integer entered by user.
 * -Program displays each step in the process.
 * -Final line will display number of steps taken to reach '1'.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {

	public void run() {
		println("This program computes Hailstone Sequences.");
		println();
		int n = readInt("Please enter an integer: ");
		println();
		//Initializes values for both 'counter' and 'total'.
		int counter = 0;
		int total = 0;
		//Loops until 'n' equals '1'.
		while (true) {
			if (n == 1) break;
			if (n % 2 == 0) {
				total = (n / 2);
				println(n + " is even, so I take half = " + total);
				n = total;
			} else {
				total = ((3 * n) + 1);
				println(n + " is odd, so I make 3n + 1 = " + total);
				n = total;
			}
			//Keeps count of number times cycled.
			counter++;
		}
		println();
		println("The process took " + counter + " steps to reach 1.");
	}
}

/*
 * File : FindRange.java
 * ---------------------
 * Program will find the largest and smallest integers entered.
 * -One Integer entered at a time, using '0' as SENTINEL to end list.
 * -Largest and smallest number will be set as the first value entered.
 * -Entering SENTINEL on first entry will display message stating 'no values
 * have been entered'.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	//Sets constant SENTINEL to '0'.
	private static final int SENTINEL = 0;

	public void run() {
		println ("This program finds the largest and smallest integer in a given list.");
		println ();
		println ("Enter values, one per line, using a '0' to signal");
		println ("the end of the list.");
		//Sets initial value for 'n1' with user input.
		int n = readInt (" ? ");
		if (n == SENTINEL) {
			println("No values have been entered.");
		} else {
			//Sets value 'n' as both the largest and smallest values.
			int highN = n;
			int lowN = n;
			//Loop until 'n' equals 'SENTINEL'.
			while (true) {
				n = readInt (" ? ");
				if (n == SENTINEL) break; 
				//Determines if entered value is larger than the largest value or 
				//smaller than the smallest value. If either is true, then the current 
				//value is replaced with new value.
				if (n > highN) {
					highN = n;
				} else {
					if (n < lowN) {
						lowN = n;
					}
				}	
			}
			println ("The largest integer is " + highN + ".");
			println ("The smallest integer is " + lowN + ".");
		}
	}
}
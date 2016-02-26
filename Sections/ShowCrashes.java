package Section4;

import acm.program.*;
/**
 * File : ShowCrashes.java
 * -----------------------
 * Console program takes a ciphertext and crib to find any crashes that may occur at each offset.
 * -Crash is defined as matching characters within String when offset is factored into the crib.
 * -Program also generates a 'chart' to give a visual findings of crashes that occur.
 */
public class ShowCrashes extends ConsoleProgram {
	/**
	 * Runs program. Starts with into and then asks user for values.
	 */
	public void run() {
		println("This program will find 'crashes' within ciphertext and 'crib'. The results will be displayed.\n");
		String ciphertext = readLine("Please enter CipherText: ");
		String crib = readLine("Please enter Crib: ");
		int limit = (ciphertext.length() - crib.length());
		for (int offset = 0; offset <= limit; offset++) {
			if (hasCrashes(ciphertext, crib, offset)) {
				println("Offset " + offset + ": crashes");
			} else {
				println("Offset " + offset + ": OK");
			}
			showGraph(ciphertext, crib, offset);
		}
	}
	/**
	 * Determines if any crashes exist between ciphertext and crib.
	 * @param ciphertext String used to search for crash.
	 * @param crib String used at each offset to search for crash.
	 * @param offset Integer representing the offset for each trail.
	 * @return Returns true if any crashes exists, returns false otherwise.
	 */
	private boolean hasCrashes(String ciphertext, String crib, int offset) {
		for (int i = 0; i < crib.length(); i++) {
			if (ciphertext.charAt(i + offset) == crib.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Displays the findings in a visual chart with a vertical 'line' at crash.
	 * @param ciphertext String used to search for crash.
	 * @param crib String used at each offset to search for crash.
	 * @param offset Integer representing the offset for each trail.
	 */
	private void showGraph(String ciphertext, String crib, int offset) {
		String indent = "  ";
		println(indent + ciphertext);
		println(getIndent(indent, offset) + showCrashes(ciphertext, crib, offset));
		println(getIndent(indent, offset) + crib);
	}
	/**
	 * Configures String to represent value when 'indent' is added by number of offsets.
	 * @param indent String of initial offset.
	 * @param offset Integer that represents how many spaces are added to 'indent'.
	 * @return Returns String that represents initial 'indent' plus the correct spaces based on offset.
	 */
	private String getIndent(String indent, int offset) {
		String result = indent;
		for (int i = 0; i < offset; i++) {
			result += " ";
		}
		return result;
	}
	/**
	 * Configures String to represent location of each crash in ciphertext.
	 * @param ciphertext String used to search for crash.
	 * @param crib String used at each offset to search for crash.
	 * @param offset Integer that represents offset for each trail.
	 * @return
	 */
	private String showCrashes(String ciphertext, String crib, int offset) {
		String result = "";
		for (int i = 0; i < crib.length(); i++) {
			if (ciphertext.charAt(i + offset) == crib.charAt(i)) {
				result = result + "|";
			} else {
				result = result + " ";
			}
		}
		return result;
	}
}
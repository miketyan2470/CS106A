package Section4;

import acm.program.*;
import java.util.*;
/**
 * File : StanfordSpeak.java
 * -------------------------
 * Console program converts user entered line into StanfordSpeak.
 * StanfordSpeak rules are as follows:
 * -Substrings of each word ends at and includes first vowel.
 * -If letter following first vowel is a 'nasals' (either 'n' or 'm'), then
 * 	it is also added to substring.
 */
public class StanfordSpeak extends ConsoleProgram {
	/**
	 * Runs program until user exits with a blank line.
	 * -Converts the line entered into lower case to avoid case sensitive issues.
	 */
	public void run() {
		println("This program translate a line of english into StanfordSpeak.");
		while (true) {
			String line = readLine("\nPlease enter a line: ");
			line = line.toLowerCase();
			if (line == "") break;
			println(createStanfordAbbreviation(line));
		}
	}
	/**
	 * Creates a new String that is StanfordSpeak for line entered.
	 * @param line String user entered to be translated.
	 * @return Returns String that is in StanfordSpeak.
	 */
	private String createStanfordAbbreviation(String line) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(line);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result += abbreviatedWord(token);
		}
		return result;
	}
	/**
	 * Converts a word into StanfordSpeak abbreviated form.
	 * @param token String of word to be abbreviated.
	 * @return Returns String that is in StanfordSpeak.
	 */
	private String abbreviatedWord(String token) {
		int index = findVowel(token);
		// If word contains no vowels, then it is returned unchanged.
		if (index == -1) {
			return token;
		} else if (isNasals(token, index)) {
			return token.substring(0, index + 2);
		} else {
			return token.substring(0, index +1);
		}
	}
	/**
	 * Determines if character that comes after index is a nasal ('n' or 'm').
	 * @param token String word that is used as reference to search for nasals.
	 * @param index Integer index of vowel to check the following char.
	 * @return Returns true if letter following index is either 'n' or 'm', otherwise returns false.
	 */
	private boolean isNasals(String token, int index) {
		char ch = token.charAt(index + 1);
		if (ch == 'm' || ch == 'n') {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Finds the index position of the first vowel in a word.
	 * @param token String word used to search for first vowel.
	 * @return Returns integer index location of first vowel.
	 */
	private int findVowel(String token) {
		for (int i = 0; i < token.length(); i++) {
			char ch = token.charAt(i);
			if (isVowel(ch)) return i;
		}
		return -1;
	}
	/**
	 * Determines if character is a vowel.
	 * @param ch Character that is used to compare.
	 * @return Returns true if character is a vowel, otherwise returns false.
	 */
	private boolean isVowel(char ch) {
		switch (ch) {
			case 'a': case 'e': case 'i': case 'o': case 'u': 
				return true;
			default: 
				return false;
		}
	}
}
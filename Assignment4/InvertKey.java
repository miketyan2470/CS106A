import acm.program.*;
/**
 * File : InvertKey.java
 * ---------------------
 * Console program generates the key used in LetterSubstitutionCipher.java
 * and generates an inverted key to be used in deciphering an encoded text.
 * -Program will test the inverted key by using it as a new key to decipher the 
 * 	new key back to original state.
 */
public class InvertKey extends ConsoleProgram {
	/**
	 * Runs program.
	 */
	public void run() {
	   println("This program generates an inverted key to de-cipher an encrypted message.\n");
	   String key = getKey().toUpperCase();
	   String invertedKey = invertKey(key);
	   results(key, invertedKey);
	}
	/**
	 * Displays the results for inverting and reverting the keys.
	 * @param key String encryption key used in cipher.
	 * @param invertedKey Returns String key used to decipher encrypted text. 
	 */
	private void results(String key, String invertedKey) {
		println("Key :          " + key);
		println("Inverted Key : " + invertedKey);
		println("Original Key : " + invertKey(invertedKey));
	}
	/**
	 * Gets the inverted key used to decipher the encrypted text.
	 * @param key String Encryption key used in cipher text.
	 * @return Returns String key used to decipher encrypted text.
	 */
	private String invertKey(String key) {
		String result = "";
		String plaintext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < plaintext.length(); i++) {
    		char ch = plaintext.charAt(i);
			for (int j = 0; j < key.length(); j++) {
				if (ch == key.charAt(j)) {
					result += plaintext.charAt(j);
				}
    		}
	    }
		return result;
	}
	/**
	 * Gets String key used in encryption and verifies validity.
	 * @return Returns String encryption key.
	 */
	private String getKey() {
		String key = readLine("Enter 26-letter key: ");
		while (!isLegalKey(key)) {
			   println("That key is illegal. Key must be 26 letters long with no repeated letters.");
			   key = readLine("Enter 26-letter key: ");
			   key = key.toUpperCase();
		}
		return key;
	}
	/**
	 * Determines if key is valid: must have 26 letters with no repeated letters.
	 * @param key String encryption key to be checked.
	 * @return Returns true if key is valid, otherwise returns false.
	 */
	private boolean isLegalKey(String key) {
		if (key.length() != 26) return false;
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			for (int j = i + 1; j < key.length(); j++) {
				if (ch == key.charAt(j)) return false;
			}
		}
		return true;
	}
}

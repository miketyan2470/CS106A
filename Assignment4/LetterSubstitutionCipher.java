import acm.program.*;
/**
 * File : LetterSubstitutionCipher.java
 * ------------------------------------
 * Console program takes a plaintext and generates ciphertext using letter substitution cipher based on a key.
 * -Key must have 26 letters with no repeated letters, not case sensitive.
 */
public class LetterSubstitutionCipher extends ConsoleProgram {
	/**
	 * Runs program.
	 */
   public void run() {
      println("Letter-substitution cipher.");
      String key = getKey();
      String plaintext = readLine("Plaintext:  ");
      String ciphertext = encrypt(plaintext, key);
      println("Ciphertext: " + ciphertext);
   }
   /**
    * Gets String key from user and verifies validity.
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
    * @param key The encryption key to be checked.
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
   /**
    * Encrypts a string according to the key.  All letters in the string
    * are converted to uppercase. Any character that is not a letter is
    * copied to the output unchanged.
    *
    * @param str The string to be encrypted
    * @param key The encryption key
    * @return The encrypted string
    */
   private String encrypt(String str, String key) {
      String result = "";
      str = str.toUpperCase();
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if (Character.isLetter(ch)) {
            ch = key.charAt(ch - 'A');
            ch = Character.toUpperCase(ch);
         }
         result += ch;
      }
      return result;
   }

}

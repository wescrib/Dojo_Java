import java.util.Scanner;

/*Author: William Scribner
 * Purpose: You've been asked to implement a series of string manipulation methods. To do these, you will need to utilize built in string methods.
 * 	Concatonate 2 strings
 * 	get the index of a character and return the index or null. if the character appears multiple times, return the first index
 * 	get the index of the start of a substring and return either the index or null
 * 	get a substring using a starting and ending index and concatenate that with the second string input to our method
 */


public class testStringManipulator {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); //takes keyboard input
		//keyboard.useDelimiter("\s*");
		StringManipulator test = new StringManipulator();
//______________________________________________________________________________________________________________________

		System.out.println("Trim both input strings and then concatenate them. Return the new string.");

		System.out.println("Enter a word with a bunch of spaces before and after the word:");
			String s1 = keyboard.next();
		System.out.println("Enter second word, with a bunch of spaces before and after the word, to be attached to the first word:");
			String s2 = keyboard.next();

		String concat = test.trimAndConcat(s1, s2);
	//________________________________________________________________________________________________________________________________

		System.out.println("Get the index of the character and return either the index or null. If the character appears multiple times, return the first index.");
		System.out.println("Enter a word:");
		String word = keyboard.next();
		System.out.println("Now enter a letter that exists within that word/phrase:");
		char letter = keyboard.next(".").charAt(0);

		String index = test.getIndex(word, letter);
//_____________________________________________________________________________________________________________________________________

		System.out.println("Get the index of the start of the substring and return either the index or null.");
		System.out.println("Enter a word:");
		String string = keyboard.next();
		System.out.println("Enter subword:");
		String substring = keyboard.next();

		// String string = "hello";
		// String substring = "x";

		String result = test.getSub(string, substring);

		//__________________________________________________________________________________________________________________________

		System.out.println("Get a substring using a starting and ending index, and concatenate that with the second string input to our method.");

		System.out.println("Enter a word");
		String s3 = keyboard.next();
		System.out.println("Enter another word, which will be joined to the first word");
		String s4 = keyboard.next();
		System.out.println("Enter first index");
		int index1 = keyboard.nextInt();
		System.out.println("Enter second index");
		int index2 = keyboard.nextInt();

		System.out.println(test.concatSubstring(s3, index1, index2, s4));

		keyboard.close();
	}

}

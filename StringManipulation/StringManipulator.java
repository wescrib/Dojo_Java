public class StringManipulator {
	public String trimAndConcat(String first, String second){
		String manString = first.concat(second);
		System.out.println(manString);
		return manString;
	}

	public String getIndex(String word, char letter) {
		// int index = word.indexOf(letter);

		for (int i=0; i<word.length(); i++) { //iterate through each letter of the input word
			if (letter == word.charAt(i)){ //.charAt converts each letter of the word into a char.
				System.out.println(letter + " is at index " + i);
				return "true";
			}
			if (i > word.length()) {
				System.out.println("The letter is not in the word");
				return "false";
			}
		}
		System.out.println("Letter not in word");
		return "This is the do while loop";
	}

	public String getSub(String string, String subString) {
		int position = string.indexOf(subString);
		System.out.println(position);
		return "true";
	}

	public String concatSubstring(String s3, int index1, int index2, String s4) {
		String newString = s3.substring(index1, index2).concat(s4);
		return newString;

	}

}

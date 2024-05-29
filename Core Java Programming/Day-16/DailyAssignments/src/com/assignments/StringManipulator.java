package com.assignments;

public class StringManipulator {
	
	public static String manipulateStrings(String str1, String str2, int length) {
		
		if(str1==null || str2 == null || length < 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		String concatenated = str1 + str2;
		String reversed = new StringBuilder(concatenated).reverse().toString();
		if(length > reversed.length()) {
			return reversed;
		}
		
		int startIndex = (reversed.length() - length)/2;
		
		String middleSubstring = reversed.substring(startIndex, startIndex + length);
		
		return middleSubstring;
		
	}
	public static void main(String args[]) {
		System.out.println(manipulateStrings("hello", "world", 5));
		System.out.println(manipulateStrings("abc", "def", 3));
		System.out.println(manipulateStrings("abc", "def", 6));
		System.out.println(manipulateStrings("", "", 3));
		
	}

}

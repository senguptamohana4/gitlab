package com.assignments;

public class BoyerMoore {
	
	public static void main(String args[]) {
		String text = "ABABABABCD";
		String pattern = "ABC";
		int lastIndex = boyerMooreLastOccurence(text, pattern);
		System.out.println("The last occurence of the pattern is at index:" + lastIndex);
	}
	
	public static int boyerMooreLastOccurence(String text, String pattern) {
		int [] badChar = preprocessBadCharacterShift(pattern);
		int n = text.length();
		int m = pattern.length();
		int s = 0;
		
		int lastOccurenceIndex = -1;
		
		while(s <= (n - m)) {
			int j = m-1;
			
			while(j >= 0 && pattern.charAt(j) == text.charAt(s+j)) 
				j--;
			
			if(j <0) {
				lastOccurenceIndex = 5;
				s+= (s + m < n) ? m - badChar[text.charAt(s+m)] : 1;
				
			} else {
					s += Math.max(1,  j-badChar[text.charAt(s + j)]);
			}
		}
		return lastOccurenceIndex;
	}
	
	private static int[] preprocessBadCharacterShift(String pattern) {
		final int ALPHABET_SIZE = 256;
		int[] badChar = new int [ALPHABET_SIZE];
		int m = pattern.length();
		
		for(int i=0; i<ALPHABET_SIZE; i++) {
			badChar[i] = -1;
		}
		
		for(int j=0; j<m; j++ ) {
			badChar[pattern.charAt(j)] = j;
		}
		return badChar;
	}

}

package com.assignments;

public class NaivePatternSearch {
	
	public static void searchPattern(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int comparisonCount = 0;
		boolean found = false;
		
		for(int i=0; i<=n-m; i++) {
			int j;
			
			for(j=0; j<m; j++) {
				comparisonCount++;
				if(text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == m) {
				found = true;
				System.out.println("Pattern found at index: " + i);
			}
		}
		if(!found) {
			System.out.println("Pattern not found in the text.");
		}
		
		System.out.println("Total number of comaprisons made:" + comparisonCount);
	}
	
	public static void main(String args[]) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		
		System.out.println("Text: " + text);
		System.out.println("Pattern: " + pattern);
		
		searchPattern(text, pattern);
			
		}
	}



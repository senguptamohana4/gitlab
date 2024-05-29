package com.assignments;

public class KMPAlgorithm {
	
	void computeLPSArray(String pattern, int M, int[] lps) {
		int len =0;
		int i = 1;
		
		lps[0] = 0;
		while(i<M) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if(len!=0) {
					len = lps[len-1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
	void KMPSearch(String text, String pattern) {
		int M = pattern.length();
		int N = text.length();
		
		int[] lps = new int[M];
		computeLPSArray(pattern, M, lps);
		
		int i = 0;
		int j = 0;
		
		while(i <N) {
			if(pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
				
			}
			if(j == M) {
				System.out.println("Found pattern at index " + (i-j));
				j=lps[j-1];
			} else if( i < N && pattern.charAt(j) != text.charAt(i)) {
				if(j!=0) {
					j=lps[j-1];
				}else {
					i=i+1;
				}
			}
			}
		}
	
	public static void main(String args[]) {
		String text = "ABABABCDAABB";
		String pattern = "ABAB";
		new KMPAlgorithm().KMPSearch(text, pattern);
	}
	}



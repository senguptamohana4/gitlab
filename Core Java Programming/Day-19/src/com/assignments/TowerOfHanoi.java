package com.assignments;

public class TowerOfHanoi {
	
	static void moveDisk(int n, char fromPeg, char toPeg) {
		System.out.println("Move disk " + n + "from peg " + fromPeg + "to peg" + toPeg);
	}
	
	static void solveTowerOfHanoi(int n, char sourcePeg, char auxiliaryPeg, char destinationPeg) {
		if(n == 1) {
			moveDisk(n, sourcePeg, destinationPeg);
			return;
		}
		solveTowerOfHanoi(n-1, sourcePeg, destinationPeg, auxiliaryPeg);
		moveDisk(n, sourcePeg, destinationPeg);
		solveTowerOfHanoi(n-1, auxiliaryPeg, sourcePeg, destinationPeg);
	}
	public static void main(String args[]) {
		int n = 4;
		solveTowerOfHanoi(n, 'A', 'B', 'C');
	}

}

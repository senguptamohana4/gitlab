package assignments;

public class BitManipulation {
	
	public static int countSetBits(int x) {
		int count = 0;
		while(x!=0) {
			x &= (x-1);
			count++;
		}
		return count;
	}
	public static int totalSetBitsFrom1ToN(int n) {
		int totalCount = 0;
		for(int i=1; i<=n; i++) {
			totalCount += countSetBits(i);
		}
		return totalCount;
		
	}
	public static void main(String args[]) {
		int n =5;
		System.out.println("Total number of set bits from 1 to " + n + " is:" + totalSetBitsFrom1ToN(n));
	}

}

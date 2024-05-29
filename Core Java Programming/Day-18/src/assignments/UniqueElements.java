package assignments;

public class UniqueElements {
	
	public static int[] findUniqueElements(int []nums) {
		int xorResult = 0;
		for(int num : nums) {
			xorResult ^= num;
		}
		int setBit = xorResult  & -xorResult;
		
		int unique1 = 0;
		int unique2 = 0;
		for(int num : nums) {
			if((num & setBit) == 0) {
				unique1 ^= num;
			} else {
				unique2 ^= num;
			}
		}
		return new int[] {unique1, unique2};
	}
	public static void main(String args[]) {
		int [] nums = {1,2,3,2,1,4};
		int [] result = findUniqueElements(nums);
		System.out.println("The two unique elements are: " + result[0] + " and " + result[1]); 
	}

}

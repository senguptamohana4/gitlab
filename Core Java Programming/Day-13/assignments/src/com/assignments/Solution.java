package com.assignments;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		val = x;
	}
}

public class Solution {
	
	private static class TreeInfo{
		int height;
		boolean balanced;
		
		TreeInfo(int height, boolean balanced){
			this.height = height;
			this.balanced = balanced;
			
		}
	}
	public boolean isBalanced(TreeNode root) {
		return checkBalance(root).balanced;
	}
	
	private TreeInfo checkBalance(TreeNode node) {
		if(node == null) {
			return new TreeInfo(-1, true);
		}
		TreeInfo left = checkBalance(node.left);
		TreeInfo right = checkBalance(node.right);
		
		if(!left.balanced || !right.balanced) {
			return new TreeInfo(-1, false);
		}
		
		int height = Math.max(left.height, right.height) + 1;
		
		boolean balanced = Math.abs(left.height - right.height) <= 1;
		return new TreeInfo(height, balanced);
		}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		
		Solution solution = new Solution();
		System.out.println(solution.isBalanced(root));
		
		}

}

package com.algorithms.library;


public class BinaryTree {

	public static class TreeNode {
		private int value;
		
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
			left = right = null;
		}
	}
	
	public TreeNode root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(TreeNode root) {
		this.root = root;
	}
	
	public void insert(int value) {
		insert(this.root, value);
	}
	
	private void insert(TreeNode start, int value) {
		if (start != null) {
			if (start.value > value) {
				if (start.left != null) {
					insert(start.left, value);
				} else {
					start.left = new TreeNode(value);
				}
			} else {
				if (start.right != null) {
					insert(start.right, value);
				} else {
					start.right = new TreeNode (value);
				}
			}
		} else {
			start = new TreeNode (value);
		}
	}
	
	public boolean preorderSearch (int value) {
		return preorderSearch(this.root, value);
	}
	
	private boolean preorderSearch(TreeNode start, int value) {
		if (start != null) {
			if (start.value == value) {
				return true;
			} else {
				return preorderSearch(start.left, value) || preorderSearch(start.right, value);
			}
		}
		return false;
	}
}

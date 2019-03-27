/**
 * Algorithms
 * Udacity - Carrier:Full Stack Inverview Practice
 * 
 * ALGORITHM EFFICIENCY: space and time
 * space - how much space storage do you need?
 * time - how long does your code take to run?
 */

package com.algorithms.app;

import com.algorithms.library.Algorithms;
import com.algorithms.library.BinaryTree;
/**
 * @author oo491w
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {1,5,34,42,56,64,78,87,91,112,127,138,143,156,162,179,184,198,200};
		int value = 143;
		
		System.out.println("binary search iterative " + Algorithms.binarySearchIterative (arr, value));
		System.out.println("binary search recursive " + Algorithms.binarySearchRecursive(arr, 0, arr.length -1 , value));
		
		
		int n = 8;
		
		System.out.println("fibonacci iterative " + Algorithms.fibonacciIterative(n));
		System.out.println("fibonacci recursive " + Algorithms.fibonacciRecursive(n));
		
		
		BinaryTree bt = new BinaryTree();
		BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
		bt.root = root;
		bt.root.left = new BinaryTree.TreeNode(2);
		bt.root.right = new BinaryTree.TreeNode(3);
		bt.root.left.left = new BinaryTree.TreeNode(4);
		bt.root.left.right = new BinaryTree.TreeNode(5);
		bt.insert(6);
		
		System.out.println("searching for 4: " + bt.preorderSearch(4));
		System.out.println("searching for 6: " + bt.preorderSearch(6));
		
	}

}

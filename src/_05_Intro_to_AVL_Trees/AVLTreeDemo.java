package _05_Intro_to_AVL_Trees;

import java.util.Random;

import _03_Intro_to_Binary_Trees.BinaryTree;

public class AVLTreeDemo {

    /*
     * An AVLTree is a special BinaryTree that is capable of balancing itself.
     * With a regular binary tree, depending on the elements inserted, you might
     * have a root with one very long right branch and one very long left branch
     * with nothing else in between.
     * 
     * 1.) Read through the AVLNode and AVLTree. Notice that the methods are
     * similar to those in BinaryTree with two important distinctions:
     * 
     * a) Each Node has a balance factor that keeps track of how many levels
     * "down" it is relative to the rest of the tree.
     * 
     * b) There are "rotate" helper methods used when a given node gets too
     * unbalanced(> 1 level out of sync with the rest of the tree) to rotate
     * branches back into place.
     * 
     * 2.) Create a BinaryTree and an AVLTree.
     * 
     * 3.) Insert the same values into both trees and observe how they differ
     * using the print method. Make sure the values you pick unbalance the
     * binary tree.
     * 
     * 4.) Try removing elements from both and see how they change using one of
     * the print methods.
     */

    public static void main(String[] args) {
    	
    	BinaryTree<Integer> b = new BinaryTree<Integer>();
    	AVLTree<Integer> a = new AVLTree<Integer>();
    	
    	Random r = new Random();
    	for(int i = 0; i < 10; i++) {
    		int value = r.nextInt(10);
    		b.insert(value);
    		a.insert(value);
    	}
    	System.out.println("Binary:");
    	b.printVertical();
    	System.out.println("AVL:");
    	a.printVertical();
    	
//    	BinaryTree<Integer> test = new BinaryTree<Integer>();
//    	test.insert(10);
//    	test.insert(1);
//    	test.insert(2);
//    	test.insert(3);
//    	test.insert(4);
//    	test.insert(5);
//    	test.printVertical();
    }

}

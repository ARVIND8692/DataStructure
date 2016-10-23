/**
 * 
 */
package com.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author arvind8692
 *
 */
class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}


public class BinaryTree {
	
	Node root;

	/**
	 * 
	 */
	public BinaryTree(int value) {
		root=new Node(value);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(10);
		bt.root.left=new Node(5);
		bt.root.right=new Node(7);
		bt.root.left.left=new Node(91);
		bt.root.left.right=new Node(71);
		bt.root.left.left.left=new Node(51);
		bt.root.left.left.right=new Node(11);
		
		bt.root.right.left=new Node(77);
		bt.root.right.right=new Node(111);
		bt.root.right.left.left=new Node(70);
		bt.root.right.right.right=new Node(37);
		
		BTreePrinter  printer=new BTreePrinter();
		printer.printNode(bt.root);
		bt.printInOrder();
		bt.printPreOrder();
		bt.printPostOrder();
		
		//height of binary tree
		bt.height();
		
		bt.printBFS();
		
		System.out.println("\n is bst : "+bt.isBST());
		
		BinaryTree bst=new BinaryTree(20);
		bst.insertInBST(11);
		bst.insertInBST(24);
		bst.insertInBST(54);
		bst.insertInBST(34);
		bst.insertInBST(13);
		bst.insertInBST(17);
		bst.insertInBST(3);
		bst.insertInBST(11);
		bst.insertInBST(19);
		
		printer.printNode(bst.root);
		bst.searchInBST(17);
		bst.printInOrder();
		bst.deleteKeyInBST(13);
		bst.printInOrder();
		System.out.println("\n is bst : "+bst.isBST());
		
	}

	 /* returns true if given search tree is binary
    search tree (efficient version) */
   boolean isBST()  {
       return isBSTUtil(root, Integer.MIN_VALUE,
                              Integer.MAX_VALUE);
   }

   /* Returns true if the given tree is a BST and its
     values are >= min and <= max. */
   boolean isBSTUtil(Node node, int min, int max)
   {
       /* an empty tree is BST */
       if (node == null)
           return true;

       /* false if this node violates the min/max constraints */
       if ((int)node.data < min || (int) node.data > max)
           return false;

       /* otherwise check the subtrees recursively
       tightening the min/max constraints */
       // Allow only distinct values
       return (isBSTUtil(node.left, min, (int)node.data-1) &&
               isBSTUtil(node.right, (int)node.data+1, max));
   }

	 
    // This method mainly calls deleteRec()
    void deleteKeyInBST(int key)
    {
    	System.out.println("\n deleting the key : "+key);
        root = deleteKeyInBSTRec(root, key);
    }
 
    /* A recursive function to insert a new key in BST */
    Node deleteKeyInBSTRec(Node root, int data)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (data < (int)root.data)
            root.left = deleteKeyInBSTRec(root.left, data);
        else if (data > (int)root.data)
            root.right = deleteKeyInBSTRec(root.right, data);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteKeyInBSTRec(root.right, (int)root.data);
        }
 
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = (int)root.data;
        while (root.left != null)
        {
            minv =(int) root.left.data;
            root = root.left;
        }
        return minv;
    }
    
	private void searchInBST(int i) {
		Node node=searchInBSTRec(i,root);
	}

	private Node searchInBSTRec(int i, Node node) {
		if(node==null || (int)node.data==i){
			if(node!=null){
				System.out.println("found the node:"+i);
			}else {
				System.out.println("not found the node:"+i);
			}
			return node;
		}
		if(i<(int)node.data){
			return searchInBSTRec(i, node.left);
		}
		return searchInBSTRec(i, node.right);
	}

	private void insertInBST(int data) {
		System.out.println("inserting value in binary seatch tree : "+data);
		insertInBSTRec(data,root);
	}

	private Node insertInBSTRec(int data, Node node) {
		if(node==null) {
			node=new Node(data);	
			return node;
		}
		if(data<(int)node.data){
			node.left= insertInBSTRec(data, node.left);
		}else if(data>(int)node.data){
			node.right=insertInBSTRec(data, node.right);
		}
		
		return 	node;
			
	}

	private void printBFS() {
		int height=getHeightRec(root);
		for(int i=0;i<height;i++){
			printLevelOrder(i);
		}
		
	}

	private void printLevelOrder(int i) {
		// TODO Auto-generated method stub
		
	}

	private void height() {
		System.out.println("\n getting height of the binary tree "+getHeightRec(root));
	}

	private int getHeightRec(Node node) {
		if(node==null) return 0;
		int lheight=getHeightRec(node.left);
		int rheight=getHeightRec(node.right);
		if(lheight>=rheight) return 1+lheight;
		else return 1+rheight;
		
	}

	private void printInOrder() {
		System.out.println("\n printinng inorder ");
		printInOrderRec(root);	
	}

	private void printInOrderRec(Node node) {
		if(node==null) return;
		printInOrderRec(node.left);
		System.out.print(node.data+"->");
		printInOrderRec(node.right);
	}
	
	private void printPreOrder() {
		System.out.println("\n printinng pre-order ");
		printPreOrderRec(root);	
	}

	private void printPreOrderRec(Node node) {
		if(node==null) return;
		System.out.print(node.data+"->");
		printInOrderRec(node.left);
		printInOrderRec(node.right);
	}
	private void printPostOrder() {
		System.out.println("\n printinng post-order ");
		printPostOrderRec(root);	
	}

	private void printPostOrderRec(Node node) {
		if(node==null) return;
		printPostOrderRec(node.left);
		printPostOrderRec(node.right);
		System.out.print(node.data+"->");
	}

}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}

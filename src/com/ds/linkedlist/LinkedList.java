/**
 * 
 */
package com.ds.linkedlist;

/**
 * @author arvind8692
 *
 */
public class LinkedList {
	
	Node head;
	
	class Node{
		Node next;
		int data;
		public Node(int d){
			data=d;
			next=null;
		}
	}

	/**
	 * 
	 */
	public LinkedList(int d) {
		System.out.println("\n creating a linked list with initial value : "+d);
		head= new Node(d);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ls= new LinkedList(12);
		ls.push(13);
		ls.push(19);
		ls.printLinkedlist();
		ls.push(26);
		ls.pushAfter(33,19);
		ls.printLinkedlist();
		ls.append(34);
		ls.printLinkedlist();
		ls.deleteByValue(19);
		ls.printLinkedlist();
		ls.deleteByIndex(2);
		ls.printLinkedlist();
	}

	private void deleteByIndex(int index) {
		System.out.println("\n deleting node at index :"+index);
		Node node=head;
		Node prevNode=null;
		for(int i=0;i<index-1;i++){
			prevNode=node;
			node=node.next;
		}
		prevNode.next=node.next;
	}

	private void deleteByValue(int value) {
		System.out.println("\n deleting value from linked list :"+value);
		Node node=head;
		Node prevNode=null;
		while(node!=null){
			if(node.data==value){
				prevNode.next=node.next;
				return;
			}
			prevNode=node;
			node=node.next;
			
		}
				
	}

	private void append(int data) {
		System.out.println("\n appending value at the end : "+data);
		Node node=head;
		while(node!=null){
			if(node.next==null){
				node.next=new Node(data);
				return;
			}
		node=node.next;
		}
	}

	private void pushAfter(int newValue, int after) {
		Node node=head;
		while(node!=null){
			
			if(node.data==after){
				System.out.println("\n inserting number : "+newValue+" after :"+after);
				Node newNode= new Node(newValue);
				newNode.next=node.next;
				node.next=newNode;
				return;
			}
		node=node.next;
		}
	}

	private void printLinkedlist() {
		Node node=head;
		while (node!=null){
			System.out.print(node.data+"->");
			node=node.next;
		}
		
	}

	private void push(int data) {
		System.out.println("\n inserting value in linked list :"+data);
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
	}

}


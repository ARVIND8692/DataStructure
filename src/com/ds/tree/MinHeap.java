package com.ds.tree;
public class MinHeap {
	int[] harr;
	int capacity;
	int size;
	
	public MinHeap(int heapCapacity) {
		capacity=heapCapacity;
		harr=new int[capacity];
		int size=0;	
	}
	public boolean insert(int value){
		if(size==capacity){
			System.out.println("\n Overflow, can not insert");
			return false;
		}
		size++;
		int i=size-1;
		harr[i]=value;
		
		while(i!=0 && harr[parent(i)]>harr[i]){
			swap(harr,i,parent(i));
			i=parent(i);
		}
	return true;
	}
	private void swap(int[] harr2, int i, int parent) {
		// TODO Auto-generated method stub
		
	}
	private int parent(int i) {
		return (i-1)/2;
	}
	
	private int left(int i){
		return 2*i+1;
	}
	
	private int right(int i){
		return 2*i+2;	
	}
	public static void main (String args[]){
		
	}
}
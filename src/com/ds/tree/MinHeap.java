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
		
		fixUpwards(size-1);
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
	private int getMin() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return Integer.MAX_VALUE;
		}
		return harr[0];
	}
	private int extractMin(){
		if(size<=0){
			System.out.println("Heap underflow");
			return Integer.MAX_VALUE;
		}
		if(size==1) {
			size--;
			return harr[0];
		}
		int root=harr[0];
		harr[0]=harr[size-1];
		minHeapify(0);
		
		return root;
	}
	private void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l<size && harr[l] <harr[smallest]){
			smallest=l;
		}
		if(r<size && harr[l]<harr[smallest]){
			smallest=r;
		}
		if(smallest!=i){
			swap(harr,i,smallest);
			minHeapify(smallest);
		}
	}
	private void delete(int i) {
		decreaseKey(i,Integer.MIN_VALUE);
		extractMin();
	}
	private void decreaseKey(int i, int newKey) {
		harr[i] = newKey;
		fixUpwards(i); 
	}
	
	private void fixUpwards(int i) {
		while(i != 0 && harr[i] < harr[parent(i)]) {
			swap(harr,i,parent(i));
			i = parent(i);
		}
	}
	private void printMinHeap() {
		for(int i=0;i<size;i++)
			System.out.print(harr[i] + " ");
		System.out.println();
	}
	public static void main (String args[]){
		MinHeap mh = new MinHeap(5);
		 
		mh.insert(3);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(2);
		mh.printMinHeap();
		System.out.println();
 
		mh.delete(1);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(15);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(5);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(4);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(45);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(50);
		mh.printMinHeap();
		System.out.println();
 
		System.out.println("Extracted min: " + mh.extractMin());
		mh.printMinHeap();
		System.out.println();
 
		System.out.println("Min: " + mh.getMin());
		mh.printMinHeap();
		System.out.println();
 
		mh.decreaseKey(2,1);
		mh.printMinHeap();
		System.out.println();
 
		System.out.println("Min: " + mh.getMin());
		mh.printMinHeap();

	}
}
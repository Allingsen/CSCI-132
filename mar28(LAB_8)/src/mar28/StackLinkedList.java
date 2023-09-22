package mar28;

import java.util.LinkedList;

public class StackLinkedList {
	private LinkedList<String> data;
	private String top_of_stack;
	private int size;
	
	public StackLinkedList() {
		this.data = new LinkedList<String>();
		this.top_of_stack = null;
		this.size = 0;
	}
	
	public void push(String newElement) {
		this.data.addFirst(newElement);
		this.size++;
		this.top_of_stack = newElement;
	}
	
	public String pop() {
		if (this.size == 0) {
			return null;
		}
		else if (this.size == 1) {
			String old_top = this.top_of_stack;
			this.data.removeFirst();
			this.top_of_stack = null;
			this.size--;
			return(old_top);
		}
		else {
			String old_top = this.top_of_stack;
			this.data.removeFirst();
			this.top_of_stack = this.data.getFirst();
			this.size--;
			return(old_top);
		}
		
	}
	
	public String peek() {
		if(this.size != 0) {
			return this.top_of_stack;
		}
		else {
			return ("nothing");
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (this.size == 0) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public void printStack() {
		System.out.println("The Stack\n-------------");
		for(int i = 0; i < this.size; i++) {
			System.out.println((i+1)+ ": " + this.data.get(i));
		}
	}
}

package feb28;

import java.util.Random;


public class CircularLinkedList {

	private Node head;
	private Node tail;
	private int size = 0;
	
	public CircularLinkedList() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void addAfterTail(Node newNode) {
		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
			
		}
		if (this.size == 1) {
			newNode.setNext(this.head);
			newNode.setPrev(this.tail);
			this.head.setNext(newNode);
			this.head.setPrev(newNode);
			this.tail = newNode;
		}
		else {
			this.head.setPrev(newNode);
			this.tail.setNext(newNode);
			newNode.setNext(this.head);
			newNode.setPrev(this.tail);
			this.tail = newNode;
			
		}
		this.size++;
	}
	
	public void printCircularLinkedList(boolean isReversed) {
		Node current = this.head;
		int counter = 1;
		if (isReversed == false) {
			for (int i = 0; i < size; i++) {
				System.out.print(counter + ": ");
				current.printNode();
				current = current.getNext();
				counter++;
			}
		}
		else {
			current = this.tail;
			for (int i = 0; i < size; i++) {
				System.out.print(counter + ": ");
				current.printNode();
				current = current.getPrev();
				counter++;
			 }
		}
	}
	
	public Node selectRandomCountry(boolean isReversed) {
		Random rand = new Random();
		int num = rand.nextInt(11);
		Node current = this.head;
		
		System.out.println("Random value generated: " + num);
		if (isReversed == false) {
			for (int i = 0; i < num; i++) {
				current = current.getNext();
			}
			System.out.println("Country selected: " + current.getName());
		}
		else {
			for (int i = 0; i < num; i++) {
				current = current.getPrev();
			}
			System.out.println("Country Selected: " + current.getName());
		}
		return current;
	}
	
	public void remove(Node removeNode) {
		Node current = this.head;
		for (int i = 0; i < size; i++) {
			if (removeNode.getName().equals(current.getName())) {
				if (current == this.head) {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					this.head = current.getNext();
					size--;
				}
				else if (current == this.tail) {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					this.tail = current.getPrev();
					size--;
				}
				else {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					size--;
				}
			}
			current = current.getNext();
		}
	}
	
}

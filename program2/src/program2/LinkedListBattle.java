package program2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class LinkedListBattle {
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedListBattle() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void addToFront(Node newNode) {
		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
			
		}
		if (this.size == 1) {
			newNode.setNext(this.tail);
			newNode.setPrev(this.head);
			this.head.setNext(newNode);
			this.head.setPrev(newNode);
			this.head = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.head.setPrev(newNode);
			newNode.setNext(this.head);
			newNode.setPrev(this.tail);
			this.head = newNode;
			
		}
		this.size++;
	}
	
public void fillLinkedList(String filename) {
		
		String line = "";
		try {
			BufferedReader br = new BufferedReader( new FileReader(filename));
			while((line=br.readLine()) != null) {
				String[] vals = line.split(",");
				String name = vals[0];
				int power_level = Integer.parseInt(vals[1]);
				
				Node n = new Node(name, power_level);
				addToFront(n);	
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("");
		}
		
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

public void simulateOneRound() {
	Node current_j = this.head;
	Node current_k = this.head;
	
	Random julio_rodriguez = new Random();
	
	int j = julio_rodriguez.nextInt(1, size+1);
	int k = julio_rodriguez.nextInt(1, size+1);
	
	for (int i = 1; i < j; i++) {
		current_j = current_j.getNext();
	}
	for (int i = 1; i < k; i++) {
		current_k = current_k.getPrev();
	}
	
	while (current_j.getName().equals(current_k.getName())) {
		k = julio_rodriguez.nextInt(1, size+1);
		j = julio_rodriguez.nextInt(1, size+1);
		for (int i = 1; i < j; i++) {
			current_j = current_j.getNext();
		}
		for (int i = 1; i < k; i++) {
			current_k = current_k.getPrev();
		}
	}
	
	System.out.println("j: "+ j);
	System.out.println("k: "+ k);
	
	System.out.println("+---------------------+");
	
	
	System.out.println("Nodes selected");
	System.out.println(current_j.getName());
	System.out.println(current_j.getPowerLevel());
	System.out.println("vs.");
	System.out.println(current_k.getName());
	System.out.println(current_k.getPowerLevel());
	System.out.println("+---------------------+");
	
	if (current_j.getPowerLevel() > current_k.getPowerLevel()) {
		System.out.println(current_j.getName() + " wins");
		System.out.println(current_k.getName() + " has been eliminated\n");
		remove(current_k);
	}
	else if (current_k.getPowerLevel() > current_j.getPowerLevel()) {
		System.out.println(current_k.getName() + " wins");
		System.out.println(current_j.getName() + " has been eliminated\n");
		remove(current_j);
	}
	else {
		System.out.println("Its a tie!");
	}
		
	
		
}

public void checkWinner() {
	if (size == 1) {
		System.out.print("The winner is: " + this.head.getName());
		System.exit(0);
	}
}

public void printCircularLinkedList() {
	Node current = this.head;
	System.out.println("Challengers Remaining:\n---------------------------");
	for (int i = 0; i < size; i++) {
		System.out.println(current.printNode() + "\n");
		current = current.getNext();
		}
	}

}

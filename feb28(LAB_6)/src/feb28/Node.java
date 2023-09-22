package feb28;

public class Node {

	private String name;
	
	private Node next;
	private Node prev;
	
	public Node(String n) {
		this.name = n;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public void setNext(Node newNode) {
		this.next = newNode;
	}
	
	public void setPrev(Node newNode) {
		this.prev = newNode;
	}
	
	public void printNode( ) {
		System.out.println(this.name);
	}
	
	public String getName() {
		return this.name;
	}
}


package feb21;

public class Node {

	private String name;
	private int year;
	
	private Node next;
	
	public Node(String s, int a) {
		this.name = s;
		this.year = a;
		this.next = null;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node n) {
		this.next = n;
	}
	
	public String getData() {
		return this.name + "(" + this.year + ")";
	}
	
	public String getName() {
		return this.name;
	}
	
}

package feb21;

public class SinglyLinkedList {

	private Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void addToBack(Node newNode) {
			
			if(head == null) {
				head = newNode;
			}
			else {
				Node current = head;
				while(current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(newNode);
			}
		}
	
	public void removeFirst() {
		if(this.head != null) {
			this.head = this.head.getNext();
		}
	}
	
	public void insert(Node newMovie, int n) {
		Node current = this.head;
		Node current_next = current.getNext();
		int spot = 0;
		while (spot != n-2) {
			current = current.getNext();
			current_next = current.getNext();
			spot++;
		}
		current.setNext(newMovie);
		newMovie.setNext(current_next);
		}
	
	public int searchForMovie(String m) {
		Node current = this.head;
		int spot = 0;
		while (current != null) {
			spot++;
			if (current.getName().equals(m)) {
				System.out.println("Movie: " + current.getName() + " was found at spot #" + spot);
				return(1);
			}
			current = current.getNext();
		}
		if (current == null) {
			System.out.println("Movie: " + m + " was not found");
			return(0);
		}
		return(0);
	}
	
	public int getSize() {
		Node current = this.head;
		int counter = 0;
		while (current != null) {
			counter++;
			current = current.getNext();
		}
		return counter;
	}
	
	public void printList() {
		Node current = this.head;
		while(current != null) {
			System.out.println("-" + current.getData());
			current = current.getNext();
		}
		
	}
	
	
}

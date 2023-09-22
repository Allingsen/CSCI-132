package apr4;


public class QueueArray {
	private Car[] cars;
	private int size;
	private int front;
	private int capacity;
	private int cars_serviced;
	private double cash;
	
	public QueueArray(int s) {
		this.cars = new Car[s];
		this.size = 0;
		this.front = 0;
		this.cars_serviced = 0;
		this.cash = 0;
		this.capacity = this.cars.length;
	}
	
	public void enqueue(Car newCar) {
		if(this.size == this.capacity) {
			System.out.println("Error: Queue is full- Cannot add " + newCar.getInfo());
			return;
		}
		System.out.println("Adding " + newCar.getInfo() + " to the queue");
		int insert_spot = (front + size) % capacity;
		this.cars[insert_spot] = newCar;
		this.size++;
	}
	
	public void dequeue() {
		if(this.size == 0) {
			System.out.println("No more cars!! Time to close..");
			return;
		}
		else {
			Car o = this.cars[front];
			this.cars[front] = null;
			front = (front + 1) % capacity;
			this.cars_serviced++;
			this.size--;
			if (o.getVip() == true) {
				this.cash += 6.0;
			}
			else {
				this.cash += 10.0;
			}
			System.out.println("Car has been washed. Removing " + o.getInfo() + " from the queue" );
		}
	}
	
	public Car peek() {
		return this.cars[front];
	}
	
	public boolean isEmpty() {
		if (this.size == 0) {
			return(true);
		}
		else {
			return false;
		}
	}
	
	public void printQueue() {
		int start = front;
		int counter = 1;
		int n = 0;
		System.out.println("Current Car Wash Queue\n----------------------");
		while(n != this.size) {
			System.out.println(counter + ". " + this.cars[start].getInfo());
			start = (start + 1) % capacity;
			counter++;
			n++;
		}
	}
	
	public void printStats() {
		System.out.println("Car Wash Statistics\n-------------------");
		System.out.println("Number of cars serviced: " + this.cars_serviced);
		System.out.println("Today's earnings: $" + this.cash);
	}
}

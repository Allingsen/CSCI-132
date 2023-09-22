package jan31;

public class Dog {
	private String name;
	private String breed;
	private int age;
	private double weight;
	private double[] walkDistance;
	
	public Dog(String name, String breed, int age, double weight, double[] walkDistance) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
		this.walkDistance = walkDistance;
	}
	public String getName() {
		return this.name;
	}
	public int getDogAge() {
		return this.age * 7;
	}
	public void printInfo() {
		System.out.println("Name: " + this.name + " (" + this.breed + ")");
		System.out.println("Age: " + this.age);
		System.out.println("Weight: " + this.weight + " lbs");
	}
	public double getTotalMiles() {
		double distance = 0.0;
		for(double i: this.walkDistance) {
			distance += i;
		}
		return distance;
	}
	public void checkWalkingScore(double miles) {
		if( miles < 3.5) {
			System.out.println(this.name + " needs to be walked more!");
		}
		else if(miles >= 3.5 && miles <= 5) {
			System.out.println(this.name + " is being walked a healthy amount!");
		}
		else {
			System.out.print(this.name + "is being walked a lot!");
		}
	}
	
}

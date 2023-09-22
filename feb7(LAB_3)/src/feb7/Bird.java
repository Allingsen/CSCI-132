package feb7;

public class Bird extends Animal {
	
	private double wingspan;
	
	public Bird(String species, double weight, String continent, int population, double wingspan) {
		super(species, weight, continent, population);
		this.wingspan = wingspan;
	}
	
	public double getWingSpan() {
		return this.wingspan;
	}
	
	public void makeSound() {
		System.out.println("The bird goes chirp chirp chirp!");
	}
}

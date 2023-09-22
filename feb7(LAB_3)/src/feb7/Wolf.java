package feb7;

public class Wolf extends Animal {
	
	private int packSize;
	
	public Wolf (String species, double weight, String continent, int population, int packSize) {
		super(species, weight, continent, population);
		this.packSize = packSize;
	}

	public int getPackSize() {
		return this.packSize;
	}
	
	public void makeSound() {
		System.out.println("The wolf goes Arh-wooooo!");
	}
}

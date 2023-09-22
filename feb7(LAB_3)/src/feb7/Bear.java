package feb7;

public class Bear extends Animal {
	
	private String diet;
	
	public Bear(String species, double weight, String continent, int population, String diet) {
		super (species, weight, continent, population);
		this.diet = diet;
	}
	
	public String getDiet() {
		return this.diet;
	}
	
	public void makeSound() {
		System.out.println("The bear goes Grrrrrrrr!");
	}
}

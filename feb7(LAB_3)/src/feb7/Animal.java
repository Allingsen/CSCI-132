package feb7;

public class Animal {
	private String species;
	private double weight;
	private String continent;
	private int population;
	
	public Animal(String species, double weight, String continent, int population) {
		this.species = species;
		this.weight = weight;
		this.continent = continent;
		this.population = population;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String getContinent() {
		return this.continent;
	}
	
	public int checkPopulation() {
		if(this.population <= 2500) {
			System.out.println("This animal is endangered!");
			return this.population;
		}
		else {
			return this.population;
		}
	}
	
}

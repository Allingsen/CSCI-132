package feb14;

public class EquilateralTriangle implements RegularPolygon {

	private double side_length;
	
	public EquilateralTriangle(double side_length) {
		
		this.side_length = side_length;
	}
	
	@Override
	public double area() {
		return ((Math.sqrt(3.0)/4.0)*((this.side_length)*(this.side_length)));
	}

	@Override
	public double perimeter() {
		return (3 * this.side_length);
	}

}

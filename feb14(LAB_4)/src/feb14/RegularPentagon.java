package feb14;

public class RegularPentagon implements RegularPolygon {

	private double side_length;
	
	public RegularPentagon(double side_length) {
		
		this.side_length = side_length;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return ((1.0/4.0)*(Math.sqrt(5.0*(5.0+(2.0*Math.sqrt(5.0))))) * (this.side_length *this.side_length));
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (5 * this.side_length);
	}
}

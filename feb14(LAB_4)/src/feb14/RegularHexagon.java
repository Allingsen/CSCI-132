package feb14;

public class RegularHexagon implements RegularPolygon {

	private double side_length;
	
	public RegularHexagon(double side_length) {
		
		this.side_length = side_length;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (((Math.sqrt(3)*3)/2)* (this.side_length * this.side_length));
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (6*this.side_length);
	} 

}

package feb14;

public class Square implements RegularPolygon {

	private double side_length;
	
	public Square(double side_length) {
		
		this.side_length = side_length;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (this.side_length * this.side_length);
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (4 * this.side_length);
	}
}
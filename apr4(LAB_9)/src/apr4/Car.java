package apr4;

public class Car {
	private String make_model;
	private String owner;
	private boolean is_vip;
	
	public Car(String m, String o, boolean v) {
		this.make_model = m;
		this.owner = o;
		this.is_vip = v;
	}
	
	public String getInfo() {
		return (this.make_model + " (" + this.owner + ")");
	}
	
	public boolean getVip() {
		return this.is_vip;
	}

}

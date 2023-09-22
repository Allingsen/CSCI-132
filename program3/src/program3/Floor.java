package program3;

public class Floor {
	int floor_num;
	String floor_type;
	String floor_data;
	
	public Floor(int n, String ft, String fd) {
		this.floor_num = n;
		this.floor_type = ft;
		this.floor_data = fd;
	}

	public void printFloor() {
		System.out.println("+-----------------------------\n|\tFloor " + this.floor_num);
		System.out.println("|\t" + floor_type + "(" + floor_data + ")");
	}
	
	public String printInfo() {
		return(floor_type + "(" + floor_data + ")");
	}
	
	public String getName() {
		return(this.floor_data);
	}
	
	public String getType() {
		return(this.floor_type);
	}
}

package program3;

import java.util.Scanner;



public class StackBuilding {
	private Floor[] data;
	private int top_of_stack;
	private int size;
	
	public StackBuilding() {
		this.data = new Floor[10];
		this.top_of_stack = -1;
		this.size = 0;
	}

	public void addFloor() {
		Scanner sc = new Scanner(System.in);
		if (size == 10) {
			System.out.println("Building is full. Please remove a floor first.");
		}
		else {
			System.out.println("1. New Classroom\n2. New Office\n3. New Research Lab");
			int choice = sc.nextInt();
			String inp = sc.nextLine();
			if (choice == 1) {
				size++;
				this.top_of_stack++;
				System.out.println("What course will be offered in this classroom?");
				inp = sc.nextLine();
				Floor newFloor = new Floor(size, "Classroom", inp);
				data[top_of_stack] = newFloor;
				System.out.println("Added: " + newFloor.printInfo());
			}
			else if (choice == 2) {
				size++;
				this.top_of_stack++;
				System.out.println("What professor will be inhabiting this office?");
				inp = sc.nextLine();
				Floor newFloor = new Floor(size, "Office", inp);
				data[top_of_stack] = newFloor;
				System.out.println("Added: " + newFloor.printInfo());
			}
			else if (choice == 3) {
				size++;
				this.top_of_stack++;
				System.out.println("What type of lab will this be?");
				inp = sc.nextLine();
				Floor newFloor = new Floor(size, "Research Lab", inp);
				data[top_of_stack] = newFloor;
				System.out.println("Added: " + newFloor.printInfo());
			}
		}
	}
	
	public void printStack() {
		for (int i = this.size-1; i >= 0; i--) {
			this.data[i].printFloor();
		}
	}
	
	public void removeFloor() {
		if (this.size == 0) {
			return;
		}
		else {
			Floor temp = this.data[this.top_of_stack];
			this.data[this.top_of_stack] = null;
			System.out.println("Removed: " + temp.printInfo());
			this.top_of_stack--;
			size--;
		}
	}
	
	public void searchForClassroom(String s) {	
		for (int i = 0; i <= this.size-1; i++) {
			if (s.equals(data[i].getName())) {
				System.out.println(s + " is found on floor #" + (i+1));
				return;
			}
		}
		System.out.println(s + " is not offered in Gianforte Hall.");
	}
	
	public void printBuildingInfo() {
		int classrooms = 0;
		int offices = 0;
		int labs = 0;
		for (int i = 0; i <= this.size-1; i++) {
			if (data[i].getType() == "Classroom") {
				classrooms++;
			}
			else if (data[i].getType() == "Office") {
				offices++;
			}
			else if (data[i].getType() == "Research Lab") {
				labs++;
			}
		}
		System.out.println("Number of Classrooms: " + classrooms);
		System.out.println("Number of Offices: " + offices);
		System.out.println("Number of Research Labs: " + labs);
	}
	
}

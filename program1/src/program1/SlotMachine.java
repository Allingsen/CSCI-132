package program1;

import java.util.Random;

public class SlotMachine {
	
	private int[] row1;
	private int[] row2;
	private int[] row3;
	private int credits;
	private int total_winnings;
	
	public SlotMachine(int[] row1, int[] row2, int[] row3, int credits, int total_winnings) {
		this.row1 = row1;
		this.row2 = row2;
		this.row3 = row3;
		this.credits = credits;
		this.total_winnings = total_winnings;
	}
	
	public void printMenu() {
		System.out.println("\nWelcome to Java Casino Slot Machine");
		System.out.println("Press 1 to play the slots once");
		System.out.println("Press 2 to play the slots X amount of times");
		System.out.println("Press 3 to print out this machine's total winnings");
		System.out.println("Press 4 to view your current credits");
		System.out.println("Press 5 to exit");
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getTotal_winnings() {
		return total_winnings;
	}
	
	public void reRoll() {
		Random rand = new Random();
		int[] row1 = {rand.nextInt(4), rand.nextInt(4), rand.nextInt(4)};
		int[] row2 = {rand.nextInt(4), rand.nextInt(4), rand.nextInt(4)};
		int[] row3 = {rand.nextInt(4), rand.nextInt(4), rand.nextInt(4)};
		this.row1 = row1;
		this.row2 = row2;
		this.row3 = row3;
	}

	public int playOneRound() {
		int new_winnings = 0;
		
		if(credits > 0) {
			this.credits -= 1;
			System.out.println("\n----------");
			System.out.println(row1[0] + "   " + row1[1] + "   " + row1[2]);
			System.out.println("----------");
			System.out.println(row2[0] + "   " + row2[1] + "   " + row2[2]);
			System.out.println("----------");
			System.out.println(row3[0] + "   " + row3[1] + "   " + row3[2]);
			System.out.println("----------");
			System.out.println("\nTotal Winnings");
			System.out.println("--------------");
			
			
			int total_top_row= row1[0] + row1[1] + row1[2];
			int total_mid_row= row2[0] + row2[1] + row2[2];
			int total_bot_row= row3[0] + row3[1] + row3[2];
			
			if(total_top_row + total_mid_row + total_bot_row > 20) {
				System.out.println("--> Sum of all numbers is greater than 20 (+2 credit)");
				new_winnings += 2;
			}
			
			if(row1[0] == row2[1] && row2[1] == row3[2]) {
				System.out.println("--> Matching Diagonals (+2 credit)");
				new_winnings += 2;
			}
			
			if(row1[2] == row2[1] && row2[1] == row3[0]) {
				System.out.println("--> Matching Diagonals (+2 credit)");
				new_winnings += 2;
			}
			
			if((row1[0] == row1[1]&&row1[1] == row1[2]) || (row2[0] == row2[1]&&row2[1] == row2[2]) || (row3[0] == row3[1]&&row1[1] == row3[2])) {
				System.out.println("--> Matching Row (+2 credit)");
				new_winnings += 2;
			}
			
			if((row1[0] == row2[0] && row2[0] == row3[0]) || (row1[1] == row2[1] && row2[1] == row3[1]) || (row1[2] == row2[2] && row2[2] == row3[2])) {
				System.out.println("--> Matching Column (+2 credit)");
				new_winnings += 2;
			}
			
			if(row1[0] == row1[2] && row1[2] == row3[0] && row3[0] == row3[2]) {
				 System.out.println("--> Matching Corners (+3 credit)");
				 new_winnings += 3;
			}
			
			System.out.print("You won a total of: " + new_winnings + " credits.\n");
		}
		else {
			System.out.println("You dont have enough credits!");
		}
		this.total_winnings += new_winnings;
		this.credits += new_winnings;
		return total_winnings;
	}
	

	
}

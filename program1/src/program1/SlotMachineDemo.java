package program1;

import java.util.Random;
import java.util.Scanner;

public class SlotMachineDemo {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int[] top_row = {rand.nextInt(4), rand.nextInt(4), rand.nextInt(4)};
		int[] mid_row = {rand.nextInt(4), rand.nextInt(4), rand.nextInt(4)};
		int[] bot_row = {rand.nextInt(4), rand.nextInt(4), rand.nextInt(4)};

		
		SlotMachine Ceasars = new SlotMachine(top_row, mid_row, bot_row, 10, 0);
		Ceasars.printMenu();
		
		Scanner scanner = new Scanner(System.in);		
		int input = scanner.nextInt();
		
			while(input != 5) {	
		
				if(input ==  1) {
					Ceasars.playOneRound();
					Ceasars.reRoll();
				}
				
				if(input == 2) {
					System.out.println("How many times would you like to roll the machine?");
					Scanner num_of_rolls = new Scanner(System.in);
					int rolls = num_of_rolls.nextInt();
					if(Ceasars.getCredits() >= rolls) {
						for(int i =1; i <= rolls; i++) {
							Ceasars.playOneRound();
							Ceasars.reRoll();	
						}
					}
					
					else {
						System.out.println("You dont have enough credits.");
					}
				}
				
				if(input == 3) {
					System.out.println("Total winnings paid out by this machine tonight is: " + Ceasars.getTotal_winnings());
				}
				
				if(input == 4) {
					System.out.println("Credits available: " + Ceasars.getCredits() +"\n");
				}
				
				Ceasars.printMenu();
				input = scanner.nextInt();
			}
			
			if(input == 5) {
				System.exit(0);
			}
			
	}
}
	




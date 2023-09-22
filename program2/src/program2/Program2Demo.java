package program2;

import java.util.Scanner;

public class Program2Demo {

	public static void main(String[] args) {
		
		LinkedListBattle llb = new LinkedListBattle();
		
		llb.fillLinkedList("participants.txt");
		llb.printCircularLinkedList();
		
		System.out.println("Would you like to continue? (y/n)");
		Scanner scanner = new Scanner(System.in);		
		String input = scanner.next();
		
		while (input.equals("y") || input.equals("Y")) {
			llb.simulateOneRound();
			llb.printCircularLinkedList();
			llb.checkWinner();
			System.out.println("Would you like to continue? (y/n)");
			input = scanner.next();
		}
	}
}

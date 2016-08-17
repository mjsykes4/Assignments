package simpleCraps;

import java.util.Scanner;

public class SimpleCraps {
	
	long seed = (new java.util.Date()).getTime();
	java.util.Random diceRoll = new java.util.Random(seed);
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the world of Craps!");
		SimpleCraps aSimpleCraps = new SimpleCraps();
		
		//Beginning of the do-while loop enabling playback
		do {
		int dieValue1 = aSimpleCraps.diceRoll.nextInt(6)+1;
		int dieValue2 = aSimpleCraps.diceRoll.nextInt(6)+1;
		int point = 0;
		int roll = dieValue1 + dieValue2;
		
		//Establishing first roll
		System.out.println("You rolled");
		System.out.println(roll);
		if(roll == 7) {
			System.out.println("You rolled a 7 on your first turn. You are a winner! Press Y then Enter to play again");
		} else if(roll == 2 || roll == 3 || roll == 12) {
			System.out.println("You rolled a 2, 3 or 12 on your first turn. You lose! Press Y then Enter to play again");
		} else { 
			
			//Point established after first roll did not end game
			point = roll;
			do {
				dieValue1 = aSimpleCraps.diceRoll.nextInt(6)+1;
				dieValue2 = aSimpleCraps.diceRoll.nextInt(6)+1;
				roll = dieValue1 + dieValue2;
				System.out.println("You rolled");
				System.out.println(roll);
			} while(roll != 7 && roll != point);
			if(roll ==7) {
				System.out.println("You rolled a 7. You lose! Press Y then Enter to play again");
			} else if(roll == point) {
				System.out.println("You rolled your established point. You win! Press Y then Enter to play again");
			}
		}
		// End of loop enabling playback
		} while (scan.nextLine().equalsIgnoreCase("y"));
		//Closed the earlier scan to prevent warning
		scan.close();
		}
	}
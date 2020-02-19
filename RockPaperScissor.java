//This program allows the user to play Rock Paper Scissor game with the computer by using different strategies.

import java.util.*;
public class Problem1 {
	public static void main(String[] args) {
		//Prompt the user to choose a strategy before playing
		Scanner console = new Scanner(System.in);
		System.out.println("Please choose your strategy (enter 1 or 2): ");
		int answer = console.nextInt();
		
		//If the user chooses 1, the program will execute play1(), in which the computer will choose entirely randomly
		//If the user enter "quit", he/she can quit the game
		if(answer == 1) {
			System.out.println("Enter Rock, Paper, or Scissors (or quit):");
			String user = console.next();
			while (!user.equalsIgnoreCase("quit")) {
				boolean test = play1(user, round());
				System.out.println("Enter Rock, Paper, or Scissors (or quit):");
				user = console.next();
			}
		/*If the user chooses 2, the program will execute play2(), in which the computer will keep choosing 
		the same item until it loses, and then it will randomly pick another item to start playing again*/
		} else if (answer == 2) {
			play2(console);
		}	
	}

	//Method round() randomly decides which item the computer is going to choose
	public static String round() {
		Random rand = new Random();
		int number = rand.nextInt(3);
		if (number == 0) {
			String computer = "Rock";
			return computer;
		} else if (number == 1) {
			String computer = "Paper";
			return computer;
		} else {
			String computer = "Scissors";
			return computer;
		}
	}

	/*Play1() is based on the strategy that the computer will randomly pick an item each round
	It will also determine whether the user wins or loses*/
	public static boolean play1(String a, String b) {
		if(a.equalsIgnoreCase(b)){
			System.out.println("Computer chooses " + b + ". It's a draw!");
			return true;
		} else {
			if(a.equalsIgnoreCase("Rock")){
				if(b.equalsIgnoreCase("Scissors")){
					System.out.println("Computer chooses " + b + ". You win!");
					return true;
				} else if(b.equalsIgnoreCase("Paper")){
					System.out.println("Computer chooses " + b + ". You lose!");
					return false;
				}
			} else if(a.equalsIgnoreCase("Paper")){
				if(b.equalsIgnoreCase("Rock")){
					System.out.println("Computer chooses " + b + ". You win!");
					return true;
				} else if(b.equalsIgnoreCase("Scissors")){
					System.out.println("Computer chooses " + b + ". You lose!");
					return false;
				}
			} else if(a.equalsIgnoreCase("Scissors")){
				if(b.equalsIgnoreCase("Paper")){
					System.out.println("Computer chooses " + b + ". You win!");
					return true;
				} else if(b.equalsIgnoreCase("Rock")){
					System.out.println("Computer chooses " + b + ". You lose!");
					return false;
				}
			}
			return false;
		}
	}

	/*Play2() is based on the strategy that the computer will keep choosing the same item until it loses, 
	and then it will randomly pick another item to start playing again. E.g. computer first randomly picked
	rock and won. It will keep picking rock until it loses.*/
	public static void play2(Scanner console) {
		System.out.println("Enter Rock, Paper, or Scissors (or quit):");
		String user = console.next();
		String temp = "";
		boolean test = false;
		while (!user.equalsIgnoreCase("quit")) {
			if (test == false) {
				temp = round();
				test = play1(user, temp);
			} else {
				test = play1(user, temp);
			}
			System.out.println("Enter Rock, Paper, or Scissors (or quit):");
			user = console.next();
		}
	}
}
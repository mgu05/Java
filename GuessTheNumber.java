//This program allows the user to play a simple guessing game with the computer.

import java.util.*;
public class Problem2 {
	
	public static void main(String[] args) {
		//Prompt the user to think of a number that is less than 100
		int maximum = 100;
		System.out.println("This program allows you to play a guessing game. \nThink of a number between 1 and 100 \nand I will guess until I get it.");
		System.out.println("For each guess, tell me if the \nright answer is higher or lower than your guess, or if it is correct.");

		System.out.println("Think of a number...");

		//Call for method play()
		int times = play(maximum);
		System.out.println("I got it right in " + times + " times");
		int total_games = 1;
		int total_guesses = times;
		int max = times;
		//int sum = times;
		Scanner console = new Scanner(System.in);
		System.out.println("Do you want to play again? Enter Yes or No:");
		String again = console.next();
		while (! again.startsWith("N")) {
			times= play(maximum);
			max = Math.max(max,times);
			total_guesses += times;
			total_games = total_games + 1;
			System.out.println("I got it right in " + times + " times");

			//Ask if the user wants to play again 
			System.out.println("Do you want to play again? Enter Yes or No:");
			again = console.next();
		}

		//Print out computer's guessing statistics
		System.out.println();
		System.out.println("Overall results:");
		System.out.println("Total games: " + total_games);
		System.out.println("Total guesses: " + total_guesses);
		System.out.println("Guesses/names: " + (double) total_guesses/total_games);
		System.out.println("Max guesses: " + max);
	}

	/*Method play() determines whether each time computer's guess is higher or lower than the actual number and 
	provides feedback to the computer for its next guess*/
	public static int play(int maximum){
		int count = 0;
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		int number = rand.nextInt(maximum) + 1;
		int high = 100;
		int low = 0;
		
		System.out.println("My guess: " + number);
		String answer = console.next();
		while (! answer.equals("correct")) {
			/*If computer's previous guess is too low, then the previous guess becomes the lower boundary of the
			range that the computer can choose number from*/
			if(answer.equals("higher") ){
				low = number + 1;
				number = rand.nextInt(high - low + 1) + low;
				System.out.println("My guess: " + number);
				answer = console.next();
			/*If computer's previous guess is too high, then the previous guess becomes the upper boundary of the
			range that the computer can choose number from*/	
			} else if (answer.equals("lower")){
				high = number - 1;
				number = rand.nextInt(high - low + 1) + low;
				System.out.println("My guess: " + number);
				answer = console.next();
			}
			//Count the number of guesses the computer made before reaching the correct result
			count++;
		}
		return count;
	}
}
//This program allows the user to play a reverse Hangman game with the computer.

import java.util.*;
public class Problem3 {
	public static void main(String[] args) {
		//Prompt the user
		System.out.println("This program plays a game of reverse hangman. \nYou think up a word (by typing it on the computer) and I'll try to guess \nthe letters.");
		Scanner console = new Scanner(System.in);
		System.out.println();
		System.out.print("How many letters are in your word?");
		int letter = console.nextInt();
		System.out.print("Please enter the word for me to guess (letters only):");
		String word = console.next();
		//Call for method play()
		play(letter, word);
	}

	/*Method play() executes the main part of the game by repeating the process of guessing - checking if it is correct - 
	updating result - drawing the hangman*/
	public static void play(int letter, String word){
		Scanner console = new Scanner(System.in);
		int count_right = 0;
		int count_wrong = 0;
		String empty = "";
		
		//String initial is for adding all the letters that already have been guessed. It will be updated each time.
		String initial = " ";
		
		//Create a string of "-" equals to the length of user's word
		String dash = "";
			for(int a = 1; a <= letter; a++){
				dash = dash + "-";
			}
		System.out.println(dash);
		hangman(count_wrong);

		/*The computer will continue play the game unless the wrong gusess it made exceeds 6 or 
		it gets the correct word in less than 6 failed attempt*/
		while(count_wrong <= 6 && ! empty.equals(word)) {
			//Call for method guessing()
			char guess = guessing(initial);
			initial = initial + guess;
			
			//Update computer's playing statistics
			System.out.println();
			System.out.println("I've got " + count_right + " of the " + letter + " letters so far");
			System.out.println("I guess: " + (""+guess).toUpperCase());
			
			//Determine whether the computer's guessed letted is in the word
			System.out.print("Is that letter in the word? Enter Y or N: ");
			String answer = console.next();
			//If it is not in the word, then count_wrong increments by 1
			if (answer.equalsIgnoreCase("N")) {
				count_wrong = count_wrong + 1;
			/*If it is in the word, ask the user how many of that letter are in the word
			and count_right increments by the number that the user entered*/
			}else if(answer.equalsIgnoreCase("Y")){
				System.out.print("How many of that letter are in the word? ");
				int letter_in_word = console.nextInt();
				count_right = count_right + letter_in_word;
			}

			//Update the current result of the computer's total guesses (a mixture of correctly guessed letters and dashes "-")
			empty = "";
			for(int i = 0; i <= letter - 1; i++){
				if(guess != word.charAt(i)){
					empty = empty + dash.charAt(i);
				}else if (guess == word.charAt(i)){
					empty = empty + word.charAt(i);
				}
			}
			dash = empty;
			//Print out current result
			System.out.println(empty);
			//Call for method hangman(); complete the hangman depending on currect number of wrong guesses
			hangman(count_wrong);
		}
		System.out.println();
		System.out.println();
		
		//If the computer's wrong guesses >= 7 then it loses
		if(count_wrong >= 7){
			System.out.println(empty);
			hangman(6);
			System.out.println("You beat me this time.");
		//Otherwise it gets the correct word
		}else if(empty == word) {
			System.out.println(word);
			hangman(count_wrong);
			System.out.println("I got the word right!");
		}	
	}

	//Method guessing() randomly decides a letter the computer is going to guess each time without repeating previous guesses
	public static char guessing(String initial){
		Random rand = new Random();
		int rand_num = 0;
		int test1 = 0;
		boolean repeat = false;

		while(repeat == false){
			test1 = 0;
			rand_num = rand.nextInt(26) + 97;
			//System.out.println("rand_num before checking: " + (char)rand_num);
			for(int x = 0; x < initial.length(); x++){
				//System.out.println("x equals:" + x);
				if(initial.charAt(x) == (char)rand_num){
					//System.out.println("(repeating) x eqauls: " + x);
					test1++;
				}
			}
			if(test1 != 0){
				repeat = false;
			}else{
				repeat = true;
			}
		}
		return (char)rand_num;
	}

	//Method hangman() calls for method drawing() by passing different strings into it, depending on the number of wrong guesses.
	public static void hangman(int count_wrong){
		if(count_wrong == 0){
			drawing("|  ", "|  ", "|  ");
		}else if(count_wrong == 1){
			drawing("|  0", "|  ", "|  ");
		}else if(count_wrong == 2){
			drawing("|  0", "|  |", "|  ");
		}else if(count_wrong ==3){
			drawing("|  0", "|  |", "|   \\");
		}else if(count_wrong ==4){
			drawing("|  0", "|  |", "| / \\");
		}else if(count_wrong ==5){
			drawing("|  0", "|  |\\", "| / \\");
		}else if(count_wrong ==6){
			drawing("|  0", "| /|\\", "| / \\");
		}
	}

	//Method drawing() draws the actual hangman
	public static void drawing(String a, String b, String c){
		System.out.println("+--+");
		System.out.println("|  |");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("|");
		System.out.println("+-----");
	}
}
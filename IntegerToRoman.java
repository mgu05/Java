//This program takes in an integer (less than 4999) and converts it into Roman numeral. 


import java.util.*;
public class Problem2 {
	public static void main(String[] args) {
		//Prompt the user and read input of an integer (no bigger than 4999)
		Scanner console = new Scanner(System.in);
		System.out.println("Enter an integer (not bigger than 4999):");
		int number = console.nextInt();
		
		//Display the result
		System.out.print(number + " in Roman numeral is ");
		roman(number);
		System.out.println();
	}

	//roman() method determines whether the input is > 999 (4-digit), >=100 and <= 999 (3-digit), >= 10 and <= 99 (2-digit), or <= 10 (single-digit)
	public static void roman(int number) {
		//If the number is 4-digit it will display the corresponding thousands-digit in Roman numeral
		//And then call for the digit() method 3 times by passing different parameters into it
		if (number > 999) {
			for (int i = 1; i <= number/1000%10; i++) {
				System.out.print("M");
			}
			digit(number, 100, "D", "C", "M" );
			digit(number, 10, "L", "X", "C");
			digit(number, 1, "V", "I", "X");
		//If the number is 3-digit it will call for the method 3 times by passing different parameters into it
		} else if (number <= 999 && number >= 100) {
			digit(number, 100, "D", "C", "M" );
			digit(number, 10, "L", "X", "C");
			digit(number, 1, "V", "I", "X");
		//If the number is 2-digit it will call for the method 2 times by passing different parameters into it
		} else if (number <= 99 && number >= 10) {
			digit(number, 10, "L", "X", "C");
			digit(number, 1, "V", "I", "X");
		//If the number is single-digit it will call for the method 1 time 
		} else {
			digit(number, 1, "V", "I", "X");
		}
	}

	//Method digit() determines the corresponding Roman numeral for each digit
	public static void digit(int number, int dec, String a, String b, String c) {
		if (number/dec%10 >5 && number/dec%10 < 9) {
				System.out.print(a);
				for (int j = 1; j <= number/dec%10-5; j++) {
					System.out.print(b);
				}
			} else if (number/dec%10 == 5) {
				System.out.print(a);
			} else if (number/dec%10 == 4) {
				System.out.print(b+a);
			} else if (number/dec%10 < 4 && number/dec%10 > 0) {
				for (int k = 1; k <= number/dec%10; k++) {
					System.out.print(b);
				}
			} else if (number/dec%10 == 9) {
				System.out.print(b+c);
		}
	}
	
}
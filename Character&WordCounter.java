//This program counts the number of words, lines and total characters in a document.

import java.util.*;
import java.io.*;

public class Problem1{
	public static void main(String[] args) throws FileNotFoundException{
		//Prompt the user for the file's name
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter the name of the file (e.g. hello.txt):");
		String name = console.nextLine();
		File f = new File(name);
		Scanner input = new Scanner(f);

		int count_line = 0;
		int count_word = 0;
		int count_space = 0;
		int count_character = 0;
		//Count the number of lines
		while(input.hasNextLine()){
			String line = input.nextLine();
			count_line++;

			//Count the number of words
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()){
				String word = lineScan.next();
				count_word++;
			}
			//Count the number of characters (without spaces)
			int length = line.length();
			for(int i = 0; i < length; i ++){
				if(line.charAt(i) == ' '){
					count_space++;
				}else{
					count_character++;
				}
			}
		}
		//Print out the result
		System.out.println("This file has " + count_line + " lines, " + count_word + " words, and " + count_character + " characters.");
	}
}
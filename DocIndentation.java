//This program prints out a java file with proper indentation.

import java.util.*;
import java.io.*;
public class Problem2{
	public static final int SPACE = 4;
	public static void main(String[] args) throws FileNotFoundException{
		//Prompt the user for the file's name
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter the name of the file (e.g. hello.java):");
		String name = console.nextLine();
		File f = new File(name);
		Scanner input = new Scanner(f);
		int indentation = 0;
		
		PrintStream ps = new PrintStream(new File("printfile.java"));

		while(input.hasNextLine()){
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			String word = " ";
			if (lineScan.hasNext()) {
				word = lineScan.next();
			}

			int length = line.length();
			
			//Print out a blank line if the line in that file is blank
			if(length == 0){
				ps.println();
				print_indent(indentation, ps);
			//Otherwise print out the contents in that line
			}else{
				//int indentation = 0;
				//If the line is ended with '{', next line is indented with 4 more spaces
				if(line.charAt(length - 1) =='{'){
					ps.println(line);
					indentation += SPACE;
					print_indent(indentation, ps);
				//If the line starts with '}' and does not end with a '{', indentation level is decreased by 4
				}else if(word.charAt(0) =='}' && line.charAt(length - 1)!='{'){
					ps.println(line);
					indentation -= SPACE;
					print_indent(indentation, ps);
				//If the line starts with a '}' and ends with a '{', indentation level is not changed
				}else if(word.charAt(0) =='}'){
					ps.println(line);
					print_indent(indentation, ps);
				//If the line does not contain any '{' or '}', indentation level is not changed
				}else{
					ps.println(line);
					print_indent(indentation, ps);
				}
			}
		}
		ps.println("}");
	}
	//Determine the level of indentation
	public static void print_indent(int indentation, PrintStream ps){
		for(int i = 0; i < indentation; i++){
			ps.print(" ");
		}
	}
}
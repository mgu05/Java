//This program plays the tic-tac-toe game between an user and the computer. 

import java.util.*;
public class Problem1 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to Tic-Tac-Toe.");
		boolean order = true;
		String answer = "";
		//Prompt the user
		do{
			char[][] board = new char[3][3];
			gameBoard(board);
			System.out.println("Please choose whether you want to start first (enter 1)\nor you want the computer to start first (enter 2):");
			int answer_order = console.nextInt();
			if(answer_order == 1){
				order = true;
			}else{
				order = false;
			}
			check(board, order);
			System.out.println("Do you want to play the game again? Enter Y or N: ");
			answer = console.next();
		}while(! answer.equalsIgnoreCase("N"));
	}

	//Check whether if there is a winner or the game board is full 
	public static void check(char[][]board, boolean order){
		boolean flag = false;
		int count_full = 0;
		while(flag == false && count_full < 9){
			//Decide whether the user or the computer moves first
			if(order == true){
				order = user(board, order);
				display(board);
				count_full++;
				flag = check_win(board, flag);
			}else{
				order = computer(board, order);
				display(board);
				count_full++;
				flag = check_win(board, flag);
			}
		}
		//Determine who won the game or if it is a draw
		if(flag == true){
			if(order == true){
				System.out.println("Computer wins!");
			}else{
				System.out.println("You win!");
			}
		}else{
			System.out.println("It's a draw!");
		}
	}
	//Prompt the user to make moves
	public static boolean user(char[][]board, boolean order){
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter the x-coordinate (row) of your move (0-2): ");
		int x = console.nextInt();
		System.out.print("Please enter the y-coordinate (columns) of your move (0-2): ");
		int y = console.nextInt();
		while (board[x][y] != '-') {
			System.out.print("Error! Please enter the x-coordinate (row) of your move (0-2): ");
			x = console.nextInt();
			System.out.print("Error! Please enter the y-coordinate (columns) of your move (0-2): ");
			y = console.nextInt();
		}
		board[x][y] = 'o';
		order = false;
		return order;
	}
	/*Computer's turn to make moves. Priority of moves: if the computer can win the game by makeing the next move, do it.
	Otherwise, take the move that will prevent the user from winning. If neither of the previous two is necessary, then the 
	computer can move randomly.*/
	public static boolean computer(char[][]board, boolean order){	
		int count_circle = 0;
		int count_cross = 0;
		int current_row = 0;
		int current_column = 0;
		//Check through rows to see if there are two in a row
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == 'o'){
					count_circle++;
				}else if(board[i][j] == 'x'){
					count_cross++;
				}
			}
			//If the computer has two in a row and it's not blocked, then it should complete its three-in-a-row first in order to win
			if(count_cross == 2){
				current_row = i;
				for(int a = 0; a < 3; a++){
					if(board[current_row][a] == '-'){
						board[current_row][a] = 'x';
						order = true;
						return order;
					}
				}
			//Otherwise the computer should blcok the user's move first
			}else if(count_circle == 2){
				current_row = i;
				for(int a = 0; a < 3; a++){
					if(board[current_row][a] == '-'){
						board[current_row][a] = 'x';
						order = true;
						return order;
					}
				}
			}
			count_circle = 0;
			count_cross = 0;				
		}
		//Check through columns to see if there are two in a column
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 3; x++){
				if(board[x][y] == 'o'){
					count_circle++;
				}else if(board[x][y] == 'x'){
					count_cross++;
				}
			}
			if(count_cross == 2){
				current_column = y;
				for(int p = 0; p <3; p++){
					if(board[p][current_column] == '-'){
						board[p][current_column] = 'x';
						order = true;
						return order;
					}
				}
			}else if(count_circle == 2){
				current_column = y;
				for(int p = 0; p <3; p++){
					if(board[p][current_column] == '-'){
						board[p][current_column] = 'x';
						order = true;
						return order;
					}
				}
			}
			count_circle = 0;
			count_cross = 0;
		}

		//Check the two diagonals
		if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == '-'){
			board[2][2] = 'x';
			order = true;
			return order;
		}else if(board[0][0] == 'x' && board[1][1] == '-' && board[2][2] == 'x'){
			board[1][1] = 'x';
			order = true;
			return order;
		}else if(board[0][0] == '-' && board[1][1] == 'x' && board[2][2] == 'x'){
			board[0][0] = 'x';
			order = true;
			return order;
		}else if(board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == '-'){
			board[2][0] = 'x';
			order = true;
			return order;
		}else if(board[0][2] == 'x' && board[1][1] == '-' && board[2][0] == 'x'){
			board[1][1] = 'x';
			order = true;
			return order;
		}else if (board[0][2] == '-' && board[1][1] == 'x' && board[2][0] == 'x'){
			board[0][2] = 'x';
			order = true;
			return order;
		}else if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == '-'){
			board[2][2] = 'x';
			order = true;
			return order;
		}else if (board[0][0] == 'o' && board[1][1] == '-' && board[2][2] == 'o'){
			board[1][1] = 'x';
			order = true;
			return order;
		}else if (board[0][0] == '-' && board[1][1] == 'o' && board[2][2] == 'o'){
			board[0][0] = 'x';
			order = true;
			return order;
		}else if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == '-'){
			board[2][0] = 'x';
			order = true;
			return order;
		}else if (board[0][2] == 'o' && board[1][1] == '-' && board[2][0] == 'o'){
			board[1][1] = 'x';
			order = true;
			return order;
		}else if (board[0][2] == '-' && board[1][1] == 'o' && board[2][0] == 'o'){
			board[0][2] = 'x';
			order = true;
			return order;
		}

		//If the computer dose not need to block anything after checking the above three methods, it then makes a move randomly
		Random rand = new Random();
		int rand_x = rand.nextInt(3);
		int rand_y = rand.nextInt(3);
		while (board[rand_x][rand_y] != '-'){
			rand_x = rand.nextInt(3);
			rand_y = rand.nextInt(3);
		}
		board[rand_x][rand_y] = 'x';
		order = true;
		return order;
	}

	//This method checks if now there is a winner after each move (either by user or by computer)
	public static boolean check_win(char[][]board, boolean flag){
		int all_three_circle = 0;
		int all_three_cross = 0;
		//Check through rows
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == 'o'){
					all_three_circle++;
				}else if(board[i][j] == 'x'){
					all_three_cross++;
				}
			}
			if(all_three_circle == 3){
				flag = true;
				return flag;
			}else if(all_three_cross == 3){
				flag = true;
				return flag;
			}
			all_three_circle = 0;
			all_three_cross = 0;
		}

		//Check through columns
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 3; x++){
				if(board[x][y] == 'o'){
					all_three_circle++;
				}else if(board[x][y] == 'x'){
					all_three_cross++;
				}
			}
			if(all_three_circle == 3){
				flag = true;
				return flag;
			}else if(all_three_cross == 3){
				flag = true;
				return flag;
			}
			all_three_circle = 0;
			all_three_cross = 0;
		}
		//Check the 2 diagonals
		if(board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o'){
			flag = true;
			return flag;
		}else if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x'){
			flag = true;
			return flag;
		}else if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o'){
			flag = true;
			return flag;
		}else if(board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x'){
			flag = true;
			return flag;
		}else{
			return flag;
		}
	}
	public static void gameBoard(char[][] board){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = '-';
				System.out.print(board[i][j]);
			}
			System.out.println();
		}	
	}

	//This method displays the gameboard after each move
	public static void display(char[][] board){
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
	}
}
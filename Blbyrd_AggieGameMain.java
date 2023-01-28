/*
 * Brandon L. Byrd
 * COMP 167-001
 * October 1, 2022
 * 
 * Welcome to the Aggie Game, this project chooses the first person get four-in-a-row as a winner.
 * There is a one player mode and a two player mode.
*/

import java.util.Scanner;
import java.util.Random;

public class Blbyrd_AggieGameMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		Random random = new Random();
		int player = 1;
		int winner = 0;
		int row = 0;
		int col = 0;
		final int BOARD_SIZE = 10;
		char gameBoard[][] = new char[BOARD_SIZE][BOARD_SIZE]; // creates 2D array for the game
		
		Blbyrd_Methods.printBulldog(); // prints our mascot
		Blbyrd_Methods.printChooseMode(); // prompts the user to choose a game mode
		int gameMode = scnr.nextInt(); // stores user input in game-mode
		System.out.println("");
		
		if (gameMode == 1) { // tells the user what game mode they chose
			System.out.println("You chose One Player Mode!"); 
		} else {
			System.out.println("You chose Two Player Mode!"); 
		} // branch
		
		Blbyrd_Methods.printBoard(gameBoard, BOARD_SIZE); // prints the game board based on "gameBoard" note: the board size variable is there so I can practice not using magic numbers.
		
		
		while (Blbyrd_Methods.isWinner(gameBoard, row, col, BOARD_SIZE) == false) { // the game runs on a loop until there is a winner
			if (gameMode == 1) { // different prompts for different game modes
				System.out.print("Your move!, Enter the coordinates of your move here (row space column): ");
			} else {
				System.out.print("Player #"+player+", Enter the coordinates of your move here (row then column): ");	
			} //close conditional bracket
			
			row = scnr.nextInt(); // user enters row
			col = scnr.nextInt(); // user enters column
			gameBoard[row][col] = 'X'; // X is placed in the 2D array
			System.out.println(""); // whitespace
			System.out.println("Player #"+player+"'s coordinates "+row+", "+col+"."); // user feed-back  telling what coordinates were entered.
			Blbyrd_Methods.printBoard(gameBoard, BOARD_SIZE); // prints the board with an X is the coordinates picked by the user
			if (Blbyrd_Methods.isWinner(gameBoard, row, col, BOARD_SIZE)) {  // checks the board for Four-In-A-Row
				winner = player; // winner is stored. In two player mode, 'player' is switched every time the while loop iterates. 
				break; // breaks the loop and declares the winner. 
			}
			
			if (gameMode == 1) { // if the user chose to play against the CPU, a random number is picked for the row and the column
				System.out.print("Enter any interger to see the CPU's move: ");
				scnr.nextInt();
				row = random.nextInt(10);
				col = random.nextInt(10);
				gameBoard[row][col] = 'X';
				System.out.println("CPU's coordinates "+row+", "+col+".");
				Blbyrd_Methods.printBoard(gameBoard, BOARD_SIZE);
				if (Blbyrd_Methods.isWinner(gameBoard, row, col, BOARD_SIZE)) {
					winner = 0; // CPU is called Player 0 in this game for simplicity sake
					break; // breaks the loop and declares the winner
				} // branch
						
			} else if (player == 1) { // when gameMode isn't 1 then gameMode == 2; player is switched; while loop starts again for new player
				player = 2;
			} else {
				player = 1;
			} // close branch
		} // close loop
		if (winner == 1 || winner == 2) { // winner is displayed after the loop is exited
			Blbyrd_Methods.printBulldog(); // prints our mascot
			System.out.print("Winner, Winner, Chicken Dinner!!! Congrats to Player #"+winner+"!! You are the winner!!!"); // winner displayed
		} else {
			Blbyrd_Methods.printBulldog(); // prints our mascot
			System.out.print("You lost to the CPU :( ");
		} // close branch
		scnr.close(); // no leaks
	}

}

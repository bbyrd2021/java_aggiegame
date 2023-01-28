/*
 * Brandon L. Byrd
 * COMP 167-001
 * October 1, 2022
 * 
 * This file is comprised of the methods used in Aggie Game
*/

public class Blbyrd_Methods {
	
	public static void printBulldog() { // prints the mascot of our illustrious institution
		System.out.println(" ,--.____                                     ____.--.       ");
		System.out.println("/  .'.'\"``--...----------.___.----------...--''\"`.`.  \\   ");
		System.out.println("| .'.'         .                       .         `.`. |      ");
		System.out.println("`. .'|     . ' - . _    `-----'    _ . - ' .     |`. .'      ");
		System.out.println(" `.' `|   .'   _     \"-._     _.-\"     _   `.   |' `.'     ");
		System.out.println("      |  |        \" -.           .- \"        |  |          ");
		System.out.println("       \\|        ;;..  \"|i. .i|\"  ..;;        |/          ");
		System.out.println("       `|      ,---.``.   ' '   .'',---.      |'             ");
		System.out.println("        |    <'(__.'>.'---` '---`.<`.__)`>    |              ");
		System.out.println("        |   `. `~  .'  ,-------.  `.  ~'.'    |              ");
		System.out.println("        |  |=_\"`=.'  . `-.___.-' .  `.='\"_=|  |            ");
		System.out.println("        |  |  ==/  : ` :   i   : ' :  \\==  |  |             ");
		System.out.println("        |  | ==/      /\\___|___/\\      \\== |  |           ");
		System.out.println("         `.| =Y      .' \"\"\"_\"\"\" `.      Y= |.'         ");
		System.out.println("           L ||      ;  .==\"==.  ;      || J                ");
		System.out.println("            \\ ;     .' '       ` `.     ; /                 ");
		System.out.println("             `.     ;             ;     .'                   ");
		System.out.println("              ;    ;'\\           /`;    ;                   ");
		System.out.println("              `;  .'.'/.       ,\\`.`.  ;'                   ");
		System.out.println("               `-=;_-'  `-----'  `-_;=-'                     ");
		System.out.println("");
	} // printBulldog 
	
	public static void printChooseMode() { // self explanatory
		System.out.println("            . . . . . . . . . . . . . . . .");
		System.out.println("            .                             .");
		System.out.println("            . Welcome to the Aggie Game!! .");
		System.out.println("            .                             .");
		System.out.println("            . . . . . . . . . . . . . . . .");
		System.out.println("");
		System.out.println("            .     (1) One Player Mode     .");
		System.out.println("            .     (2) Two Player Mode     .");
		System.out.println("");
		System.out.print("         Pick your game mode by entering 1 or 2: ");
	} // close brackets printChooseMode()
	
	
	public static void printBoard(char[][] board, int SIZE) { // method for printing a blank board (size adjustable)
		System.out.println("");
		for (int i = 0; i < SIZE; ++i) { //fills the black board
			for (int j = 0; j < SIZE; ++j) {
				if (board[i][j] == 'X') {
					continue; // skips the X's
				} else {
					board[i][j] = '-'; // fills board spots with '_'
				} // close branch
			} // inner loop
		} // outer loop
		System.out.print(" ");
		for (int i = 0; i < SIZE; ++i) { 
			System.out.print(" "+i+" "); // labels the x-axis of the board
		} // for loop
		System.out.println("");
		for (int i = 0; i < SIZE; ++i) { 
			System.out.print(i); // labels the y axis of the board
			for (int j = 0; j < SIZE; ++j) {
				System.out.print(" "+board[i][j]+" ");
			} // inner loop
			System.out.println("");
		} // outer loop
		
		System.out.println("");
	} // printBoard()
	
	public static boolean isFourInARowVertical( char[][] board, int col, int SIZE) { // checks board for vertical matches
		int count = 0;
		for (int i = 0; i < SIZE; ++i) {
			if (board[i][col] == 'X') {
				++count;
				if (count == 4) {
					return true;
				} // branch
				
			} else {
				count = 0;
			} // branch
		} // loop
		return false;
	} // isFourInARowVertical()
	
	public static boolean isFourInARowHorizontal( char[][] board, int row, int SIZE) { // checks board for horizontal matches
		int count = 0;
		for (int i = 0; i < SIZE; ++i) {
			if (board[row][i] == 'X') {
				++count;
				if (count == 4) {
					return true;
				} // branch
				
			} else {
				count = 0;
			} // branch
		} //loop
		return false;
	} // isFourInARowHorizontal
	
	// For checking diagonally, there is definitely a more efficient way but this is what I have. 
	
	public static boolean isDiagonalTopDownLeftRightA(char [][] board, int SIZE) { // checks the half of the board going diagonally top-down
		for (int rowStart = 0; rowStart < SIZE-3; ++rowStart) {
			int count = 0;
			int row, col;
			for (row = rowStart, col = 0; row < SIZE && col < SIZE; ++row, ++col) {
				if (board[row][col] == 'X') {
					++count;
					if (count >= 4) {
						return true;
					} // branch
				} else {
					count = 0;
				} // branch
			} // inner loop
		} // outer loop
		return false;
	} // isDiagonalTopDownLeftRightA()

	public static boolean isDiagonalTopDownLeftRightB(char [][] board, int SIZE) { // checks other half of the board going diagonally top-down
		for (int colStart = 1; colStart < SIZE-3; ++colStart) {
			int count = 0;
			int row, col;
			for (row = 0, col = colStart; row < SIZE && col < SIZE; ++row, ++col) {
				if (board[row][col] == 'X') {
					++count;
					if (count >= 4) {
						return true;
					} // branch
				} else {
					count = 0;
				} // branch
			} // inner loop		
		} //outer loop
		return false;
	} // isDiagonalTopDownLeftRightB()
	
	public static boolean isDiagonalBottomUpLeftRightA(char [][] board, int SIZE) { // checks half of the board going bottom-up
		for (int rowStart = SIZE-1; rowStart >= 3; --rowStart) {
			int count = 0;
			int row, col;
			for (row = rowStart, col = 0; row >= 0 && col < SIZE; --row, ++col) { 
				if (board[row][col] == 'X') {
					++count;
					if (count >= 4) {
						return true;
					}
				} else {
					count = 0;
				} // branch
			} // inner loop
		} // outer loop 
		return false;
	} // isDiagonalBottomUpLeftRightA()
	
	public static boolean isDiagonalBottomUpLeftRightB(char [][] board, int SIZE) { // checks other half of the board going bottom-up
		for (int colStart = 1; colStart < SIZE-3; ++colStart) {
			int count = 0;
			int row, col;
			for (row = SIZE-1, col = colStart; row >= 1 && col < SIZE; --row, ++col) { 
				if (board[row][col] == 'X') {
					++count;
					if (count >= 4) {
						return true;
					} // branch
				} else {
					count = 0;
				} // branch
			} //  inner loop
		} // outer loop
		return false;
	} // isDiagonalBottomUpLeftRightB()
	
	
	public static boolean isWinner(char [][] board, int row, int col, int SIZE) { // uses all winning situations in one function call
		if ( isFourInARowVertical(board, col, SIZE) ||
			 isFourInARowHorizontal(board, row, SIZE) ||
			 isDiagonalTopDownLeftRightA(board, SIZE) ||
			 isDiagonalTopDownLeftRightB(board, SIZE) || 
			 isDiagonalBottomUpLeftRightA(board, SIZE) ||
			 isDiagonalBottomUpLeftRightB(board, SIZE)) {
			return true;
		} else {
			return false;
		} // branch
	} // isWinner
} // Methods













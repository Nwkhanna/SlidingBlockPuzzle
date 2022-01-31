//Nikhil Khanna(nkhanna3@u.rochester.edu) and David Tang(dtang5@u.rochester.edu)
import java.util.Scanner;
import java.util.Random;


public class Puzzle {
	private int[][] puzzle = { {0, 1, 2, 3} , { 4, 5, 6, 7 } , 
			{8, 9, 10, 11} , {12, 13, 14, 15} };
	
	private int row = 0;
	private int col = 0;
	private String difficulty = null;
	private int moveCounter = 0;
	Random rand = new Random();
	
	public Puzzle() {
		
	}
	
	
	/**
	 * returns the amount of moves done so far
	 * Note: moveCounter only increments if the move is done by
	 * the move() method. It will not increment if the move is 
	 * invalid (i.e moving up when 0 is in the top row)
	 * @return duh
	 */
	public int getCount() {
		return moveCounter;
	}
	
	/**
	 * Getter method for the difficulty of the puzzle;
	 */
	public String getDif() {
		return difficulty;
	}
	
	/**
	 * 
	 * @param r row of changed tile (0-3)
	 * @param c column of changed tile (0-3)
	 * @param temp number that is replacing at the tile 
	 */
	public void edit(int r, int c, int temp) {
		puzzle[r][c] = temp;
		if (temp == 0) {
			row = r;
			col = c;
		}
	}
	
	/**
	 * returns whether or not the puzzle is solved.
	 * 
	 * @return whether or not it is "solved"
	 */
	public boolean check() {
		int[] count2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		int count = 0;
		if (puzzle[0][0] == 0) {
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					if (puzzle[r][c] != count) {
						return false;
					}
					count++;
				}
			}
			return true;
		}
		else if (puzzle[0][0] == 1) {
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					if (puzzle[r][c] != count2[count]) {
						return false;
					}
					count++;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Takes a character, moves based on it. 
	 * 
	 * @param m takes a character U, D, L, R and uses them to move. Returns if the move happened or not.
	 * @return true if the move happened, false otherwise
	 */
	public boolean move(char m) {
		switch (m) {
			case 'U':
				if (up()) {
					moveCounter++;
					return true;
				}
				return false;
			case 'D':
				if (down()) {
					moveCounter++;
					return true;
				}
				return false;
			case 'L':
				if (left()) {
					moveCounter++;
					return true;
				}
				return false;
			case 'R':
				if (right()) {
					moveCounter++;
					return true;
				}
				return false;
			default:
				return false;
		}
	}
	
	/**
	 * method used to implement difficulty. Returns whether or not the move happened 
	 * 
	 * @return if the move happened or not
	 */
	public boolean randomMove() {
		int option = rand.nextInt(4);
		switch (option) {
			case 0:
				return up();
			case 1:
				return down();
			case 2:
				return left();
			case 3:
				return right();
			default:
				return false;
		}
	}
	
	/**
	 * moves 0 tile up
	 * @return whether or not it happened
	 */
	public boolean up() {
		int temp;
		if (row != 0) {
			temp = puzzle[row-1][ col];
			puzzle[row-1][col] = 0;
			puzzle[row][col] = temp;
			row -= 1;
			return true;
		}
		return false;
	}
	
	/**
	 * duh
	 * @return duh
	 */
	public boolean down() {
		int temp;
		if (row != 3) {
			temp = puzzle[row+1][ col];
			puzzle[row+1][col] = 0;
			puzzle[row][col] = temp;
			row += 1;
			return true;
		}
		return false;
	}
	
	/**
	 * duh
	 * @return duh
	 */
	public boolean left() {
		int temp;
		if (col != 0) {
			temp = puzzle[row][ col-1];
			puzzle[row][col-1] = 0;
			puzzle[row][col] = temp;
			col -= 1;
			return true;
		}
		return false;
	}
	
	/**
	 * duh
	 * @return duh
	 */
	public boolean right() {
		int temp;
		if (col != 3) {
			temp = puzzle[row][ col+1];
			puzzle[row][col+1] = 0;
			puzzle[row][col] = temp;
			col += 1;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the puzzle as a string.
	 */
	public String toString() {
		String temp = "";
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				temp = temp + puzzle[r][c] + "\t";
			}
			temp = temp + "\n";
		}
		return temp;
	}
	
	/**
	 * sets a difficulty level for the puzzle.
	 */
	public void difficulty() {
		System.out.println("Please enter a difficulty:");
		Scanner scnr = new Scanner(System.in);
		String dif = scnr.next();
		int count = 0;
		if (dif.toLowerCase().equals("easy")) {
			difficulty = "easy";
			while (count < 10) {
				if (randomMove()) {
					count++;
				}	
			}
		}
		else if (dif.toLowerCase().equals("medium")) {
			difficulty = "medium";
			while (count < 20) {
				if (randomMove()) {
					count++;
				}
			}
		}
		else if (dif.toLowerCase().equals("hard")) {
			difficulty = "hard";
			while (count < 40) {
				if (randomMove()) {
					count++;
				}
			}
		}
		else {
			System.out.print("That is not a valid difficulty. ");
			difficulty();
		}
	}
	
}

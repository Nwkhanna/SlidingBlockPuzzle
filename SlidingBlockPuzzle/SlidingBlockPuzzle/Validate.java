//Nikhil Khanna(nkhanna3@u.rochester.edu) and David Tang(dtang5@u.rochester.edu)
import java.util.Scanner;

class Validate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome! ");
		boolean keepPlaying = true;
		while (keepPlaying) {
			System.out.println("Please enter a puzzle and solution set.");
			Puzzle puzzle = new Puzzle();

			int moveCount = 0;
			Scanner scan = new Scanner(System.in);

			for (int i = 0; i < 4; i++) {
				String rows = scan.nextLine();
				String rowArray[] = rows.split(" ");
				for (int j = 0; j < 4; j++) {
					int b = Integer.parseInt(rowArray[j]);
					puzzle.edit(i,j,b);
				}
			}

			String playerInput = scan.nextLine();
			char[] playerCharInput = playerInput.toCharArray();
			
			for (char c : playerCharInput) {
				puzzle.move(c);
				
			}

			System.out.println(puzzle);
			
			if (puzzle.check()) {
				System.out.println(
						"This puzzle and solution set works");
				
				
			}
			else {
				System.out.println("This puzzle and solution set does not work.");
			}
			
			
		}
	}
}

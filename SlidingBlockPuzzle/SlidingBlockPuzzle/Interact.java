//Nikhil Khanna(nkhanna3@u.rochester.edu) and David Tang(dtang5@u.rochester.edu)
import java.util.Scanner;

class Interact {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome!");
		boolean keepPlaying = true;
		while (keepPlaying) {
			Puzzle puzzle = new Puzzle();
			puzzle.difficulty();
			System.out.println(puzzle);
			System.out.println(
					"Please enter a move, either U for up, D for down, L for left, R for right. You can enter more than one move at a time. You may also click x to quit");
			do {
				String playerInput = sc.nextLine();
				char[] playerCharInput = playerInput.toCharArray();
				for (char c : playerCharInput) {
					puzzle.move(c);
				}
				if (puzzle.check()) {
					System.out.println("You solved this " + puzzle.getDif() + " in " + puzzle.getCount()
							+ " moves! Would you like to play again?");
					if (sc.nextLine() == "yes" || sc.nextLine() == "Yes") {
						break;
					} else {
						keepPlaying = false;
						break;
					}
				}
				System.out.println(puzzle);			}

			while (true);
		}
	}
}

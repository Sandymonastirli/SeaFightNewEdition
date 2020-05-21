//Monastirli Chrysanthi

import java.util.Scanner;

public class BattleShip {
	private static Scanner scan;
	
	public static void main(String[] args) {
		String temp;
		scan = new Scanner(System.in);
		Player p1, p2;
		System.out.println("Choose type of game between vsHuman or vsComputer: [ c | h ]");
		do {
			temp = scan.nextLine();
		} while (!(temp.equals("c")||temp.equals("C")||temp.equals("h")||temp.equals("H")));
		
		if (temp.equals("c")||temp.equals("C")) {
			p1 = new HumanPlayer("Sandy");
			p2 = new ComputerPlayer();
			playGame(p1,p2);
		}
		else {
			p1 = new HumanPlayer("Sandy");
			p2 = new HumanPlayer("Mary");
			playGame(p1,p2);
		}
	}

	private static void playGame(Player p1, Player p2) {
		Vector2 strike;
		while (true) {
			
			// player a turn
			System.out.println(p1+" its your turn!");
			strike = p1.nextStrike();
			p1.update(strike, p2.getStrike(strike));
			p1.printStrikeBoard();
			if (p2.allShipsSank()) {System.out.println(p1+" wins!!"); break;}
			else if (p2.lastStrikeSankShip()) System.out.println("Boom! A ship is dead!");
			System.out.println();
			
			// player b turn
			System.out.println(p2+" its your turn!");
			strike = p2.nextStrike();
			p2.update(strike, p1.getStrike(strike));
			p2.printStrikeBoard();
			if (p1.allShipsSank()) {System.out.println(p2+" wins!!"); break;}
			else if (p1.lastStrikeSankShip()) System.out.println("Boom! A ship is dead!");
			System.out.println();
		}
		System.out.println("Game Over!");
	}
	
}

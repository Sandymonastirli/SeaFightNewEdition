// Monastirli Chrysanthi
import java.util.Scanner;

public class HumanShipBoard extends ShipBoard {
	
	public void enterAllShips() {
		scan = new Scanner(System.in);
		for (int i=0; i<super.SHIPS_NO;i++) {
			enterShipManually(i+1);
		}
		System.out.println("All "+ SHIPS_NO +" ships have been set:");
		printBoard();
	}
	
	private void enterShipManually(int id) {
		boolean horizontal;
		Vector2 point;
		while (true) {
			horizontal = readDirection(id);
			point = readStartingPoint(id);
			if (checkValid(id, horizontal, point)) break;
			else System.out.println("Ship " + id + ": Wrong position. Try again!");
		}
		placeShip(id, horizontal, point);
	}
	
	private boolean readDirection(int id) {
		boolean horizontal;
		String temp;
		System.out.println("Give direction of the ship "+ id + ": [ h | v ]");
		do {
			temp = scan.nextLine();
			if (temp.equals("h")||temp.equals("H")) horizontal = true;
			else horizontal = false;
		} while (!(temp.equals("v")||temp.equals("h")||temp.equals("V")||temp.equals("H")));
		if (horizontal) System.out.println("Direction of Ship "+ id + " has been set to Horizontal.");
		else System.out.println("Direction of Ship "+ id + " has been set to Vertical.");
		return horizontal;
	}
	
	private Vector2 readStartingPoint(int id) {
		Vector2 point;
		String[] temp2;
		
		System.out.println("Give the coordinates in which Ship "+ id+ " starts: [ x,y ]");
		while (true) {
			temp2 = scan.nextLine().split(",");
			if (temp2.length!=2) continue;
			try {
				point = new Vector2(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]));
			} catch(Exception e) {
				continue;
			}
			break;
		}
		System.out.println("Ship "+ id + " starting point has been set to "+point+".");
		return point;
	}
}

// Monastirli Chrysanthi
import java.util.Scanner;

public class HumanPlayer extends Player {
	Scanner scan;
	
	public HumanPlayer(String name) {
		super(name);
		scan = new Scanner(System.in);
	}

	public void createBoard() {
		shipBoard = new HumanShipBoard();
		System.out.println(name + " place your Ships!");
		shipBoard.enterAllShips();
		System.out.println();
	}
	
	public Vector2 nextStrike() {
		Vector2 point;
		String[] temp2;

		System.out.println("Give the coordinates of the point you want to strike: [ x,y ]");
		while (true) {
			temp2 = scan.nextLine().split(",");
			if (temp2.length!=2) continue;
			try {
				point = new Vector2(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]));
			} catch(Exception e) {
				continue;
			}
			if (point.getX()<0 || point.getX()>=BOARD_DIM || point.getY()<0 || point.getY()>= BOARD_DIM) {
				System.out.println("Invalid point. Try again!");
				continue;
			}
			break;
		}
		return point;
	}
	
	public void update(Vector2 point, boolean hit) {
		strikeBoard.addStrike(point, hit);
	}
	
	public boolean lastStrikeSankShip() {
		return shipBoard.lastStrikeSankShip();
	}
}

// Monastirli Chrysanthi 

import java.util.Random;

public class ComputerShipBoard extends ShipBoard {
	
	public void enterAllShips() {
		for (int i=0; i<SHIPS_NO;i++) {
			enterShipRandomly(i+1);
		}
		System.out.println("All "+ SHIPS_NO +" ships has been set:");
		printBoard();
	}
	
	public void enterShipRandomly(int id) {
		Random random = new Random();
		int vertOrHor, randX, randY;
		boolean hor;
		while (true) {
			vertOrHor = random.nextInt(2);
			if (vertOrHor==0) {
				hor = false;
				randX = random.nextInt(BOARD_DIM-shipLen[id-1]+1);
				randY = random.nextInt(10);
			}
			else {
				hor = true;
				randX = random.nextInt(10);
				randY = random.nextInt(BOARD_DIM-shipLen[id-1]+1);
			}
			Vector2 temp = new Vector2(randX, randY);
			if (checkValid(id, false, temp)) {
				placeShip(id, hor, temp);
				return;
			}
		}
	}
}

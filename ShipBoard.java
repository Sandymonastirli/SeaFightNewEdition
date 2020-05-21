//Monastirli Chrysanthi
import java.util.Scanner;


public abstract class ShipBoard {
	protected final int SHIPS_NO = 5, BOARD_DIM = 10;	// initializers
	protected static final int[] shipLen = {5, 4, 3, 3, 2}; 	// length of each ship
	Scanner scan;
	private int[][] board;
	private boolean[][] hasBeenHit;
	private boolean lastStrikeSank;
	private int[] hitsLeft; // how many hits are left for each ship
	private int shipsLeft;

	// constructor
	public ShipBoard() {
		board = new int[BOARD_DIM][BOARD_DIM];
		hasBeenHit = new boolean[BOARD_DIM][BOARD_DIM];
		for (int i = 0; i<BOARD_DIM;i++) {
			for (int j=0; j<BOARD_DIM; j++) {
				board[i][j] = 0;
				hasBeenHit[i][j] = false;
			}
		}
		
		hitsLeft = new int[SHIPS_NO];
		for (int i=0; i<SHIPS_NO;i++) {
			hitsLeft[i] = shipLen[i];
		}
		
		lastStrikeSank = false;
		shipsLeft = SHIPS_NO;
	}
	
	public abstract void enterAllShips();
	
	public boolean lastStrikeSankShip() {
		return lastStrikeSank;
	}
	
	public boolean allShipsSank() {
		return (shipsLeft == 0);
	}
	
	public boolean getStrike(Vector2 point) {
		lastStrikeSank = false;
		if (hasBeenHit[point.getX()][point.getY()]) {System.out.println(point + ": Already hit. Pay attention next time!"); return false;}
		hasBeenHit[point.getX()][point.getY()] = true;
		if (board[point.getX()][point.getY()]==0) {System.out.println(point+": Miss!"); return false;}
		if (--hitsLeft[board[point.getX()][point.getY()]-1]==0) {shipsLeft--; lastStrikeSank = true;}
		System.out.println(point + ": Hit!");
		return true;
	}
	
	public void printBoard() {
		for (int i = 0; i<BOARD_DIM;i++) {
			for (int j=0; j<BOARD_DIM; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	protected void placeShip(int id, boolean hor, Vector2 point) {
		int len = shipLen[id-1];
		if (hor) {
			for (int i = 0; i<len; i++) {
				board[point.getX()][point.getY()+i]= id;
			}
		}
		else {
			for (int i = 0; i<len; i++) {
				board[point.getX()+i][point.getY()] = id;
			}
		}
	}
	
	protected boolean checkValid (int id, boolean hor, Vector2 point) {
		int len = shipLen[id-1];
		if (point.getX()<0 || (!hor)&&point.getX()+len>BOARD_DIM || point.getX()>=BOARD_DIM) return false;
		if (point.getY()<0 || hor&&point.getY()+len>BOARD_DIM || point.getY()>= BOARD_DIM) return false;
		if (hor) {
			for (int i = 0; i<len; i++) {
				if (board[point.getX()][point.getY()+i] != 0) return false;
			}
		}
		else {
			for (int i = 0; i<len; i++) {
				if (board[point.getX()+i][point.getY()] != 0) return false;
			}
		}
		return true;
	}
}



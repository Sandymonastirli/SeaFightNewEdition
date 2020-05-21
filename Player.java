//Monastirli Chrysanthi
public abstract class Player {
	
	protected static final int BOARD_DIM = 10;
	protected String name;
	protected ShipBoard shipBoard;
	protected StrikeBoard strikeBoard;
	
	public Player(String name) {
		this.name = name;
		strikeBoard = new StrikeBoard();
		createBoard();
	}
	
	public abstract void createBoard();
	public abstract Vector2 nextStrike();
	public abstract void update(Vector2 point, boolean hit);
	public abstract boolean lastStrikeSankShip();
	
	public boolean getStrike(Vector2 point) {
		return shipBoard.getStrike(point);
	}
	
	public boolean allShipsSank() {
		return shipBoard.allShipsSank();
	}
	
	public String toString() {
		return name;
	}
	
	public void printShipBoard() {
		System.out.println("ShipBoard:");
		shipBoard.printBoard();
	}
	
	public void printStrikeBoard() {
		System.out.println("StrikeBoard:");
		strikeBoard.printBoard();
	}
}

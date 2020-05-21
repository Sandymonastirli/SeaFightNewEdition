// Monastirli Chrysanthi

public class ComputerPlayer extends Player{
	private ComputerStrategies computerStrategy;
	
	public ComputerPlayer() {
		super("HAL");
		computerStrategy = new ComputerStrategies(strikeBoard);
	}
	
	public void createBoard() {
		shipBoard = new ComputerShipBoard();
		shipBoard.enterAllShips();
	}
	
	public Vector2 nextStrike() {
		return computerStrategy.nextStrike();
	}
	
	public void update(Vector2 point, boolean hit) {
		strikeBoard.addStrike(point, hit);
		computerStrategy.update(point, hit);
	}
	
	private void completeExploration() {
		computerStrategy.completeExploration();
	}
	
	public boolean lastStrikeSankShip() {
		if (shipBoard.lastStrikeSankShip()) {
			completeExploration();
			return true;
		}
		else return false;
	}
}


public class Handler {
	private Grid grid;
	
	public Handler(Grid grid) {
		this.grid = grid;
	}
	
	public void click(Cell cell) {
		if (cell.isRevealed() || cell.isFlagged()) {
			return;
		} else {
			if(cell.isMined()) {
				grid.endGame(0);
			} else {
				grid.setVictoryCounter(grid.getVictoryCounter() + 1);	
			}
			cell.reveal();
			if(grid.checkVictory()) {
				grid.endGame(1);
			}
		}
	}
	
	public void rightClick(Cell cell) {
		if (cell.isRevealed()) {
			return;
		} else {
			if (!cell.isFlagged()) {
				cell.addImage("./Assets/flagged.png");	
				cell.setFlagged(true);
			} else {
				cell.addImage("./Assets/facingDown.png");
				cell.setFlagged(false);
			}
		}
	}
}


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
				System.out.println("is mined");
				grid.revealMines();
				// implementar fim de jogo aqui
			} else {
				System.out.println("is not mined");	
				System.out.println(cell.getNumOfMinesAround());
			}
			cell.reveal();
		}
	}
	
	public void rightClick(Cell cell) {
		if (cell.isRevealed()) {
			return;
		} else {
			if (!cell.isFlagged()) {
				cell.addImage("./Assets/flagged.png");
				System.out.println("put flag");	
				cell.setFlagged(true);
			} else {
				cell.addImage("./Assets/facingDown.png");
				System.out.println("remove flag");	
				cell.setFlagged(false);
			}
		}
	}
}

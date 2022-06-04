import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Grid extends JPanel{
	private Cell[][] cells;
	private int numLinhas;
	private int numColunas;
	
	public Grid() {
		setMaximumSize(new Dimension(500, 450));
		setLayout(new GridLayout(10,10));
		createCells(10, 10);
	}
	
	public void createCells(int numLinhas, int numColunas) {
		cells = new Cell[numLinhas][numColunas];
		for(int i = 0; i < numLinhas; i++) {
			for(int j = 0; j < numColunas; j++) {
				cells[i][j] = new Cell();
				add(cells[i][j]);
			}
		}
	}
	
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	
}
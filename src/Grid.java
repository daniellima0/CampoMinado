import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;


public class Grid extends JPanel{
	private Cell[][] cells;
	private int numOfLines = 10;
	private int numOfColumns = 10;
	private Handler handler;
	private int victoryCounter;
	
	public Grid() {
		handler = new Handler(this);
		setMaximumSize(new Dimension(420, 420));
		setLayout(new GridLayout(numOfLines,numOfColumns));
		// combine these functions
		createCells(numOfLines, numOfColumns, handler);
		addMinesToField();
		addNeighbors();
		addNumOfMinesAround();
	}
	
	public void addNumOfMinesAround() {
		for(int i = 0; i < numOfLines; i++) {
			for(int j = 0; j < numOfColumns; j++) {
				for(int k = 0; k < cells[i][j].neighbors.size(); k++) {
					if(cells[i][j].neighbors.get(k).isMined()) {
						cells[i][j].setNumOfMinesAround(cells[i][j].getNumOfMinesAround() + 1);
					}
				}
			}
		}
	}
	public void createCells(int numLinhas, int numColunas, Handler handler) {
		cells = new Cell[numLinhas][numColunas];
		for(int i = 0; i < numLinhas; i++) {
			for(int j = 0; j < numColunas; j++) {
				cells[i][j] = new Cell(handler);
				add(cells[i][j]);
			}
		}
	}

	public void addMinesToField(){
		int n = 10;
		Random rand = new Random();
		while (n > 0){            
			int l = rand.nextInt(numOfLines); 
			int c = rand.nextInt(numOfColumns);             
			if (cells[l][c].mine()){
				n--;
			}            
		}	 
	}

	public void addNeighbors() {
		for (int i = 0; i < numOfLines; i++) {
		    for (int j = 0; j < numOfColumns; j++) {
		        if (i > 0){
		            if (j > 0) cells[i][j].addNeighbor(cells[i-1][j-1]);
		            cells[i][j].addNeighbor(cells[i-1][j]);
		            if (j < numOfColumns-1) cells[i][j].addNeighbor(cells[i-1][j+1]);
		        }
		        
		        if (j > 0) cells[i][j].addNeighbor(cells[i][j-1]);                
		        if (j < numOfColumns-1)cells[i][j].addNeighbor(cells[i][j+1]);
		        
		        if(i < numOfLines -1){
		            if (j > 0)cells[i][j].addNeighbor(cells[i+1][j-1]);
		            cells[i][j].addNeighbor(cells[i+1][j]);
		            if (j < numOfColumns-1)cells[i][j].addNeighbor(cells[i+1][j+1]);
		        }
		    }
		}
	}
	
	public void revealMines() {
		for(int i = 0; i < numOfLines; i++) {
			for(int j = 0; j < numOfColumns; j++) {
				if (cells[i][j].isMined() && !cells[i][j].isRevealed()) {
					cells[i][j].reveal();
				}
			}
		}
	}
	
	// not used
	public void disableCells() {
		for (int i = 0; i < numOfLines; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				cells[i][j].setEnabled(false);
	        }
	    }
	}
	
	public boolean checkVictory() {
		System.out.println(victoryCounter);
		if (this.victoryCounter >= 90) return true;
		return false;
	}
	
	public void endGame(int endGameStatus) {
		if (endGameStatus == 1) {
			System.out.println("You won!");
		} else {
			revealMines();	
		}
	}

	// Getters and setters      --review which ones are note used and delete them
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public int getNumOfLines() {
		return numOfLines;
	}

	public void setNumOfLines(int numOfLines) {
		this.numOfLines = numOfLines;
	}

	public int getNumOfColumns() {
		return numOfColumns;
	}

	public void setNumOfColumns(int numOfColumns) {
		this.numOfColumns = numOfColumns;
	}

	public int getVictoryCounter() {
		return victoryCounter;
	}

	public void setVictoryCounter(int victoryCounter) {
		this.victoryCounter = victoryCounter;
	}
}
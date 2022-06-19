import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;


public class Grid extends JPanel{
	private Cell[][] cells;
	private int numOfLines = 10;
	private int numOfColumns = 10;
	
	public Grid() {
		setMaximumSize(new Dimension(420, 420));
		setLayout(new GridLayout(numOfLines,numOfColumns));
		createCells(numOfLines, numOfColumns);
		addMinesToField();
		addNeighbors();
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
	
	public void createCells(int numLinhas, int numColunas) {
		cells = new Cell[numLinhas][numColunas];
		for(int i = 0; i < numLinhas; i++) {
			for(int j = 0; j < numColunas; j++) {
				cells[i][j] = new Cell();
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
	
	// not used
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
	
	// Getters and setters
	public Cell[][] getCells() {
		return cells;
	}

	public int getNumLinhas() {
		return numOfLines;
	}

	public void setNumLinhas(int numLinhas) {
		this.numOfLines = numLinhas;
	}

	public int getNumColunas() {
		return numOfColumns;
	}

	public void setNumColunas(int numColunas) {
		this.numOfColumns = numColunas;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	
}
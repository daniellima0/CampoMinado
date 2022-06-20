import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Iterator;
import java.util.Random;


public class Grid extends JPanel{
	private Cell[][] cells;
	private int numOfLines;
	private int numOfColumns;
	private Handler handler;
	private int victoryCounter;
	
	public Grid() {
		numOfLines = 10;
		numOfColumns = 10;
		handler = new Handler(this);
		setMaximumSize(new Dimension(420, 420));
		setLayout(new GridLayout(numOfLines,numOfColumns));
		createCells(numOfLines, numOfColumns, handler);
		addMinesToField();
		addNeighbors();
		addNumOfMinesAround();
	}
	
	public void createCells(int numOfLines, int numOfColumns, Handler handler) {
		cells = new Cell[numOfLines][numOfColumns];
		for(int i = 0; i < numOfLines; i++) {
			for(int j = 0; j < numOfColumns; j++) {
				cells[i][j] = new Cell(handler);
				add(cells[i][j]);
			}
		}
	}
	
	public void removeCells(int numOfLines, int numOfColumns, Handler handler) {
		cells = new Cell[numOfLines][numOfColumns];
		for(int i = 0; i < numOfLines; i++) {
			for(int j = 0; j < numOfColumns; j++) {
				cells[i][j] = new Cell(handler);
				remove(cells[i][j]);
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
	
	public void revealMines() {
		for(int i = 0; i < numOfLines; i++) {
			for(int j = 0; j < numOfColumns; j++) {
				if (cells[i][j].isMined() && !cells[i][j].isRevealed()) {
					cells[i][j].reveal();
				}
			}
		}
	}
	
	public void disableAllCells() {
		for (int i = 0; i < numOfLines; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				if (!cells[i][j].isMined()) {
					cells[i][j].setEnabled(false);					
				}
	        }
	    }
	}
	
	public void disableUnrevealedCells() {
		for (int i = 0; i < numOfLines; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				if (cells[i][j].isMined() || !cells[i][j].isRevealed()) {
					cells[i][j].setEnabled(false);					
				}
	        }
	    }
	}
	
	public boolean checkVictory() {
		if (victoryCounter >= 90) return true;
		return false;
	}
	
	public void endGame(int endGameStatus) {
		if (endGameStatus == 1) {
			disableUnrevealedCells();
			System.out.println("You won!");
		} else {
			revealMines();
			disableAllCells();
		}
	}

	public void removeNeighbors() {
		for (int i = 0; i < numOfLines; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				Iterator<Cell> iterator = cells[i][j].getNeighbors().iterator();
				while (iterator.hasNext()) {
				   Cell nextIterator = iterator.next();
				   iterator.remove();
				}
			}
		}
	}
	
	public void resetGame() {
		for (int i = 0; i < numOfLines; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				cells[i][j].setEnabled(true);
				
				// Put initial image on the cell
				try {
				    Image img = ImageIO.read(getClass().getResource("./Assets/facingDown.png"));
				    img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
				    cells[i][j].setIcon(new ImageIcon(img));
				} catch (Exception ex) {
				    System.out.println(ex);
				}
				
				// Reset cell attributes
				cells[i][j].setMined(false);
				cells[i][j].setRevealed(false);
				cells[i][j].setFlagged(false);
				cells[i][j].setNumOfMinesAround(0);
			}
		}
		victoryCounter = 0;
		addMinesToField();
		removeNeighbors();
		addNeighbors();
		addNumOfMinesAround();
	}
	
	// Getters and setters
	public int getVictoryCounter() {
		return victoryCounter;
	}

	public void setVictoryCounter(int victoryCounter) {
		this.victoryCounter = victoryCounter;
	}
}
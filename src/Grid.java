import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;


public class Grid extends JPanel{
	private Cell[][] cells;
	private int numLinhas = 10;
	private int numColunas = 10;
	
	public Grid() {
		setMaximumSize(new Dimension(420, 420));
		setLayout(new GridLayout(numLinhas,numColunas));
		createCells(numLinhas, numColunas);
		adicionarMinas();
		adicionaVizinhos();
	}
	
	
	
	public void adicionaVizinhos() {
		for (int i = 0; i < numLinhas; i++) {
		    for (int j = 0; j < numColunas; j++) {
		        if (i > 0){
		            if (j > 0) cells[i][j].adicionarVizinho(cells[i-1][j-1]);
		            cells[i][j].adicionarVizinho(cells[i-1][j]);
		            if (j < numColunas-1) cells[i][j].adicionarVizinho(cells[i-1][j+1]);
		        }
		        
		        if (j > 0) cells[i][j].adicionarVizinho(cells[i][j-1]);                
		        if (j < numColunas-1)cells[i][j].adicionarVizinho(cells[i][j+1]);
		        
		        if(i < numLinhas -1){
		            if (j > 0)cells[i][j].adicionarVizinho(cells[i+1][j-1]);
		            cells[i][j].adicionarVizinho(cells[i+1][j]);
		            if (j < numColunas-1)cells[i][j].adicionarVizinho(cells[i+1][j+1]);
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
	
	public void adicionarMinas(){
        int n = 10;
        Random rand = new Random();
        while (n > 0){            
            int l = rand.nextInt(numLinhas); 
            int c = rand.nextInt(numColunas);             
            if (cells[l][c].minar()){
                n--;
            }            
        }	 
     }
	
	// não utilizada
	public void revelarMinas() {
		for(int i = 0; i < numLinhas; i++) {
			for(int j = 0; j < numColunas; j++) {
				if (cells[i][j].isMinado() && cells[i][j].isRevelado()) {
					
				}
			}
		}
	}
	
	// não utilizada
	public void desativaBotoes() {
		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < numColunas; j++) {
				cells[i][j].setEnabled(false);
	        }
	    }
	}
	
	//daqui pra baixo é get e set
	public Cell[][] getCells() {
		return cells;
	}

	public int getNumLinhas() {
		return numLinhas;
	}

	public void setNumLinhas(int numLinhas) {
		this.numLinhas = numLinhas;
	}

	public int getNumColunas() {
		return numColunas;
	}

	public void setNumColunas(int numColunas) {
		this.numColunas = numColunas;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	
}
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;


public class Grid extends JPanel{
	private Cell[][] cells;
	private int numLinhas = 10;
	private int numColunas = 10;
	
	public Grid() {
		setMaximumSize(new Dimension(500, 450));
		setLayout(new GridLayout(numLinhas,numColunas));
		createCells(numLinhas, numColunas);
		adicionarMinas();
		
		for (int i = 0; i < numLinhas; i++) {
		    for (int j = 0; j < numColunas; j++) {
		        if (i > 0){
		            if (j > 0) matriz[i][j].adicionarVizinhos(matriz[i-1][j-1]);
		            matriz[i][j].adicionarVizinhos(matriz[i-1][j]);
		            if (j < numColunas-1) matriz[i][j].adicionarVizinhos(matriz[i-1][j+1]);
		        }
		        
		        if (j > 0) matriz[i][j].adicionarVizinhos(matriz[i][j-1]);                
		        if (j < numColunas-1)matriz[i][j].adicionarVizinhos(matriz[i][j+1]);
		        
		        if(i < numLinhas -1){
		            if (j > 0)matriz[i][j].adicionarVizinhos(matriz[i+1][j-1]);
		            matriz[i][j].adicionarVizinhos(matriz[i+1][j]);
		            if (j < numColunas-1)matriz[i][j].adicionarVizinhos(matriz[i+1][j+1]);
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
	
	public int numMinasVizinhas(int linha, int coluna){
		int num = 0;
		
		// fazer que nem claudinho (criar vetor de vizinhos)
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		if(cells[linha - 1][coluna - 1].isMinado() == true) {
			num++;
		}
		
		return num;
	}
	
	 public void adicionarMinas(){
        int n = 30;
        Random rand = new Random();
        while (n > 0){            
            int l = rand.nextInt(numLinhas); 
            int c = rand.nextInt(numColunas);             
            if (cells[l][c].minar()){
                n--;
            }            
        }
	 }
	
	//daqui pra baixo é get e set
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	
}
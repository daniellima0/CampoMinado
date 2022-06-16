import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Cell extends JButton {
	private boolean minado;
	private boolean revelado;
	private boolean marcado;
	private boolean clicado;
	private int numMinasVizinhas;
	ArrayList<Cell> vizinhos;
	
//	public Cell(boolean minado) {
//		this.minado = minado;
//		revelado = false;
//		marcado = false;
//		clicado = false;
//	}
	
	public Cell() {
		minado = false;
		revelado = false;
		marcado = false;
		clicado = false;
		
		this.addMouseListener(new java.awt.event.MouseAdapter() {
	         public void mousePressed(MouseEvent e) {
	        	 if (SwingUtilities.isLeftMouseButton(e)) {
	        		 botaoEsquerdoPressionado();
	        	 } else if (SwingUtilities.isRightMouseButton(e)) {
	        		 botaoDireitoPressionado();
	             };
	         }
	     });
	}
	
	public boolean minar(){
		if(!this.minado){
			this.minado = true;
			return true;
		}else{
			return false;
		}
	}
	
	// checar:
	// se é minado
	// se o número de minas ao redor é igual a 0
	// mostrar o número de minas ao redor
	private void botaoEsquerdoPressionado() {
		if (this.revelado) {
			return;
		} else {
			if(this.minado) {
				System.out.println("ta minado");
				this.minado = true;
				// implementar fim de jogo aqui
			} else {
				System.out.println("nao ta minado");
				revelar();
			}
			
			
		}
		
	}
	
	private void botaoDireitoPressionado() {
		if (this.revelado) {
			return;
		} else {
			if (!this.marcado) {
				System.out.println("botar flag");	
				this.marcado = true;
			} else {
				System.out.println("tirar flag");	
				this.marcado = false;
			}
		}
	}
	
	public void revelar() {
		this.revelado = true;
		
		this.numMinasVizinhas = numMinasVizinhas(1, 2);
		
		if (numMinasVizinhas == 0) {
			// revelar o restante que é 0
		} else if (numMinasVizinhas == 1) {
			// botar jpg de 1 aqui
		}
	}
	
	public void adicionarVizinhos(Cell vizinho){
        this.vizinhos.add(vizinho);
    }
	
	// daqui pra baixo é get e set
	public boolean isMinado() {
		return minado;
	}

	public void setMinado(boolean minado) {
		this.minado = minado;
	}

	public boolean isRevelado() {
		return revelado;
	}

	public void setRevelado(boolean revelado) {
		this.revelado = revelado;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public boolean isClicado() {
		return clicado;
	}

	public void setClicado(boolean clicado) {
		this.clicado = clicado;
	}
}

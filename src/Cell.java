import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	
	public Cell() {
		this.vizinhos = new ArrayList();
		numMinasVizinhas = qtdMinasVizinhas();
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

	private void botaoEsquerdoPressionado() {
		if (this.revelado) {
			return;
		} else {
			if(this.minado) {
				System.out.println("ta minado");
				this.minado = true;
				revelar();				
				// implementar fim de jogo aqui
			} else {
				System.out.println("nao ta minado");
				numMinasVizinhas = qtdMinasVizinhas();	
				System.out.println(numMinasVizinhas);
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
		// checar os vizinhos cuja quantidade de minas vizinha é 0, se for, chamar função revelar
		
//		this.numMinasVizinhas = numMinasVizinhas(1, 2);
		
		if (numMinasVizinhas == 0) {
			Icon zeroIcon = new ImageIcon("C:\\editicon.PNG");
			// revelar o restante que é 0
		} else if (numMinasVizinhas == 1) {
			// botar jpg de 1 aqui
		}
	}
	
	public void adicionarVizinhos(Cell vizinho){
        this.vizinhos.add(vizinho);
    }
	
	public int qtdMinasVizinhas() {
		for(int i = 0; i < vizinhos.size(); i++) {
			if(vizinhos.get(i).minado) {
				numMinasVizinhas++;
			}
		}
		return numMinasVizinhas;
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
	
	public int getNumMinasVizinhas() {
		return numMinasVizinhas;
	}

	public void setNumMinasVizinhas(int numMinasVizinhas) {
		this.numMinasVizinhas = numMinasVizinhas;
	}

}

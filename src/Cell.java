import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
		
		try {
		    Image img = ImageIO.read(getClass().getResource("./Assets/facingDown.png"));
		    img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		    this.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		    System.out.println(ex);
		}
		
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
				// implementar fim de jogo aqui
			} else {
				System.out.println("nao ta minado");
				numMinasVizinhas = qtdMinasVizinhas();	
				System.out.println(numMinasVizinhas);
			}
			revelar();
		}
		
	}
	
	private void botaoDireitoPressionado() {
		if (this.revelado) {
			return;
		} else {
			if (!this.marcado) {
				adicionarImagem("./Assets/flagged.png");
				System.out.println("botar flag");	
				this.marcado = true;
			} else {
				adicionarImagem("./Assets/facingDown.png");
				System.out.println("tirar flag");	
				this.marcado = false;
			}
		}
	}
	
	public void revelar() {
		this.revelado = true;
		
		if(this.minado) {
			adicionarImagem("./Assets/bomb.png");
		} else {
			switch(numMinasVizinhas) {
			  case 0:
				adicionarImagem("./Assets/0.png");
				System.out.println("chegou aqui");
//				for(int i = 0; i < vizinhos.size(); i++) {
//					if (vizinhos.get(i).numMinasVizinhas == 0 && vizinhos.get(i).revelado == false 
//							&& vizinhos.get(i).minado == false) {
//						vizinhos.get(i).revelar();
//					}
//				}
			    break;
			  case 1:
				adicionarImagem("./Assets/1.png");
			    break;
			  case 2:
				adicionarImagem("./Assets/2.png");
			    break;
			  case 3:
				adicionarImagem("./Assets/3.png");
			    break;
			  case 4:
				adicionarImagem("./Assets/4.png");
			    break;
			  case 5:
				adicionarImagem("./Assets/5.png");
			    break;
			  case 6:
				adicionarImagem("./Assets/6.png");
			    break;
			  case 7:
				adicionarImagem("./Assets/7.png");
			    break;
			  case 8:
				adicionarImagem("./Assets/8.png");
			    break;
			  default:
			    // code block
			}
		}
	}
	
	public void adicionarImagem(String caminho) {
		try {
		    Image img = ImageIO.read(getClass().getResource(caminho));
		    img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		    this.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
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

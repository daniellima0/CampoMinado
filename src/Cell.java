import javax.swing.JButton;

public class Cell extends JButton {
	private boolean minado;
	private boolean revelado;
	private boolean marcado;
	private boolean clicado;
	
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
	}
	
	public boolean minar(){
		if(!this.minado){
			this.minado = true;
			return true;
		}else{
			return false;
		}
	}
	
//	public int vizinhosComBomba() {
//		// metodo que vai dizer quantas bombas tem ao redor do botão
//	}
}

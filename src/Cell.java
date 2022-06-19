import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Cell extends JButton {
	private boolean isMined;
	private boolean isRevealed;
	private boolean isFlagged;
	private int numOfMinesAround;
	ArrayList<Cell> neighbors;
	
	
	public Cell() {
		this.neighbors = new ArrayList();
		numOfMinesAround = getNumOFMinesAround();
		isMined = false;
		isRevealed = false;
		isFlagged = false;
		
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
	        		 leftButtonPressed();
	        	 } else if (SwingUtilities.isRightMouseButton(e)) {
	        		 rightButtonPressed();
	             };
	         }
	     });
	}
	
	public boolean mine(){
		if(!this.isMined){
			this.isMined = true;
			return true;
		}else{
			return false;
		}
	}

	private void leftButtonPressed() {
		if (this.isRevealed) {
			return;
		} else {
			if(this.isMined) {
				System.out.println("is mined");
				this.isMined = true;
				// implementar fim de jogo aqui
			} else {
				System.out.println("is not mined");
				numOfMinesAround = getNumOFMinesAround();	
				System.out.println(numOfMinesAround);
			}
			reveal();
		}
		
	}
	
	private void rightButtonPressed() {
		if (this.isRevealed) {
			return;
		} else {
			if (!this.isFlagged) {
				addImage("./Assets/flagged.png");
				System.out.println("put flag");	
				this.isFlagged = true;
			} else {
				addImage("./Assets/facingDown.png");
				System.out.println("remove flag");	
				this.isFlagged = false;
			}
		}
	}
	
	public void reveal() {
		this.isRevealed = true;
		
		if(this.isMined) {
			addImage("./Assets/bomb.png");
			new Menu();
		} else {
			switch(numOfMinesAround) {
			  case 0:
				addImage("./Assets/0.png");
				System.out.println("it got here");
			    break;
			  case 1:
				addImage("./Assets/1.png");
			    break;
			  case 2:
				addImage("./Assets/2.png");
			    break;
			  case 3:
				addImage("./Assets/3.png");
			    break;
			  case 4:
				addImage("./Assets/4.png");
			    break;
			  case 5:
				addImage("./Assets/5.png");
			    break;
			  case 6:
				addImage("./Assets/6.png");
			    break;
			  case 7:
				addImage("./Assets/7.png");
			    break;
			  case 8:
				addImage("./Assets/8.png");
			    break;
			  default:
			    // code block
			}
		}
	}
	
	public void addImage(String caminho) {
		try {
		    Image img = ImageIO.read(getClass().getResource(caminho));
		    img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		    this.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
	}
	
	public void addNeighbor(Cell neighbor){
        this.neighbors.add(neighbor);
    }
	
	public int getNumOFMinesAround() {
		for(int i = 0; i < neighbors.size(); i++) {
			if(neighbors.get(i).isMined) {
				numOfMinesAround++;
			}
		}
		return numOfMinesAround;
	}

	// Getters and setters
	public boolean isMined() {
		return isMined;
	}

	public void setMined(boolean isMined) {
		this.isMined = isMined;
	}

	public boolean isRevealed() {
		return isRevealed;
	}

	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public int getNumOfMinesAround() {
		return numOfMinesAround;
	}

	public void setNumOfMinesAround(int numOfMinesAround) {
		this.numOfMinesAround = numOfMinesAround;
	}

	public ArrayList<Cell> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Cell> neighbors) {
		this.neighbors = neighbors;
	}
}

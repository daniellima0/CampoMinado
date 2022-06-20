import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Cell extends JButton {
	private boolean isMined;
	private boolean isRevealed;
	private boolean isFlagged;
	private int numOfMinesAround;
	ArrayList<Cell> neighbors;
	private Handler handler; // understand why the code needs this (1)
	
	public Cell(Handler handler) {
		this.handler = handler;
		neighbors = new ArrayList();
		isMined = false;
		isRevealed = false;
		isFlagged = false;
		
		try {
		    Image img = ImageIO.read(getClass().getResource("./Assets/facingDown.png"));
		    img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		    setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		    System.out.println(ex);
		}
		
		// Action Listener for mouse left click
		addActionListener((ActionEvent evt) -> {
			clickButton();
		});
		
		// Mouse Listener for mouse right click
		addMouseListener(new MouseListener() {
		       @Override
		       public void mouseClicked(MouseEvent e) {
		           if(SwingUtilities.isRightMouseButton(e)) {
		        	   rightClickButton();
		           }
		       }
		
		       public void mouseEntered(MouseEvent e) {}
		       public void mouseExited(MouseEvent e) {}
		       public void mousePressed(MouseEvent e) {}
		       public void mouseReleased(MouseEvent e) {}
		});
	}
	
	// understand why the code needs this (2)
	public void clickButton() {
		handler.click(this);
	}
	
	// understand why the code needs this (3)
	public void rightClickButton() {
		handler.rightClick(this);
	}
	
	public boolean mine(){
		if(!isMined){
			isMined = true;
			return true;
		}else{
			return false;
		}
	}
	
	public void reveal() {
		isRevealed = true;
		
		if(isMined) {
			addImage("./Assets/bomb.png");
		} else {
			switch(numOfMinesAround) {
			  case 0:
				addImage("./Assets/0.png");
				revealBlankSpacesAround();
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
	
	public void revealBlankSpacesAround() {
		for (int i = 0; i < neighbors.size(); i++) {
			if (!neighbors.get(i).isMined && !neighbors.get(i).isRevealed) {
				neighbors.get(i).clickButton();
			}
		}
	}
	
	public void addImage(String caminho) {
		try {
		    Image img = ImageIO.read(getClass().getResource(caminho));
		    img = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		    setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
			  System.out.println(ex);
		  }
	}
	
	public void addNeighbor(Cell neighbor){
        neighbors.add(neighbor);
    }

	// Getters and setters      --review which ones are not used and delete them
	public boolean isMined() {
		return isMined;
	}

	public void setMined(boolean isMined) {
		isMined = isMined;
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

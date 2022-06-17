import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Menu {
	private int numCliquesReset;
	
	public Menu() {
		JFrame menuFrame = new JFrame();
		menuFrame.setTitle("GameOver");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setPreferredSize(new Dimension(360,350));
		menuFrame.setResizable(false);
		
		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.setBorder(BorderFactory.createLineBorder(Color.black));
		window.setBackground(Color.WHITE);
		
		JLabel gameOverLabel = new JLabel("   Game Over", SwingConstants.CENTER);
		gameOverLabel.setFont(new Font("Sans Serif", Font.PLAIN, 50));
		gameOverLabel.setForeground(Color.BLUE);
		
		JButton reset = new JButton("Jogar Novamente");
		JPanel espacoEmBranco = new JPanel();
		espacoEmBranco.setBackground(Color.white);
		espacoEmBranco.setMaximumSize(new Dimension(80,80));
		JButton sair = new JButton("Sair");
		
		reset.addMouseListener(new java.awt.event.MouseAdapter() {
	         public void mousePressed(MouseEvent e) {
	        	 if (SwingUtilities.isLeftMouseButton(e)) {
	        		 numCliquesReset++;
	        		 if (numCliquesReset == 1) { 
	        			 new GameScreen();	        			 
	        			 reset.setEnabled(false);
	        			 sair.setEnabled(false);
	        		 }
	        	 }
	         }
	     });
		
		sair.addMouseListener(new java.awt.event.MouseAdapter() {
	         public void mousePressed(MouseEvent e) {
	        	 if (SwingUtilities.isLeftMouseButton(e)) {
	        		 menuFrame.dispatchEvent(new WindowEvent(menuFrame, WindowEvent.WINDOW_CLOSING));
	        	 }
	         }
	     });
		
		window.add(gameOverLabel);
		window.add(espacoEmBranco);
		window.add(reset);
		window.add(espacoEmBranco);
		window.add(sair);
		
		menuFrame.add(window);
		menuFrame.pack();
		menuFrame.setVisible(true);
	}
}

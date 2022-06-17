import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen {
	public JFrame GameScreenFrame;
	public GameScreen() {
		GameScreenFrame = new JFrame();
		GameScreenFrame.setTitle("Campo Minado");
		GameScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreenFrame.setPreferredSize(new Dimension(500,600));
		GameScreenFrame.setResizable(false);

		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.setBorder(BorderFactory.createLineBorder(Color.black));
		window.setBackground(Color.WHITE);
		
		JPanel topbar = new JPanel();
		topbar.setMaximumSize(new Dimension(420, 70));
		topbar.setBackground(Color.WHITE);
		
		JLabel temp = new JLabel(" CAMPO MINADO");
		temp.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		temp.setForeground(Color.BLUE);
		topbar.add(temp);
		
		Grid grid = new Grid();

		window.add(topbar);
		window.add(grid);
		
		GameScreenFrame.add(window);
		GameScreenFrame.pack(); //nao sei o que eh mas se tirar n funciona
		GameScreenFrame.setVisible(true);
	}
	
	
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JFrame{
	public GameScreen() {
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,600));
		setResizable(false);

		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.setBorder(BorderFactory.createLineBorder(Color.black));
		window.setBackground(Color.WHITE);
		
		JPanel topbar = new JPanel();
		topbar.setMaximumSize(new Dimension(420, 70));
		topbar.setBackground(Color.WHITE);
		
		JLabel temp = new JLabel(" Minesweeper");
		temp.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		temp.setForeground(Color.BLUE);
		topbar.add(temp);
		
		Grid grid = new Grid();

		window.add(topbar);
		window.add(grid);
		
		add(window);
		pack();
		setVisible(true);
	}
	
	
}

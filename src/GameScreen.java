import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JFrame{
	private JPanel window;
	private JPanel topBar;
	private JLabel title;
	
	
	public GameScreen() {
		// Setting appearance of GameScreen JFrame
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,600));
		setResizable(false);

		// Setting appearance of window JPanel
		window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.setBorder(BorderFactory.createLineBorder(Color.black));
		window.setBackground(Color.WHITE);
		
		// Setting appearance of topBar JPanel
		topBar = new JPanel();
		topBar.setMaximumSize(new Dimension(420, 70));
		topBar.setBackground(Color.WHITE);
		
		// Setting appearance of title JLabel
		title = new JLabel(" Minesweeper");
		title.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		title.setForeground(Color.BLUE);

		// Building screen structure and setting the JFrame visible
		topBar.add(title);
		window.add(topBar);
		
		Grid grid = new Grid();
		window.add(grid);
		add(window);
		pack();
		setVisible(true);
	}
	
	
}

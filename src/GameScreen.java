import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameScreen extends JFrame{
	private JPanel window;
	private JPanel topBar;
	private JButton reset;
	
	public GameScreen() {
		// Setting appearance of GameScreen JFrame
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 600));
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
		
		// Creating grid object
		Grid grid = new Grid();

		// Creating reset JButton
		reset = new JButton("Restart");
		reset.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		reset.addActionListener((ActionEvent e) -> {
	        grid.resetGame();
		});

		// Building screen structure and setting the JFrame visible
		topBar.add(reset);
		window.add(topBar);
		window.add(grid);
		add(window);
		pack();
		setLocationRelativeTo(null); // centers the screen if called after the pack method
		setVisible(true);
	}
	
	
}

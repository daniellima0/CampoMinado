import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class GameScreen extends JFrame{
	private JPanel window;
	private JPanel topBar;
	private JPopupMenu level;
	private JButton reset;
	
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
		
		// Creating level JComboBox
		String[] levels = {"Easy", "Medium", "Hard"};
		JComboBox level = new JComboBox(levels);
		level.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		level.setSelectedIndex(0);
		level.addActionListener((ActionEvent e) -> {
			JComboBox cb = (JComboBox)e.getSource();
	        String levelChosed = (String)cb.getSelectedItem();
	        System.out.println(levelChosed);
		});
		
		// Creating grid object
		Grid grid = new Grid();

		// Creating reset JButton
		reset = new JButton("Reset");
		reset.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		reset.addActionListener((ActionEvent e) -> {
	        System.out.println("reset");
	        grid.resetGame();
		});

		// Building screen structure and setting the JFrame visible
		topBar.add(level);
		topBar.add(reset);
		window.add(topBar);
		
		window.add(grid);
		add(window);
		pack();
		setLocationRelativeTo(null); // centers the screen if called after the pack method
		setVisible(true);
	}
	
	
}

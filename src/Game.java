import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	public Game() {
		JFrame frame = new JFrame();
		frame.setTitle("Campo Minado");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500,500));
//		frame.setMaximumSize(new Dimension(500, 500));
		frame.setResizable(false);

		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.setBorder(BorderFactory.createLineBorder(Color.black));
//		window.setMaximumSize(new Dimension(500, 500));
		
		JPanel topbar = new JPanel();
		topbar.setBackground(Color.pink);
		topbar.setMaximumSize(new Dimension(500, 50));
		
		JLabel temp = new JLabel("dificuldade, tempo, número de bandeiras vem aqui");		
		topbar.add(temp);

		JPanel buttons = new JPanel();
		buttons.setMaximumSize(new Dimension(500, 400));
		buttons.setLayout(new GridLayout(14,14));
		for(int i = 0; i < 196; i++) {
			Button button = new Button();	
			buttons.add(button);		
		}
		
		window.add(topbar);
		window.add(buttons);
		
		frame.add(window);
		frame.pack();
		frame.setVisible(true);
	}
}

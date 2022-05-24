import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	public GUI() {
		JButton button = new JButton();

		JLabel label = new JLabel("Aperte se Claudino é");

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(180, 230, 180, 230));
		panel.setLayout(new GridLayout(5,5));
		panel.add(button);
		panel.add(label);

		JFrame frame = new JFrame();
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Campo Minado");
		frame.pack();
		frame.setVisible(true);
	}
}

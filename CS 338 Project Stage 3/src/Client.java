import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class Client {
	public static void main (String[] args) {
		JFrame frame = new JFrame("Main Menu");
		frame.setResizable(false);
		TitleScreen app = new TitleScreen();
		Component contents = app.makeTitleButtons();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
}

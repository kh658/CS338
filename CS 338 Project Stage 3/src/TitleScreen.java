/*
*Kevin Han
*kh658@drexel.edu
*CS338:GUI, Project Stage 3
*Infiltration
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen {

	int playerOneScore = 0;
	int playerTwoScore = 0;
	int turnNumber = 1;									//Turn number in current game
	int lastWon = 1;									//Keeps track of who last won
	String currentTurn = "Player 1";					//Keeps track of whose turn it is
	int currentPlayer = 1;
	int state[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	

	public JPanel makeTitleButtons() {

		JFrame ttt = new JFrame("Tic-Tac-Toe");
		ttt.setResizable(false);
		tictactoe tGame = new tictactoe();
		Component tContents = tGame.createGameBoard();
		ttt.getContentPane().add(tContents, BorderLayout.CENTER);
		ttt.pack();
		ttt.setVisible(false);
		
		JFrame infiltration = new JFrame("Infiltration");
		infiltration.setResizable(false);
		infiltration iGame = new infiltration();
		Component iContents = iGame.createGameBoard();
		infiltration.getContentPane().add(iContents, BorderLayout.CENTER);
		infiltration.pack();
		infiltration.setVisible(false);
		
		JLabel background = new JLabel(new ImageIcon("./resources/background.png"));
		background.setLayout(new BorderLayout());
		
	    JPanel titleScreen = new JPanel(new BorderLayout());
	    titleScreen.setPreferredSize(new Dimension(800,700));
	    
	    JPanel titleButtons = new JPanel();
	    titleButtons.setLayout(new BoxLayout(titleButtons, BoxLayout.Y_AXIS));
	    titleButtons.setPreferredSize(new Dimension(800,700));
	    titleButtons.setOpaque(false);
	    
	    for (int k = 0; k < 10; k++) {
	    	titleButtons.add(Box.createVerticalGlue());
	    }
	    
	    JButton tttButton = new JButton("Player Vs. Player (Tic-Tac-Toe)");
	    tttButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    tttButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				ttt.setVisible(true);
			}
		});
	    titleButtons.add(tttButton);
	    titleButtons.add(Box.createVerticalGlue());
	    
	    JButton infButton = new JButton("Player Vs. Player (Infiltration)");
	    infButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    infButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				infiltration.setVisible(true);
			}
		});
	    titleButtons.add(infButton);
	    titleButtons.add(Box.createVerticalGlue());
	    
	    JLabel about = new JLabel("About the Game");
	    about.setToolTipText("<html>Play classic Tic-Tac-Toe with your friends! Loser goes first in the next round.<br> Or try out Infiltration! A version of Tic-Tac-Toe that lets you predict your opponents next move.<br>If you're right, you block their move! Bluff your way through, and win the game by controlling three rooms in a row!</html>");
	    about.setAlignmentX(Component.CENTER_ALIGNMENT);
	    about.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    about.setForeground(Color.white);
	    
	    JButton quitButton = new JButton("Quit Game");
	    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    quitButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    titleButtons.add(quitButton);
	    titleButtons.add(Box.createVerticalGlue());
	    
	    titleButtons.add(about);
	    titleButtons.add(Box.createVerticalGlue());
	    
	    for (int k = 0; k < 12; k++) {
	    	titleButtons.add(Box.createVerticalGlue());
	    }
	    
	   
	    
	    background.add(titleButtons);
	    titleScreen.add(background, BorderLayout.CENTER);
	    
	    return titleScreen;
	  }
	

	
}

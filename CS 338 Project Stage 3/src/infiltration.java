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

public class infiltration extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	int gameInProgress = 0;
	int playerOneScore = 0;
	int playerTwoScore = 0;
	int turnNumber = 1;									//Turn number in current game
	int lastWon = 1;									//Keeps track of who last won
	int hasWon = 0;										//Indicates if someone has won the current match
	String currentTurn = "Blue Spy";					//Keeps track of whose turn it is
	String currentPredictor = "Red Spy";
	String phase = "Prediction Phase";					//Keep track of phase
	int prediction = 9;
	int currentPlayer = 1;
	int state[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	JLabel score = new JLabel("			Blue Spy Score: " + playerOneScore + "     Red Spy Score: " + playerTwoScore);
	JLabel turn = new JLabel(currentTurn + "'s " + phase);
	JLabel turnTracker = new JLabel("Turn " + String.valueOf(turnNumber));
	
	JButton roomA = new JButton("Room A");						//Create buttons
	JButton roomB = new JButton("Room B");
	JButton roomC = new JButton("Room C");
	JButton roomD = new JButton("Room D");
	JButton roomE = new JButton("Room E");
	JButton roomF = new JButton("Room F");
	JButton roomG = new JButton("Room G");
	JButton roomH = new JButton("Room H");
	JButton roomI = new JButton("Room I");
	
	public JPanel createGameBoard() {
		JPanel board = new JPanel(new BorderLayout());
		board.setPreferredSize(new Dimension(800,700));
		
		JPanel grid = new JPanel(new GridLayout(3,3));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		JPanel phasePanel = new JPanel();
		phasePanel.setLayout(new BoxLayout(phasePanel, BoxLayout.X_AXIS));
		phasePanel.add(Box.createHorizontalGlue());
		phasePanel.add(turn);
		phasePanel.add(Box.createHorizontalGlue());
		
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
		
		score.setFont(new Font("Monospaced", Font.PLAIN, 16));
		turn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		turnTracker.setFont(new Font("Monospaced", Font.PLAIN, 16));
		info.add(Box.createHorizontalGlue());
		info.add(score);
		info.add(Box.createHorizontalGlue());
		info.add(turnTracker);
		info.add(Box.createHorizontalGlue());
		
		JPanel menuButtons = new JPanel();										//Create left hand menu 
		menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.Y_AXIS));
		menuButtons.add(Box.createVerticalGlue());
		JButton startGame = new JButton("Start Game");
		startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		startGame.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if (gameInProgress == 0) {
					gameInProgress = 1;
					startGame();
				}
			}
		});
		JButton resetBoard = new JButton("Reset Board");
		resetBoard.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetBoard.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				resetTTTBoard();
			}
		});
		JButton resetGame = new JButton("Reset Game");
		resetGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetGame.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		menuButtons.add(startGame);
		menuButtons.add(Box.createVerticalGlue());
		menuButtons.add(resetBoard);
		menuButtons.add(Box.createVerticalGlue());
		menuButtons.add(resetGame);
		for (int k = 0; k < 20; k++) {
	    	menuButtons.add(Box.createVerticalGlue());
	    }
		
		disableButtons();
		roomA.setFocusable(false);
		roomB.setFocusable(false);
		roomC.setFocusable(false);
		roomD.setFocusable(false);
		roomE.setFocusable(false);
		roomF.setFocusable(false);
		roomG.setFocusable(false);
		roomH.setFocusable(false);
		roomI.setFocusable(false);
								
		roomA.addActionListener(new ActionListener() {			//Click action for A
			public void actionPerformed(ActionEvent e) {
				state[0] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 0;
				}
				else {
					try {
						if (prediction != 0) {
							if (currentPlayer == 1) {
								roomA.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomA.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomA.setIcon(new ImageIcon("./resources/redToken.png"));
								roomA.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomA.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomB.addActionListener(new ActionListener() {			//Click action for B
			public void actionPerformed(ActionEvent e) {
				state[1] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 1;
				}
				else {
					try {
						if (prediction != 1) {
							if (currentPlayer == 1) {
								roomB.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomB.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomB.setIcon(new ImageIcon("./resources/redToken.png"));
								roomB.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomB.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomC.addActionListener(new ActionListener() {			//Click action for C
			public void actionPerformed(ActionEvent e) {
				state[2] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 2;
				}
				else {
					try {
						if (prediction != 2) {
							if (currentPlayer == 1) {
								roomC.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomC.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomC.setIcon(new ImageIcon("./resources/redToken.png"));
								roomC.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomC.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomD.addActionListener(new ActionListener() {			//Click action for D
			public void actionPerformed(ActionEvent e) {
				state[3] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 3;
				}
				else {
					try {
						if (prediction != 3) {
							if (currentPlayer == 1) {
								roomD.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomD.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomD.setIcon(new ImageIcon("./resources/redToken.png"));
								roomD.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomD.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomE.addActionListener(new ActionListener() {			//Click action for E
			public void actionPerformed(ActionEvent e) {
				state[4] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 4;
				}
				else {
					try {
						if (prediction != 4) {
							if (currentPlayer == 1) {
								roomE.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomE.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomE.setIcon(new ImageIcon("./resources/redToken.png"));
								roomE.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomE.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomF.addActionListener(new ActionListener() {			//Click action for F
			public void actionPerformed(ActionEvent e) {
				state[5] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 5;
				}
				else {
					try {
						if (prediction != 5) {
							if (currentPlayer == 1) {
								roomF.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomF.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomF.setIcon(new ImageIcon("./resources/redToken.png"));
								roomF.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomF.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomG.addActionListener(new ActionListener() {			//Click action for G
			public void actionPerformed(ActionEvent e) {
				state[6] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 6;
				}
				else {
					try {
						if (prediction != 6) {
							if (currentPlayer == 1) {
								roomG.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomG.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomG.setIcon(new ImageIcon("./resources/redToken.png"));
								roomG.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomG.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomH.addActionListener(new ActionListener() {			//Click action for H
			public void actionPerformed(ActionEvent e) {
				state[7] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 7;
				}
				else {
					try {
						if (prediction != 7) {
							if (currentPlayer == 1) {
								roomH.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomH.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomH.setIcon(new ImageIcon("./resources/redToken.png"));
								roomH.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomH.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		roomI.addActionListener(new ActionListener() {			//Click action for I
			public void actionPerformed(ActionEvent e) {
				state[8] = currentPlayer;
				if (phase == "Prediction Phase") {
					prediction = 8;
				}
				else {
					try {
						if (prediction != 8) {
							if (currentPlayer == 1) {
								roomI.setIcon(new ImageIcon("./resources/blueToken.png"));
								roomI.setDisabledIcon(new ImageIcon("./resources/blueToken.png"));
							}
							else if (currentPlayer == 2) {
								roomI.setIcon(new ImageIcon("./resources/redToken.png"));
								roomI.setDisabledIcon(new ImageIcon("./resources/redToken.png"));
							}
							roomI.setEnabled(false);
							playerWin();
						}
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
				}
				advanceGame();
			}
		});
		
		grid.add(roomA);										//Add buttons to game
		grid.add(roomB);
		grid.add(roomC);
		grid.add(roomD);
		grid.add(roomE);
		grid.add(roomF);
		grid.add(roomG);
		grid.add(roomH);
		grid.add(roomI);
		
		infoPanel.add(info);
		infoPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		infoPanel.add(phasePanel);
		
		board.add(infoPanel, BorderLayout.NORTH);
		board.add(grid, BorderLayout.CENTER);
		board.add(menuButtons, BorderLayout.WEST);
		return board;
	}
	
	public void advanceGame() {
		if (phase == "Prediction Phase") {
			phase = "Spy Placement Phase";
		}
		else {
			phase = "Prediction Phase";
		}
		
		if (currentPlayer == 1 && phase == "Spy Placement Phase") {
			currentPlayer = 2;
			currentTurn = "Red Spy";
			currentPredictor = "Blue Spy";
			turnNumber++;
		}
		else if (currentPlayer == 2 && phase == "Spy Placement Phase") {
			currentPlayer = 1;
			currentTurn = "Blue Spy";
			currentPredictor = "Red Spy";
			turnNumber++;
		}
		score.setText("			Blue Spy Score: " + playerOneScore + "     Red Spy Score: " + playerTwoScore);
		turn.setText(currentTurn + "'s " + phase);
		turnTracker.setText("Turn " + String.valueOf(turnNumber));
	}
	
	public void startGame() {
		enableButtons();
	}
	
	public void enableButtons() {
		roomA.setEnabled(true);
		roomB.setEnabled(true);
		roomC.setEnabled(true);
		roomD.setEnabled(true);
		roomE.setEnabled(true);
		roomF.setEnabled(true);
		roomG.setEnabled(true);
		roomH.setEnabled(true);
		roomI.setEnabled(true);
	}
	
	public void disableButtons() {
		roomA.setEnabled(false);
		roomB.setEnabled(false);
		roomC.setEnabled(false);
		roomD.setEnabled(false);
		roomE.setEnabled(false);
		roomF.setEnabled(false);
		roomG.setEnabled(false);
		roomH.setEnabled(false);
		roomI.setEnabled(false);
	}
	
	public void resetTTTBoard() {
		disableButtons();
		
		gameInProgress = 0;
		
		roomA.setIcon(null);
		roomB.setIcon(null);
		roomC.setIcon(null);
		roomD.setIcon(null);
		roomE.setIcon(null);
		roomF.setIcon(null);
		roomG.setIcon(null);
		roomH.setIcon(null);
		roomI.setIcon(null);
		
		for (int k = 0; k < 9; k++) {
			state[k] = 0;
		}
		
		hasWon = 0;										//Indicates if someone has won the current match
		if (lastWon == 1) {
			currentTurn = "Red Spy";					//Keeps track of whose turn it is
			currentPlayer = 2;
			currentPredictor = "Blue Spy";
		}
		else {
			currentTurn = "Blue Spy";
			currentPlayer = 1;
			currentPredictor = "Red Spy";
		}		
		turnNumber = 1;									//Turn number in current game
		lastWon = 0;									//Keeps track of who last won
		prediction = 9;
		phase = "Prediction Phase";
		turn.setText(currentTurn + "'s " + phase);
		turnTracker.setText("Turn " + String.valueOf(turnNumber));
		
	}
	
	public void resetGame() {
		resetTTTBoard();
		disableButtons();
		gameInProgress = 0;
		playerOneScore = 0;
		playerTwoScore = 0;
		currentTurn = "Blue Spy";
		currentPredictor = "Red Spy";
		phase = "Prediction Phase";					//Keep track of phase
		currentPlayer = 1;
		score.setText("			Blue Spy Score: " + playerOneScore + "     Red Spy Score: " + playerTwoScore);
	}
	
public void playerWin() {
		
		if (hasWon == 0) {
			if (state[0] == 1 && state[1] == 1 && state[2] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[3] == 1 && state[4] == 1 && state[5] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[6] == 1 && state[7] == 1 && state[8] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[0] == 1 && state[3] == 1 && state[6] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[1] == 1 && state[4] == 1 && state[7] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[2] == 1 && state[5] == 1 && state[8] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[0] == 1 && state[4] == 1 && state[8] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
			if (state[2] == 1 && state[4] == 1 && state[6] == 1) {
				playerOneScore++;
				hasWon = 1;
				lastWon = 1;
			}
	
			
			if (state[0] == 2 && state[1] == 2 && state[2] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[3] == 2 && state[4] == 2 && state[5] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[6] == 2 && state[7] == 2 && state[8] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[0] == 2 && state[3] == 2 && state[6] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[1] == 2 && state[4] == 2 && state[7] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[2] == 2 && state[5] == 2 && state[8] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[0] == 2 && state[4] == 2 && state[8] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
			if (state[2] == 2 && state[4] == 2 && state[6] == 2) {
				playerTwoScore++;
				hasWon = 1;
				lastWon = 2;
			}
		}
	}
	

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

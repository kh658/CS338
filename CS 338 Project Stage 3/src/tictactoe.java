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

public class tictactoe extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	int gameInProgress = 0;
	int playerOneScore = 0;
	int playerTwoScore = 0;
	int turnNumber = 1;									//Turn number in current game
	int lastWon = 1;									//Keeps track of who last won
	int hasWon = 0;										//Indicates if someone has won the current match
	String currentTurn = "Player 1";					//Keeps track of whose turn it is
	int currentPlayer = 1;
	int state[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	ImageIcon playerOneToken = new ImageIcon("./resources/x.png");
	ImageIcon playerTwoToken = new ImageIcon("./resources/o.png");
	
	JLabel score = new JLabel("			Player 1 Score: " + playerOneScore + "     Player 2 Score: " + playerTwoScore);
	JLabel turn = new JLabel(currentTurn + "'s Turn");
	JLabel turnTracker = new JLabel("Turn " + String.valueOf(turnNumber));
	
	JButton roomA = new JButton("");						//Create buttons
	JButton roomB = new JButton("");
	JButton roomC = new JButton("");
	JButton roomD = new JButton("");
	JButton roomE = new JButton("");
	JButton roomF = new JButton("");
	JButton roomG = new JButton("");
	JButton roomH = new JButton("");
	JButton roomI = new JButton("");
	
	public JPanel createGameBoard() {
		JPanel board = new JPanel(new BorderLayout());
		board.setPreferredSize(new Dimension(800,700));
		
		JPanel grid = new JPanel(new GridLayout(3,3));
		
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
		
		score.setFont(new Font("Calibri", Font.PLAIN, 16));
		turn.setFont(new Font("Calibri", Font.PLAIN, 16));
		turnTracker.setFont(new Font("Calibri", Font.PLAIN, 16));
		info.add(Box.createHorizontalGlue());
		info.add(score);
		info.add(Box.createHorizontalGlue());
		info.add(turn);
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
				try {
					if (currentPlayer == 1) {
						roomA.setIcon(playerOneToken);
						roomA.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomA.setIcon(playerTwoToken);
						roomA.setDisabledIcon(playerTwoToken);
					}
					roomA.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomB.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[1] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomB.setIcon(playerOneToken);
						roomB.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomB.setIcon(playerTwoToken);
						roomB.setDisabledIcon(playerTwoToken);
					}
					roomB.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomC.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[2] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomC.setIcon(playerOneToken);
						roomC.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomC.setIcon(playerTwoToken);
						roomC.setDisabledIcon(playerTwoToken);
					}
					roomC.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomD.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[3] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomD.setIcon(playerOneToken);
						roomD.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomD.setIcon(playerTwoToken);
						roomD.setDisabledIcon(playerTwoToken);
					}
					roomD.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		
		roomE.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[4] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomE.setIcon(playerOneToken);
						roomE.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomE.setIcon(playerTwoToken);
						roomE.setDisabledIcon(playerTwoToken);
					}
					roomE.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomF.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[5] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomF.setIcon(playerOneToken);
						roomF.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomF.setIcon(playerTwoToken);
						roomF.setDisabledIcon(playerTwoToken);
					}
					roomF.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomG.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[6] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomG.setIcon(playerOneToken);
						roomG.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomG.setIcon(playerTwoToken);
						roomG.setDisabledIcon(playerTwoToken);
					}
					roomG.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomH.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[7] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomH.setIcon(playerOneToken);
						roomH.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomH.setIcon(playerTwoToken);
						roomH.setDisabledIcon(playerTwoToken);
					}
					roomH.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
			}
		});
		
		roomI.addActionListener(new ActionListener() {			//Click action for 
			public void actionPerformed(ActionEvent e) {
				state[8] = currentPlayer;
				try {
					if (currentPlayer == 1) {
						roomI.setIcon(playerOneToken);
						roomI.setDisabledIcon(playerOneToken);
					}
					else if (currentPlayer == 2) {
						roomI.setIcon(playerTwoToken);
						roomI.setDisabledIcon(playerTwoToken);
					}
					roomI.setEnabled(false);
					playerWin();
					advanceGame();
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
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
		
		board.add(info, BorderLayout.NORTH);
		board.add(grid, BorderLayout.CENTER);
		board.add(menuButtons, BorderLayout.WEST);
		return board;
	}
	
	public void advanceGame() {
		if (currentPlayer == 1) {
			currentPlayer = 2;
			currentTurn = "Player 2";
			turnNumber++;
		}
		else {
			currentPlayer = 1;
			currentTurn = "Player 1";
			turnNumber++;
		}
		score.setText("			Player 1 Score: " + playerOneScore + "     Player 2 Score: " + playerTwoScore);
		turn.setText(currentTurn + "'s Turn");
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
			currentTurn = "Player 2";					//Keeps track of whose turn it is
			currentPlayer = 2;
			playerOneToken = new ImageIcon("./resources/o.png");
			playerTwoToken = new ImageIcon("./resources/x.png");
		}
		else {
			currentTurn = "Player 1";
			currentPlayer = 1;
			playerOneToken = new ImageIcon("./resources/x.png");
			playerTwoToken = new ImageIcon("./resources/o.png");
		}		
		turnNumber = 1;									//Turn number in current game
		lastWon = 0;									//Keeps track of who last won
		
		turn.setText(currentTurn + "'s Turn");
		turnTracker.setText("Turn " + String.valueOf(turnNumber));
		
	}
	
	public void resetGame() {
		resetTTTBoard();
		disableButtons();
		gameInProgress = 0;
		playerOneScore = 0;
		playerTwoScore = 0;
		currentTurn = "Player 1";
		currentPlayer = 1;
		score.setText("			Player 1 Score: " + playerOneScore + "     Player 2 Score: " + playerTwoScore);
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

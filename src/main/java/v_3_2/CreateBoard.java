package v_3_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class CreateBoard {

	MiniMaxAlgorithm mma = new MiniMaxAlgorithm();
	CheckWinConditions cwc = new CheckWinConditions();

	//Legend
	//int rows - number of rows of the grid
	//int cols - number of columns of the grid
	//int size - size of the "X" and "O" variant

	public void createBoard(TicTacToe ttc, int rows, int cols, int size) {


		ttc.boardPanel.setLayout(new GridLayout(rows, cols));
		ttc.boardPanel.setBackground(Color.DARK_GRAY);
		ttc.mainJPanel.add(ttc.boardPanel);


		//create board
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				JButton tile = new JButton();
				ttc.chosenBoard[r][c] = tile;
				ttc.boardPanel.add(tile);


				tile.setBackground(Color.DARK_GRAY);
				tile.setForeground(Color.WHITE);
				tile.setFont(new Font("Time New Roman", Font.BOLD, size));
				tile.setFocusable(false);


				//ActionListener to allow interaction with "tiles"
				tile.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (ttc.gameOver) return;
						JButton tile = (JButton) e.getSource();
						if (tile.getText().equals("")) {
							tile.setText(ttc.currentPlayer);
							ttc.turns++;
							cwc.checkWinner(ttc);
							if (!ttc.gameOver) {
								//Ternary operation to rotate between players
								ttc.currentPlayer = ttc.currentPlayer == TicTacToe.PLAYER_X ? TicTacToe.PLAYER_O : TicTacToe.PLAYER_X;
								ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' turn");
							}
							if (ttc.currentPlayer.equals(TicTacToe.PLAYER_O)) {
								for (int r = 0; r < rows; r++) {
									for (int c = 0; c < cols; c++) {
										ttc.chosenBoard[r][c].setEnabled(false);
									}
								}
							}
						}


						//if statement contain CPU method to move
						if (ttc.chosenBoard == ttc.boardButton6x6) {
							Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								@Override
								public void run() {
									if (ttc.currentPlayer.equals(TicTacToe.PLAYER_O)) {
										MiniMaxAlgorithm.Move bestMove = mma.findBestMove(ttc.chosenBoard, ttc);
										ttc.chosenBoard[bestMove.row][bestMove.col].setText(TicTacToe.PLAYER_O);
										ttc.turns++;
										cwc.checkWinner(ttc);
										ttc.currentPlayer = ttc.currentPlayer == TicTacToe.PLAYER_X ? TicTacToe.PLAYER_O : TicTacToe.PLAYER_X;
										ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' turn");
									}
									if (ttc.currentPlayer.equals(TicTacToe.PLAYER_X))
										for (int r = 0; r < rows; r++) {
											for (int c = 0; c < cols; c++) {
												ttc.chosenBoard[r][c].setEnabled(true);
											}
										}
								}
							}, 0);
							//
						} else {
							Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								@Override
								public void run() {
									if (ttc.currentPlayer.equals(TicTacToe.PLAYER_O)) {
										MiniMaxAlgorithm.Move bestMove = mma.findBestMove(ttc.chosenBoard, ttc);
										ttc.chosenBoard[bestMove.row][bestMove.col].setText(TicTacToe.PLAYER_O);
										ttc.turns++;
										cwc.checkWinner(ttc);
										ttc.currentPlayer = ttc.currentPlayer == TicTacToe.PLAYER_X ? TicTacToe.PLAYER_O : TicTacToe.PLAYER_X;
										ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' turn");
									}
									if (ttc.currentPlayer.equals(TicTacToe.PLAYER_X))
										for (int r = 0; r < rows; r++) {
											for (int c = 0; c < cols; c++) {
												ttc.chosenBoard[r][c].setEnabled(true);
											}
										}
								}
							}, 500);
							//
						}
					}
				});
			}
		}
	}
}

package v_3_2;

import javax.swing.*;
import java.awt.*;

public class CheckWinConditions {

	boolean tieGame;

	public void checkWinner(TicTacToe ttc) {


		//horizontal
		for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1] - 2; c++) {
				if (ttc.chosenBoard[r][c].getText() == "") continue;
				if (ttc.chosenBoard[r][c].getText().equals(ttc.chosenBoard[r][c + 1].getText()) &&
								ttc.chosenBoard[r][c + 1].getText().equals(ttc.chosenBoard[r][c + 2].getText())) {
					setWinner(ttc.chosenBoard[r][c], ttc);
					setWinner(ttc.chosenBoard[r][c + 1], ttc);
					setWinner(ttc.chosenBoard[r][c + 2], ttc);

					ttc.gameOver = true;
					tieGame = false;
					winCounter(ttc);
					return;
				}
			}
		}


		//vertical
		for (int r = 0; r < TicTacToe.rowsColumns[0] - 2; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
				if (ttc.chosenBoard[r][c].getText() == "") continue;
				if (ttc.chosenBoard[r][c].getText().equals(ttc.chosenBoard[r + 1][c].getText()) &&
								ttc.chosenBoard[r + 1][c].getText().equals(ttc.chosenBoard[r + 2][c].getText())) {
					setWinner(ttc.chosenBoard[r][c], ttc);
					setWinner(ttc.chosenBoard[r + 1][c], ttc);
					setWinner(ttc.chosenBoard[r + 2][c], ttc);

					ttc.gameOver = true;
					tieGame = false;
					winCounter(ttc);
					return;
				}
			}
		}


		//diagonal
		for (int r = 0; r < TicTacToe.rowsColumns[0] - 2; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1] - 2; c++) {
				if (ttc.chosenBoard[r][c].getText() != "" &&
								ttc.chosenBoard[r][c].getText().equals(ttc.chosenBoard[r + 1][c + 1].getText()) &&
								ttc.chosenBoard[r + 1][c + 1].getText().equals(ttc.chosenBoard[r + 2][c + 2].getText())) {
					setWinner(ttc.chosenBoard[r][c], ttc);
					setWinner(ttc.chosenBoard[r + 1][c + 1], ttc);
					setWinner(ttc.chosenBoard[r + 2][c + 2], ttc);

					ttc.gameOver = true;
					tieGame = false;
					winCounter(ttc);
					return;
				}
			}
		}

		//anti-diagonal
		for (int r = 0; r < TicTacToe.rowsColumns[0] - 2; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1] - 2; c++) {
				if (ttc.chosenBoard[r + 2][c].getText() != "" &&
								ttc.chosenBoard[r + 2][c].getText().equals(ttc.chosenBoard[r + 1][c + 1].getText()) &&
								ttc.chosenBoard[r + 1][c + 1].getText().equals(ttc.chosenBoard[r][c + 2].getText())) {
					setWinner(ttc.chosenBoard[r][c + 2], ttc);
					setWinner(ttc.chosenBoard[r + 1][c + 1], ttc);
					setWinner(ttc.chosenBoard[r + 2][c], ttc);

					ttc.gameOver = true;
					tieGame = false;
					winCounter(ttc);
					return;
				}
			}
		}


		if (ttc.turns == TicTacToe.rowsColumns[0] * TicTacToe.rowsColumns[1]) {
			for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
				for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
					setTie(ttc.chosenBoard[r][c], ttc);
				}
			}
			ttc.gameOver = true;
			tieGame = true;
			winCounter(ttc);
		}
	}


	void setWinner(JButton tile, TicTacToe ttc) {
		tile.setForeground(Color.GREEN);
		tile.setBackground(Color.WHITE);
		ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' won");
	}


	void setTie(JButton tile, TicTacToe ttc) {
		tile.setForeground(Color.RED);
		tile.setBackground(Color.WHITE);
		ttc.ticTacToeJLabel.setText("Tie");
	}


	void winCounter(TicTacToe ttc) {
		if (tieGame == true) {
			ttc.counterTie++;
			ttc.setTextWinLoseTie();
		} else {
			if (ttc.currentPlayer.equals(TicTacToe.PLAYER_X)) {
				ttc.counterWin++;
				ttc.setTextWinLoseTie();
			} else {
				ttc.counterLose++;
			}
		}
		ttc.setTextWinLoseTie();
	}
}

package v_3_2;

import java.awt.*;

public class NewGameLoop {

	public void startNewGame(TicTacToe ttc) {
		ttc.gameOver = false;

		for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
				ttc.chosenBoard[r][c].setText("");
				ttc.chosenBoard[r][c].setBackground(Color.DARK_GRAY);
				ttc.chosenBoard[r][c].setForeground(Color.WHITE);
				ttc.currentPlayer.equals(ttc.PLAYER_X);
			}
		}
		ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' start");
		ttc.turns = 0;
	}
}

package v_3_2;

import javax.swing.*;

public class MiniMaxAlgorithm {

	//int [] rowsColums is an array that collect the contains the numbers of Columns and Rows
	// selected via ActionListener in class TicTacToe (//ActionListener for 3x3 and 6x6)
	// rowColumns[0] - numbers of rows of the board
	// rowColumns[1] - numbers of columns of the board

	//MAX_DEPTH is only use for grid6x6 since it is not suitable for larger grid
	//after testing  deep of 4 allow the program to run but doesnt but make the AI ineffective
	static final int MAX_DEPTH = 4;


	class Move {
		int row;
		int col;
	}


	CheckWinConditions cwc = new CheckWinConditions();

	
	//check if there are available  move on 3x3 board
	public Boolean areThereMoveLeft(JButton jButton[][], TicTacToe ttc) {


		for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
				if (TicTacToe.chosenBoard[r][c].getText().equals("")) {
					return true;
				}
			}
		}
		return false;
	}


	public int evaluate(JButton jButtonp[][], TicTacToe ttc) {
		//check for Rows for X or O victory
		//if player win add -10
		//if cpu win add +10


		//horizontal
		for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1] - 2; c++) {
				if (ttc.chosenBoard[r][c].getText() == "") continue;
				if (ttc.chosenBoard[r][c].getText().equals(ttc.chosenBoard[r][c + 1].getText()) &&
								ttc.chosenBoard[r][c + 1].getText().equals(ttc.chosenBoard[r][c + 2].getText())) {
					if (ttc.chosenBoard[r][c].getText().equals(TicTacToe.PLAYER_O)) {
						return +10;
					} else if (ttc.chosenBoard[r][c].getText().equals(TicTacToe.PLAYER_X)) {
						return -10;
					}
				}
			}
		}


		//vertical
		for (int r = 0; r < TicTacToe.rowsColumns[0] - 2; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
				if (ttc.chosenBoard[r][c].getText() == "") continue;
				if (ttc.chosenBoard[r][c].getText().equals(ttc.chosenBoard[r + 1][c].getText()) &&
								ttc.chosenBoard[r + 1][c].getText().equals(ttc.chosenBoard[r + 2][c].getText())) {
					if (ttc.chosenBoard[0][c].getText().equals(TicTacToe.PLAYER_O)) {
						return +10;
					} else if (ttc.chosenBoard[0][c].getText().equals(TicTacToe.PLAYER_X)) {
						return -10;
					}
				}
			}
		}


		//diagonal
		for (int r = 0; r < TicTacToe.rowsColumns[0] - 2; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1] - 2; c++) {
				if (ttc.chosenBoard[r][c].getText() != "" &&
								ttc.chosenBoard[r][c].getText().equals(ttc.chosenBoard[r + 1][c + 1].getText()) &&
								ttc.chosenBoard[r + 1][c + 1].getText().equals(ttc.chosenBoard[r + 2][c + 2].getText())) {
					if (ttc.chosenBoard[0][c].getText().equals(TicTacToe.PLAYER_O)) {
						return +10;
					} else if (ttc.chosenBoard[0][c].getText().equals(TicTacToe.PLAYER_X)) {
						return -10;
					}
				}
			}
		}


		//anti-diagonal
		for (int r = 0; r < TicTacToe.rowsColumns[0] - 2; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1] - 2; c++) {
				if (ttc.chosenBoard[r + 2][c].getText() != "" &&
								ttc.chosenBoard[r + 2][c].getText().equals(ttc.chosenBoard[r + 1][c + 1].getText()) &&
								ttc.chosenBoard[r + 1][c + 1].getText().equals(ttc.chosenBoard[r][c + 2].getText())) {
					if (ttc.chosenBoard[2][0].getText().equals(TicTacToe.PLAYER_O)) {
						return +10;
					} else if (ttc.chosenBoard[r + 2][c].getText().equals(TicTacToe.PLAYER_X)) {
						return -10;
					}
				}
			}
		}


		//tie game
		if (ttc.turns == TicTacToe.rowsColumns[0] * TicTacToe.rowsColumns[1]) {
			for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
				for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
					return 0;
				}
			}
		}
		return 0;
	}


	public int miniMax(JButton jButtons[][], int depth, boolean isMax, TicTacToe ttc) {


		int score = evaluate(ttc.chosenBoard, ttc);


		//if Maximizer (CPU) won the game
		if (score == 10) {
			return score;
		}


		//if Minimizer (human player) has won the game
		if (score == -10) {
			return score;
		}


		//if there is no more move (tie)
		if (areThereMoveLeft(ttc.chosenBoard, ttc) == false) {
			return 0;
		}


		//define depth so program dont take ages to execute
		if (ttc.chosenBoard == ttc.boardButton6x6) {
			if (depth == MAX_DEPTH || ttc.gameOver) {
				return evaluate(ttc.chosenBoard, ttc);
			}
		}


		//if maximizer move
		if (isMax) {
			int best = -1000;

			//traverse all cells
			for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
				for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {

					//check if cell is empty
					if (ttc.chosenBoard[r][c].getText().equals("")) {
						//make for CPU
						ttc.chosenBoard[r][c].setText(TicTacToe.PLAYER_O);
						//call minimax recursively and choose maximum value
						best = Math.max(best, miniMax(ttc.chosenBoard, depth + 1, !isMax, ttc));
						//undo move
						ttc.chosenBoard[r][c].setText("");
					}
				}
			}
			return best;


			// if minimizer move
		} else {
			int best = 1000;


			//traverse all cells
			for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
				for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {

					//check if cell is empty
					if (ttc.chosenBoard[r][c].getText().equals("")) {
						//make move for "PLAYER"
						ttc.chosenBoard[r][c].setText(TicTacToe.PLAYER_X);
						//call minimax recursively and choose maximum value
						best = Math.min(best, miniMax(ttc.chosenBoard, depth + 1, !isMax, ttc));
						//undo move
						ttc.chosenBoard[r][c].setText("");
					}
				}
			}
			return best;
		}
	}


	public Move findBestMove(JButton jButton[][], TicTacToe ttc) {


		int bestVal = -1000;
		Move bestMove = new Move();
		bestMove.row = -1;
		bestMove.col = -1;


		//Traverse all cells, use minimax for empty cell, find and return cell with optimal value
		for (int r = 0; r < TicTacToe.rowsColumns[0]; r++) {
			for (int c = 0; c < TicTacToe.rowsColumns[1]; c++) {
				//check if cell empty
				if (ttc.chosenBoard[r][c].getText().equals("")) {
					//make move CPU
					ttc.chosenBoard[r][c].setText(ttc.PLAYER_O);
					//CPU evaluate function for this move
					int moveVal = miniMax(ttc.chosenBoard, 0, false, ttc);
					//undo move;
					ttc.chosenBoard[r][c].setText("");

					//if the value of current move is best value, update int "best"
					if (moveVal > bestVal) {
						bestMove.row = r;
						bestMove.col = c;
						bestVal = moveVal;
					}
				}
			}
		}
		return bestMove;
	}
}


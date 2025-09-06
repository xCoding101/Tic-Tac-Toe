package v_3_1;

import java.awt.*;

public class NewGameLoop {

    public void startNewGame(TicTacToe ttc) {
            ttc.gameOver = false;

            //grid 3x3
            if (ttc.gameGridButton3x3.isSelected()){
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        ttc.boardButton3x3[r][c].setText("");
                        ttc.boardButton3x3[r][c].setBackground(Color.DARK_GRAY);
                        ttc.boardButton3x3[r][c].setForeground(Color.WHITE);
                        ttc.currentPlayer.equals(ttc.playerX);
                    }
                }
                ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' start");
                ttc.turns = 0;

            //grid 6x6
            } else if (ttc.gameGridButton6x6.isSelected()){
                for (int r = 0; r < 6; r++) {
                    for (int c = 0; c < 6; c++) {
                        ttc.boardButton6x6[r][c].setText("");
                        ttc.boardButton6x6[r][c].setBackground(Color.DARK_GRAY);
                        ttc.boardButton6x6[r][c].setForeground(Color.WHITE);
                        ttc.currentPlayer.equals(ttc.playerX);
                    }
                }
                ttc.ticTacToeJLabel.setText("Player '" + ttc.currentPlayer + "' start");
                ttc.turns = 0;
            }
    }
}

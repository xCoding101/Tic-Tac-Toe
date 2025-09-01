package v_3_0;

import java.awt.*;

public class NewGameLoop {

    public void startNewGame(TicTacToe ttc) {
            ttc.gameOver = false;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    ttc.boardButton3x3[r][c].setText("");
                    ttc.boardButton3x3[r][c].setBackground(Color.DARK_GRAY);
                    ttc.boardButton3x3[r][c].setForeground(Color.WHITE);
                }
            }
            ttc.textLabel.setText("Player '" + ttc.currentPlayer + "' start");
            ttc.turns = 0;
    }
}

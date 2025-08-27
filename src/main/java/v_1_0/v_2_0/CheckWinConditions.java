package v_1_0.v_2_0;

import javax.swing.*;
import java.awt.*;

public class CheckWinConditions {
    NewGameLoop ngl = new NewGameLoop();

    //3x3 Board
    public void checkWinner(TicTacToe ttc){
        //horizontal
        for (int r = 0 ; r < 3 ; r++){
            if(ttc.boardButton3x3[r][0].getText() == "") continue;
            if(ttc.boardButton3x3[r][0].getText().equals(ttc.boardButton3x3[r][1].getText()) &&
                    ttc.boardButton3x3[r][1].getText().equals(ttc.boardButton3x3[r][2].getText())){
                for (int i = 0 ; i < 3 ; i++){
                    setWinner(ttc.boardButton3x3[r][i], ttc);
                }

                ttc.gameOver = true;
                return;
            }
        }

        //vertical
        for (int c = 0 ; c < 3 ; c++){
            if(ttc.boardButton3x3[0][c].getText() == "") continue;
            if(ttc.boardButton3x3[0][c].getText().equals(ttc.boardButton3x3[1][c].getText()) &&
                    ttc.boardButton3x3[1][c].getText().equals(ttc.boardButton3x3[2][c].getText())){
                for (int i = 0 ; i < 3 ; i++){
                    setWinner(ttc.boardButton3x3[i][c], ttc);
                }
                ttc.gameOver = true;
                return;
            }
        }
        //diagonal
        if (ttc.boardButton3x3[0][0].getText() != "" &&
                ttc.boardButton3x3[0][0].getText().equals(ttc.boardButton3x3[1][1].getText()) &&
                ttc.boardButton3x3[1][1].getText().equals(ttc.boardButton3x3[2][2].getText())){
            for(int i = 0 ; i < 3 ; i ++){
                setWinner(ttc.boardButton3x3[i][i], ttc);
            }
            ttc.gameOver = true;
            return;
        }

        //anti-diagonal

        if (ttc.boardButton3x3[2][0].getText() != "" &&
                ttc.boardButton3x3[2][0].getText().equals(ttc.boardButton3x3[1][1].getText()) &&
                ttc.boardButton3x3[1][1].getText().equals(ttc.boardButton3x3[0][2].getText())){
            setWinner(ttc.boardButton3x3[0][2], ttc);
            setWinner(ttc.boardButton3x3[1][1], ttc);
            setWinner(ttc.boardButton3x3[2][0], ttc);
            ttc.gameOver = true;
            return;
        }

        if (ttc.turns == 9){
            for (int r = 0 ; r < 3 ; r++){
                for (int c = 0 ; c < 3 ; c++){
                    setTie(ttc.boardButton3x3[r][c], ttc);

                }
            }
            ttc.gameOver = true;
        }
    }

    void setWinner(JButton tile, TicTacToe ttc){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.WHITE);
        ttc.textLabel.setText(ttc.currentPlayer + " won, press 'R' to play again");
    }

    void setTie(JButton tile, TicTacToe ttc){
        tile.setForeground(Color.RED);
        tile.setBackground(Color.WHITE);
        ttc.textLabel.setText("Tie game, press 'R' to play again");
    }

}

package v_2_1;

import javax.swing.*;
import java.awt.*;

public class CheckWinConditions {
    NewGameLoop ngl = new NewGameLoop();

    boolean tieGame;

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
                tieGame = false;
                winCounter(ttc);
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
                tieGame = false;
                winCounter(ttc);
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
            tieGame = false;
            winCounter(ttc);
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
            tieGame = false;
            winCounter(ttc);
            return;
        }

        if (ttc.turns == 9){
            for (int r = 0 ; r < 3 ; r++){
                for (int c = 0 ; c < 3 ; c++){
                    setTie(ttc.boardButton3x3[r][c], ttc);
                }
            }
            ttc.gameOver = true;
            tieGame = true;
            winCounter(ttc);
        }
    }

    void setWinner(JButton tile, TicTacToe ttc){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.WHITE);
        ttc.textLabel.setText("Player '"+ ttc.currentPlayer + "' won");
    }

    void setTie(JButton tile, TicTacToe ttc){
        tile.setForeground(Color.RED);
        tile.setBackground(Color.WHITE);
    }

    void winCounter(TicTacToe ttc){
        if (tieGame == true){
            ttc.counterTie++;
            ttc.setTextWinLoseTie();
        } else {
            if (ttc.currentPlayer.equals(ttc.playerX)){
                ttc.counterWin++;
                ttc.setTextWinLoseTie();
            } else  {
                ttc.counterLose++;
            }
        }
        ttc.setTextWinLoseTie();
    }

}

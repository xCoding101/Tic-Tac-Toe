package v_3_1;

import javax.swing.*;
import java.awt.*;

public class CheckWinConditions {

    boolean tieGame;


    //3x3 Board (3 symbols in line to win)
    public void checkWinner3x3(TicTacToe ttc){

        //horizontal
        for (int r = 0 ; r < ttc.row3x3 ; r++){
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
        for (int c = 0 ; c < ttc.col3x3 ; c++){
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
            for (int r = 0 ; r < ttc.row3x3 ; r++){
                for (int c = 0 ; c < ttc.col3x3 ; c++){
                    setTie(ttc.boardButton3x3[r][c], ttc);
                }
            }
            ttc.gameOver = true;
            tieGame = true;
            winCounter(ttc);
        }
    }

    //6x6 Board (3 symbols in line for win)
    public void checkWinner6x6(TicTacToe ttc){

        //horizontal
        for (int r = 0 ; r < ttc.row6x6 ; r++){
            for (int c = 0; c < ttc.col6x6 - 2 ; c++){
                if(ttc.boardButton6x6[r][c].getText() == "") continue;
                if(ttc.boardButton6x6[r][c].getText().equals(ttc.boardButton6x6[r][c+1].getText()) &&
                   ttc.boardButton6x6[r][c+1].getText().equals(ttc.boardButton6x6[r][c+2].getText())){
                    for(int i = 0; i < 3 ; i++){
                        setWinner(ttc.boardButton6x6[r][c+i], ttc);
                    }
                    ttc.gameOver = true;
                    tieGame = false;
                    winCounter(ttc);
                    return;
                }
            }
        }

        //vertical
        for (int r = 0 ; r < ttc.row6x6 - 2; r++){
            for(int c = 0 ; c < ttc.col6x6 ; c++){
                if(ttc.boardButton6x6[r][c].getText() == "") continue;
                if(ttc.boardButton6x6[r][c].getText().equals(ttc.boardButton6x6[r+1][c].getText()) &&
                        ttc.boardButton6x6[r+1][c].getText().equals(ttc.boardButton6x6[r+2][c].getText())){
                    for (int i = 0 ; i < 3 ; i++){
                        setWinner(ttc.boardButton6x6[r+i][c], ttc);
                    }
                    ttc.gameOver = true;
                    tieGame = false;
                    winCounter(ttc);
                    return;
                }
            }

        }

        //diagonal
        for (int r = 0 ; r < ttc.row6x6 - 2 ; r++){
            for (int c = 0 ; c < ttc.col6x6 - 2 ; c++){
                if (ttc.boardButton6x6[r][c].getText() != "" &&
                        ttc.boardButton6x6[r][c].getText().equals(ttc.boardButton6x6[r+1][c+1].getText()) &&
                        ttc.boardButton6x6[r+1][c+1].getText().equals(ttc.boardButton6x6[r+2][c+2].getText())){
                    for(int i = 0 ; i < 3 ; i ++){
                        setWinner(ttc.boardButton6x6[r+i][c+i], ttc);
                    }
                    ttc.gameOver = true;
                    tieGame = false;
                    winCounter(ttc);
                    return;
                }
            }
        }

        //anti-diagonal
        for (int r = 0 ; r < ttc.row6x6 - 2 ; r++){
            for (int c = 0 ; c < ttc.col6x6 - 2 ; c++){
                if (ttc.boardButton6x6[r+2][c].getText() != "" &&
                        ttc.boardButton6x6[r+2][c].getText().equals(ttc.boardButton6x6[r+1][c+1].getText()) &&
                        ttc.boardButton6x6[r+1][c+1].getText().equals(ttc.boardButton6x6[r][c+2].getText())){
                    for (int i = 0 ; i < 3 ; i++){
                        setWinner(ttc.boardButton6x6[r][c+2], ttc);
                        setWinner(ttc.boardButton6x6[r+1][c+1], ttc);
                        setWinner(ttc.boardButton6x6[r+2][c], ttc);
                        ttc.gameOver = true;
                        tieGame = false;
                        winCounter(ttc);
                        return;
                    }

                }
            }
        }

        //tie
        if (ttc.turns == ttc.row6x6 * ttc.col6x6){
            for (int r = 0 ; r < ttc.row6x6 ; r++){
                for (int c = 0 ; c < ttc.col6x6 ; c++){
                    setTie(ttc.boardButton6x6[r][c], ttc);
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
        ttc.ticTacToeJLabel.setText("Player '"+ ttc.currentPlayer + "' won");
    }

    void setTie(JButton tile, TicTacToe ttc){
        tile.setForeground(Color.RED);
        tile.setBackground(Color.WHITE);
        ttc.ticTacToeJLabel.setText("Tie");
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

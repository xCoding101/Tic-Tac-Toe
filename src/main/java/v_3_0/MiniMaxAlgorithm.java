package v_3_0;

import javax.swing.*;

public class MiniMaxAlgorithm {

    class Move{
        int row;
        int col;
    }

    CheckWinConditions cwc = new CheckWinConditions();

    //check if there are available  move on 3x3 board
    public Boolean areThereMoveLeft (JButton jButton[][], TicTacToe ttc){
        for (int r = 0 ; r < 3 ; r++){
            for (int c = 0 ; c < 3 ; c++){
                if (ttc.boardButton3x3[r][c].getText().equals("")){
                    return true;
                }
            }
        }
        return false;
    }

    public int evaluate (JButton jButtonp[][],TicTacToe ttc){
        //check for Rows for X or O victory
        //if player win add -10
        //if cpu win add +10

        //horizontal
        for (int r = 0 ; r < 3 ; r++){
            if(ttc.boardButton3x3[r][0].getText() == "") continue;
            if(ttc.boardButton3x3[r][0].getText().equals(ttc.boardButton3x3[r][1].getText()) &&
               ttc.boardButton3x3[r][1].getText().equals(ttc.boardButton3x3[r][2].getText())){
                if(ttc.boardButton3x3[r][0].getText().equals(ttc.playerO)){
                    return +10;
                }else if (ttc.boardButton3x3[r][0].getText().equals(ttc.playerX)){
                    return -10;
                }
            }
        }

        //vertical
        for (int c = 0 ; c < 3 ; c++){
            if(ttc.boardButton3x3[0][c].getText() == "") continue;
            if(ttc.boardButton3x3[0][c].getText().equals(ttc.boardButton3x3[1][c].getText()) &&
               ttc.boardButton3x3[1][c].getText().equals(ttc.boardButton3x3[2][c].getText())){
                if(ttc.boardButton3x3[0][c].getText().equals(ttc.playerO)){
                    return +10;
                }else if (ttc.boardButton3x3[0][c].getText().equals(ttc.playerX)) {
                    return -10;
                }
            }
        }

        //diagonal
        if (ttc.boardButton3x3[0][0].getText() != "" &&
            ttc.boardButton3x3[0][0].getText().equals(ttc.boardButton3x3[1][1].getText()) &&
            ttc.boardButton3x3[1][1].getText().equals(ttc.boardButton3x3[2][2].getText())){
            if(ttc.boardButton3x3[0][0].getText().equals(ttc.playerO)){
                return +10;
            }else if (ttc.boardButton3x3[0][0].getText().equals(ttc.playerX)) {
                return -10;
            }
        }

        //anti-diagonal
        if (ttc.boardButton3x3[2][0].getText() != "" &&
            ttc.boardButton3x3[2][0].getText().equals(ttc.boardButton3x3[1][1].getText()) &&
            ttc.boardButton3x3[1][1].getText().equals(ttc.boardButton3x3[0][2].getText())){
            if(ttc.boardButton3x3[2][0].getText().equals(ttc.playerO)){
                return +10;
            }else if (ttc.boardButton3x3[2][0].getText().equals(ttc.playerX)) {
                return -10;
            }
        }

        //tie game
        if (ttc.turns == 9){
            return 0;
        }
        return 0;

    }

    public int miniMax(JButton jButtons[][], int depth, boolean isMax, TicTacToe ttc){

        int score = evaluate(ttc.boardButton3x3, ttc);

        //if Maximizer (CPU) won the game
        if (score == 10){
            return score;
        }
        //if Minimizer (human player) has won the game
        if (score == -10){
            return score;
        }
        //if there is no more move (tie)
        if (areThereMoveLeft(ttc.boardButton3x3, ttc) == false){
            return 0;
        }

        //if maximizer move
        if (isMax){
            int best = -1000;

            //traverse all cells
            for (int r = 0 ; r < 3 ; r++){
                for (int c = 0 ; c < 3 ; c++){

                    //check if cell is empty
                    if (ttc.boardButton3x3[r][c].getText().equals("")){
                        //make for CPU
                        ttc.boardButton3x3[r][c].setText(ttc.playerO);
                        //call minimax recursively and choose maximum value
                        best = Math.max(best, miniMax(ttc.boardButton3x3, depth + 1, !isMax, ttc));
                        //undo move
                        ttc.boardButton3x3[r][c].setText("");
                    }
                }
            }
            return best;

        // if minimizer move
        } else {
            int best = 1000;

            //traverse all cells
            for (int r = 0 ; r < 3 ; r++){
                for (int c = 0 ; c < 3 ; c++){

                    //check if cell is empty
                    if (ttc.boardButton3x3[r][c].getText().equals("")){
                        //make move for "PLAYER"
                        ttc.boardButton3x3[r][c].setText(ttc.playerX);
                        //call minimax recursively and choose maximum value
                        best = Math.min(best, miniMax(ttc.boardButton3x3, depth + 1, !isMax, ttc));
                        //undo move
                        ttc.boardButton3x3[r][c].setText("");
                    }
                }
            }
            return best;
        }
    }

    public Move findBestMove (JButton jButton[][], TicTacToe ttc){
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        //Traverse all cells, use minimax for empty cell, find and return cell with optimal value
        for (int r = 0 ; r < 3; r++){
            for (int c = 0 ; c < 3 ; c++){
                //check if cell empty
                if (ttc.boardButton3x3[r][c].getText().equals("")){
                    //make move CPU
                    ttc.boardButton3x3[r][c].setText(ttc.playerO);
                    //CPU evaluate function for this move
                    int moveVal = miniMax(ttc.boardButton3x3, 0, false, ttc);
                    //undo move;
                    ttc.boardButton3x3[r][c].setText("");

                    //if the value of current move is best value, update int "best"
                    if (moveVal > bestVal){
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

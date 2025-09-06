package v_3_1;

import javax.swing.*;

public class MiniMaxAlgorithm6x6 {

    //after tesing  deep of 4 allow the program to run but dosent but make the AI ineffective
    static final int maxDepth = 4;
    final int row6x6 = 6;
    final int col6x6 = 6;
    class Move{
        int row;
        int col;
    }

    //check if there are available  move on 6x6 board
    public Boolean areThereMoveLeft6x6(JButton jButton[][], TicTacToe ttc){
        for (int r = 0 ; r < col6x6 ; r++){
            for (int c = 0 ; c < col6x6 ; c++){
                if (ttc.boardButton6x6[r][c].getText().equals("")){
                    return true;
                }
            }
        }
        return false;
    }

    public int evaluate6x6(JButton jButtonp[][], TicTacToe ttc){
        //check for Rows for X or O victory
        //if player win add -10
        //if cpu win add +10

        //horizontal
        for (int r = 0 ; r < row6x6 ; r++){
            for (int c = 0 ; c < col6x6 - 2 ; c++){
                if(ttc.boardButton6x6[r][c].getText() == "") continue;
                if(ttc.boardButton6x6[r][c].getText().equals(ttc.boardButton6x6[r][c+1].getText()) &&
                        ttc.boardButton6x6[r][c+1].getText().equals(ttc.boardButton6x6[r][c+2].getText())){
                    if(ttc.boardButton6x6[r][c].getText().equals(ttc.playerO)){
                        return +10;
                    }else if (ttc.boardButton6x6[r][c].getText().equals(ttc.playerX)){
                        return -10;
                    }
                }
            }
        }

        //vertical
        for (int r = 0 ; r < row6x6 - 2; r++){
            for (int c = 0 ; c < col6x6 ; c++){
                if(ttc.boardButton6x6[r][c].getText() == "") continue;
                if(ttc.boardButton6x6[r][c].getText().equals(ttc.boardButton6x6[r+1][c].getText()) &&
                        ttc.boardButton6x6[r+1][c].getText().equals(ttc.boardButton6x6[r+2][c].getText())){
                    if(ttc.boardButton6x6[r][c].getText().equals(ttc.playerO)){
                        return +10;
                    }else if (ttc.boardButton6x6[r][c].getText().equals(ttc.playerX)) {
                        return -10;
                    }
                }
            }
        }

        //diagonal
        for (int r = 0 ; r < row6x6 - 2 ; r++){
            for (int c = 0 ; c < col6x6 - 2 ; c++){
                if (ttc.boardButton6x6[r][c].getText() != "" &&
                        ttc.boardButton6x6[r][c].getText().equals(ttc.boardButton6x6[r+1][c+1].getText()) &&
                        ttc.boardButton6x6[r+1][c+1].getText().equals(ttc.boardButton6x6[r+2][c+2].getText())){
                    if(ttc.boardButton6x6[r][c].getText().equals(ttc.playerO)){
                        return +10;
                    }else if (ttc.boardButton6x6[0][0].getText().equals(ttc.playerX)) {
                        return -10;
                    }
                }
            }
        }


        //anti-diagonal
        for (int r = 0 ; r < row6x6 - 2 ; r++){
            for (int c = 0 ; c < col6x6 -2 ; c++){
                if (ttc.boardButton6x6[r+2][c].getText() != "" &&
                        ttc.boardButton6x6[r+2][c].getText().equals(ttc.boardButton6x6[r+1][c+1].getText()) &&
                        ttc.boardButton6x6[r+1][c+1].getText().equals(ttc.boardButton6x6[r][c+2].getText())){
                    if(ttc.boardButton6x6[r+2][c].getText().equals(ttc.playerO)){
                        return +10;
                    }else if (ttc.boardButton6x6[r+2][c].getText().equals(ttc.playerX)) {
                        return -10;
                    }
                }
            }
        }


        //tie game
        if (ttc.turns == 9){
            return 0;
        }
        return 0;

    }

    public int miniMax6x6(JButton jButtons[][], int depth, boolean isMax, TicTacToe ttc){

        int score = evaluate6x6(ttc.boardButton6x6, ttc);

        //if Maximizer (CPU) won the game
        if (score == 10){
            return score;
        }
        //if Minimizer (human player) has won the game
        if (score == -10){
            return score;
        }
        //if there is no more move (tie)
        if (areThereMoveLeft6x6(ttc.boardButton6x6, ttc) == false){
            return 0;
        }

        //define depth so program dont take ages to execute
        if (depth ==  maxDepth || ttc.gameOver){
            return evaluate6x6(ttc.boardButton6x6 , ttc);
        }

        //if maximizer move
        if (isMax){
            int best = -1000;

            //traverse all cells
            for (int r = 0 ; r < row6x6 ; r++){
                for (int c = 0 ; c < col6x6 ; c++){

                    //check if cell is empty
                    if (ttc.boardButton6x6[r][c].getText().equals("")){
                        //make for CPU
                        ttc.boardButton6x6[r][c].setText(ttc.playerO);
                        //call minimax recursively and choose maximum value
                        best = Math.max(best, miniMax6x6(ttc.boardButton6x6, depth + 1, !isMax, ttc));
                        //undo move
                        ttc.boardButton6x6[r][c].setText("");
                    }
                }
            }
            return best;

            // if minimizer move
        } else {
            int best = 1000;

            //traverse all cells
            for (int r = 0 ; r < row6x6 ; r++){
                for (int c = 0 ; c < col6x6 ; c++){

                    //check if cell is empty
                    if (ttc.boardButton6x6[r][c].getText().equals("")){
                        //make move for "PLAYER"
                        ttc.boardButton6x6[r][c].setText(ttc.playerX);
                        //call minimax recursively and choose maximum value
                        best = Math.min(best, miniMax6x6(ttc.boardButton6x6, depth + 1, !isMax, ttc));
                        //undo move
                        ttc.boardButton6x6[r][c].setText("");
                    }
                }
            }
            return best;
        }
    }

    public Move findBestMove6x6(JButton jButton[][], TicTacToe ttc){
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        //Traverse all cells, use minimax for empty cell, find and return cell with optimal value
        for (int r = 0 ; r < row6x6; r++){
            for (int c = 0 ; c < col6x6 ; c++){
                //check if cell empty
                if (ttc.boardButton6x6[r][c].getText().equals("")){
                    //make move CPU
                    ttc.boardButton6x6[r][c].setText(ttc.playerO);
                    //CPU evaluate function for this move
                    int moveVal = miniMax6x6(ttc.boardButton6x6, 0, false, ttc);
                    //undo move;
                    ttc.boardButton6x6[r][c].setText("");

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

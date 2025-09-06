package v_3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class CreateBoard {
    MiniMaxAlgorithm3x3 miniMaxAlgorithm3x3 = new MiniMaxAlgorithm3x3();
    MiniMaxAlgorithm6x6 miniMaxAlgorithm6x6 = new MiniMaxAlgorithm6x6();



    //board (grid 3x3)
    public void createBoard3x3(TicTacToe ttc, CheckWinConditions cwc){
        ttc.boardPanel.setLayout(new GridLayout(3, 3));
        ttc.boardPanel.setBackground(Color.DARK_GRAY);
        ttc.mainJPanel.add(ttc.boardPanel);

        //create board (grid 3x3)//create board (grid 3x3)
        for (int r = 0; r < ttc.row3x3; r++) {
            for (int c = 0; c < ttc.col3x3; c++) {
                JButton tile = new JButton();
                ttc.boardButton3x3[r][c] = tile;
                ttc.boardPanel.add(tile);

                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Time New Roman", Font.BOLD, 40));
                tile.setFocusable(false);

                //ActionListener to allow interaction with "tiles"
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ttc.gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().equals("")) {
                            tile.setText(ttc.currentPlayer);
                            ttc.turns++;
                            cwc.checkWinner3x3(ttc);
                            if (!ttc.gameOver) {
                                //Ternary operation to rotate between players
                                ttc.currentPlayer = ttc.currentPlayer == ttc.playerX ? ttc.playerO : ttc.playerX;
                                ttc.ticTacToeJLabel.setText("Player '"+ ttc.currentPlayer + "' turn");
                            }
                            if (ttc.currentPlayer.equals(ttc.playerO)){
                                for (int r = 0 ; r < ttc.row3x3 ; r++){
                                    for (int c = 0 ; c < ttc.col3x3 ; c++){
                                        ttc.boardButton3x3[r][c].setEnabled(false);
                                    }
                                }
                            }
                        }

                        //if statement contain CPU method to move
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (ttc.currentPlayer.equals(ttc.playerO)){
                                    MiniMaxAlgorithm3x3.Move bestMove = miniMaxAlgorithm3x3.findBestMove3x3(ttc.boardButton3x3,ttc);
                                    ttc.boardButton3x3[bestMove.row][bestMove.col].setText(ttc.playerO);
                                    ttc.turns++;
                                    cwc.checkWinner3x3(ttc);
                                    ttc.currentPlayer = ttc.currentPlayer == ttc.playerX ? ttc.playerO : ttc.playerX;
                                    ttc.ticTacToeJLabel.setText("Player '"+ ttc.currentPlayer + "' turn");
                                }
                                if (ttc.currentPlayer.equals(ttc.playerX))
                                    for (int r = 0 ; r < ttc.row3x3 ; r++){
                                        for (int c = 0 ; c < ttc.col3x3 ; c++){
                                            ttc.boardButton3x3[r][c].setEnabled(true);
                                        }
                                    }
                            }
                        },750);
                    }
                });
            }
        }
    }


    //board (grid 6x6)
    public void createBoard6x6(TicTacToe ttc, CheckWinConditions cwc){
        ttc.boardPanel.setLayout(new GridLayout(6, 6));
        ttc.boardPanel.setBackground(Color.DARK_GRAY);
        ttc.mainJPanel.add(ttc.boardPanel);

        //create board (grid 6x6)
        for (int r = 0; r < ttc.row6x6; r++) {
            for (int c = 0; c < ttc.col6x6; c++) {
                JButton tile = new JButton();
                ttc.boardButton6x6[r][c] = tile;
                ttc.boardPanel.add(tile);

                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Time New Roman", Font.BOLD, 40));
                tile.setFocusable(false);

                //ActionListener to allow interaction with "tiles"
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ttc.gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().equals("")) {
                            tile.setText(ttc.currentPlayer);
                            ttc.turns++;
                            cwc.checkWinner6x6(ttc);
                            if (!ttc.gameOver) {
                                //Ternary operation to rotate between players
                                ttc.currentPlayer = ttc.currentPlayer == ttc.playerX ? ttc.playerO : ttc.playerX;
                                ttc.ticTacToeJLabel.setText("Player '"+ ttc.currentPlayer + "' turn");
                            }
                            if (ttc.currentPlayer.equals(ttc.playerO)){
                                for (int r = 0 ; r < ttc.row6x6 ; r++){
                                    for (int c = 0 ; c < ttc.col6x6 ; c++){
                                        ttc.boardButton6x6[r][c].setEnabled(false);
                                    }
                                }
                            }
                        }

                        //if statement contain CPU method to move
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (ttc.currentPlayer.equals(ttc.playerO)){
                                    MiniMaxAlgorithm6x6.Move bestMove = miniMaxAlgorithm6x6.findBestMove6x6(ttc.boardButton6x6,ttc);
                                    ttc.boardButton6x6[bestMove.row][bestMove.col].setText(ttc.playerO);
                                    ttc.turns++;
                                    cwc.checkWinner6x6(ttc);
                                    ttc.currentPlayer = ttc.currentPlayer == ttc.playerX ? ttc.playerO : ttc.playerX;
                                    ttc.ticTacToeJLabel.setText("Player '"+ ttc.currentPlayer + "' turn");
                                }
                                if (ttc.currentPlayer.equals(ttc.playerX)){
                                    for (int r = 0 ; r < ttc.row6x6 ; r++){
                                        for (int c = 0 ; c < ttc.col6x6 ; c++){
                                            ttc.boardButton6x6[r][c].setEnabled(true);
                                        }
                                    }
                                }
                            }
                        },1);
                    }
                });
            }
        }
    }
}

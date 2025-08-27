package v_1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBoard {

    //board (grid 3x3)
    public void createBoard3x3(TicTacToe ttc, CheckWinConditions cwc){
        ttc.boardPanel.setLayout(new GridLayout(3, 3));
        ttc.boardPanel.setBackground(Color.DARK_GRAY);
        ttc.frame.add(ttc.boardPanel);

        //create board (grid 3x3)//create board (grid 3x3)
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                ttc.boardButton3x3[r][c] = tile;
                ttc.boardPanel.add(tile);

                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Time New Roman", Font.BOLD, 120));
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
                            cwc.checkWinner(ttc);
                            if (!ttc.gameOver) {
                                //Ternary operation to rotate between players
                                ttc.currentPlayer = ttc.currentPlayer == ttc.playerX ? ttc.playerO : ttc.playerX;
                                ttc.textLabel.setText(ttc.currentPlayer + " turn");
                            }
                        }
                    }
                });
            }
        }
    }



}

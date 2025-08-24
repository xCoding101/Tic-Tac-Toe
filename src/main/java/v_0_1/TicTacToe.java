package v_0_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {

    //Window dimension
    int boardWidth = 600;
    int boardHeight = 650;


    //Basic Swing function
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] boardButton3x3 = new JButton[3][3];


    //Game variable
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;



    TicTacToe(){
        //create WINDOW
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Text
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        //Panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);// push border Layout to occupy uper part of application

        //board (grid 3x3)
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.DARK_GRAY);
        frame.add(boardPanel);
        for (int r = 0 ; r < 3 ; r++){
            for (int c = 0 ; c < 3; c++){
                JButton tile = new JButton();
                boardButton3x3[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Time New Roman", Font.BOLD, 120));
                tile.setFocusable(false);

                //ActionListener to allow interaction with "tiles"
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().equals("")){
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver){
                                //Ternary operation to rotate between players
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + " turn");
                            }
                        }
                    }
                });
            }
        }
    }

    //3x3 Board
    void checkWinner(){
        //horizontal
        for (int r = 0 ; r < 3 ; r++){
            if(boardButton3x3[r][0].getText() == "") continue;
            if(boardButton3x3[r][0].getText().equals(boardButton3x3[r][1].getText()) &&
                    boardButton3x3[r][1].getText().equals(boardButton3x3[r][2].getText())){
                for (int i = 0 ; i < 3 ; i++){
                    setWinner(boardButton3x3[r][i]);
                }

                gameOver = true;
                return;
            }
        }

        //vertical
        for (int c = 0 ; c < 3 ; c++){
            if(boardButton3x3[0][c].getText() == "") continue;
            if(boardButton3x3[0][c].getText().equals(boardButton3x3[1][c].getText()) &&
                    boardButton3x3[1][c].getText().equals(boardButton3x3[2][c].getText())){
                for (int i = 0 ; i < 3 ; i++){
                    setWinner(boardButton3x3[i][c]);
                }
                gameOver = true;
                return;
            }
        }
        //diagonal
        if (boardButton3x3[0][0].getText() != "" &&
                boardButton3x3[0][0].getText().equals(boardButton3x3[1][1].getText()) &&
                boardButton3x3[1][1].getText().equals(boardButton3x3[2][2].getText())){
            for(int i = 0 ; i < 3 ; i ++){
                setWinner(boardButton3x3[i][i]);
            }
            gameOver = true;
            return;
        }

        //anti-diagonal

        if (boardButton3x3[2][0].getText() != "" &&
                boardButton3x3[2][0].getText().equals(boardButton3x3[1][1].getText()) &&
                boardButton3x3[1][1].getText().equals(boardButton3x3[0][2].getText())){
            setWinner(boardButton3x3[0][2]);
            setWinner(boardButton3x3[1][1]);
            setWinner(boardButton3x3[2][0]);
            gameOver = true;
            return;
        }

        if (turns == 9){
            for (int r = 0 ; r < 3 ; r++){
                for (int c = 0 ; c < 3 ; c++){
                    setTie(boardButton3x3[r][c]);

                }
            }
            gameOver = true;
        }
    }


    void setWinner(JButton tile){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.WHITE);
        textLabel.setText(currentPlayer + " won");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.RED);
        tile.setBackground(Color.WHITE);
        textLabel.setText("Tie game");
    }
}

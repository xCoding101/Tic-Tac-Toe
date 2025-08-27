package v_1_0.v_2_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {

    NewGameLoop ngl = new NewGameLoop();

    //Window dimension
    int boardWidth = 600;
    int boardHeight = 650;


    //Basic Swing function
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    //textPanel is mainPanel
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] boardButton3x3 = new JButton[3][3];
    JButton newGame = new JButton("New Game");


    //Game variable
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;




    public TicTacToe() {
        //create WINDOW
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Text
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        //Panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);// push border Layout to occupy uper part of application

        //New Game JButton
        textPanel.add(newGame,BorderLayout.SOUTH);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ngl.startNewGame(TicTacToe.this);
            }
        });


    }
}
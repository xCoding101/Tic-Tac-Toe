package v_3_0;

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
    JLabel gameCounter = new JLabel();
    //textPanel is mainPanel
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] boardButton3x3 = new JButton[3][3];
    JButton[][] boardButton6x6 = new JButton[6][6];
    JButton newGame = new JButton("New Game");


    //Game variable
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;

    //Win-Lose-Tie variable
    String win = "Win: ";
    String lose = "Lose: ";
    String tie = "Tie: ";



    int counterWin = 0;
    int counterLose =  0;
    int counterTie =  0;



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

        //"New Game" JButton
        textPanel.add(newGame,BorderLayout.SOUTH);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ngl.startNewGame(TicTacToe.this);
            }
        });

        //Bottom Layout for showing WIN/LOSE/TIE
        gameCounter.setBackground(Color.DARK_GRAY);
        gameCounter.setForeground(Color.WHITE);
        gameCounter.setFont(new Font("Times New Roman", Font.BOLD, 40));
        gameCounter.setHorizontalAlignment(JLabel.CENTER);
        setTextWinLoseTie();
        gameCounter.setOpaque(true);
        frame.add(gameCounter, BorderLayout.SOUTH);



    }
    public void setTextWinLoseTie(){
        gameCounter.setText(win + counterWin + "   " + lose + counterLose + "   "+ tie + counterTie);
    }


}
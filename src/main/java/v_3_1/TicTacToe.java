package v_3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {


    int pressCounter3x3 = 0;
    int pressCounter6x6 = 0;


    CreateBoard cb = new CreateBoard();
    CheckWinConditions cwc = new CheckWinConditions();
    NewGameLoop ngl = new NewGameLoop();


    //Window dimension
    int boardWidth = 600;
    int boardHeight = 650;


    //Basic Swing function
    JFrame frame = new JFrame("Tic-Tac-Toe");


    JLabel ticTacToeJLabel = new JLabel();
    JLabel gameCounterLabel = new JLabel();
    //textPanel is mainPanel


    JPanel mainJPanel = new JPanel();
    JPanel choseBoarSize = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel gameCounterPanel = new JPanel();


    JButton[][] boardButton3x3 = new JButton[3][3];
    JButton[][] boardButton6x6 = new JButton[6][6];
    JButton newGameButton = new JButton("New Game");


    JRadioButton gameGridButton3x3 = new JRadioButton("Grid 3x3");
    JRadioButton gameGridButton6x6 = new JRadioButton("Grid 6x6");


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


    //Board size
    final int row3x3 = 3;
    final int col3x3 = 3;
    final int row6x6 = 6;
    final int col6x6 = 6;


    public TicTacToe() {
        //create WINDOW frame
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        mainJPanel.setLayout(new BoxLayout(mainJPanel, BoxLayout.Y_AXIS));


        //Tic-Tac-Toe text banner
        ticTacToeJLabel.setBackground(Color.DARK_GRAY);
        ticTacToeJLabel.setForeground(Color.WHITE);
        ticTacToeJLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        ticTacToeJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ticTacToeJLabel.setText("Tic-Tac-Toe");
        ticTacToeJLabel.setOpaque(true);


        //Tic-Tac-Toe Banner
        mainJPanel.setBackground(Color.DARK_GRAY);
        mainJPanel.add(ticTacToeJLabel);
        frame.add(mainJPanel);// push border Layout to occupy uper part of application


        //Chose your grid (3x3 or 6x6)
        JLabel gridText = new JLabel("Chose the grid you want to play on:");
        gridText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        gridText.setForeground(Color.WHITE);
        gridText.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainJPanel.add(gridText);
        gameGridButton3x3.setText("3x3");
        gameGridButton6x6.setText("6x6");
        gameGridButton3x3.setBackground(Color.DARK_GRAY);
        gameGridButton3x3.setForeground(Color.WHITE);
        gameGridButton6x6.setBackground(Color.DARK_GRAY);
        gameGridButton6x6.setForeground(Color.WHITE);
        gameGridButton3x3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        gameGridButton6x6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        gameGridButton3x3.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameGridButton6x6.setAlignmentX(Component.CENTER_ALIGNMENT);
        choseBoarSize.setLayout(new BoxLayout(choseBoarSize, BoxLayout.X_AXIS));
        choseBoarSize.add(gameGridButton3x3);
        choseBoarSize.add(gameGridButton6x6);
        mainJPanel.add(choseBoarSize);


        //ButtonGroup for grid selection
        ButtonGroup gridGroup = new ButtonGroup();
        gridGroup.add(gameGridButton3x3);
        gridGroup.add(gameGridButton6x6);


        //ActionListener for 3x3 and 6x6
        gameGridButton3x3.addActionListener(e -> {
            {
                if (boardPanel.getComponentCount() == 0){
                    cb.createBoard3x3(TicTacToe.this,cwc);
                } else if (boardPanel.getComponentCount() > 0){
                    boardPanel.removeAll();
                    boardPanel.revalidate();
                    boardPanel.repaint();
                    cb.createBoard3x3(TicTacToe.this,cwc);
                }
            }
        });
        gameGridButton6x6.addActionListener(e -> {
            {
                if (boardPanel.getComponentCount() == 0){
                    cb.createBoard6x6(TicTacToe.this,cwc);
                } else if (boardPanel.getComponentCount() > 0){
                    boardPanel.removeAll();
                    boardPanel.revalidate();
                    boardPanel.repaint();
                    cb.createBoard6x6(TicTacToe.this,cwc);
                }
            }
        });


        //"New Game" JButton
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        mainJPanel.add(newGameButton);


        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ngl.startNewGame(TicTacToe.this);
            }
        });


        //Bottom Layout for showing WIN/LOSE/TIE
        gameCounterLabel.setBackground(Color.DARK_GRAY);
        gameCounterLabel.setForeground(Color.WHITE);
        gameCounterLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        gameCounterLabel.setHorizontalAlignment(JLabel.CENTER);
        setTextWinLoseTie();
        gameCounterLabel.setOpaque(true);
        frame.add(gameCounterLabel, BorderLayout.SOUTH);




    }
    public void setTextWinLoseTie(){
        gameCounterLabel.setText(win + counterWin + "   " + lose + counterLose + "   "+ tie + counterTie);
    }


}
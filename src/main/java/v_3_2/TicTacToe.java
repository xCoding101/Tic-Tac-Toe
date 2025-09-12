package v_3_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {

	CreateBoard cb = new CreateBoard();
	NewGameLoop ngl = new NewGameLoop();


	//Window dimension
	private static final int BOARD_WIDTH = 600;
	private static final int BOARD_HEIGHT = 650;


	//Basic Swing function
	final JFrame frame = new JFrame("Tic-Tac-Toe");

	//all project JLabel
	JLabel ticTacToeJLabel = new JLabel();
	JLabel gameCounterLabel = new JLabel();


	//all project JPanel
	JPanel mainJPanel = new JPanel();
	JPanel choseBoarSize = new JPanel();
	JPanel boardPanel = new JPanel();


	//all project JButtons
	JButton[][] boardButton3x3 = new JButton[3][3];
	JButton[][] boardButton6x6 = new JButton[6][6];
	JButton newGameButton = new JButton("New Game");


	//variable for method choseBoard() and choseRowsColumns()
	static int[] rowsColumns = {0, 0};
	static JButton[][] chosenBoard = new JButton[rowsColumns[0]][rowsColumns[1]];


	//all project JRadioButton
	JRadioButton gameGridButton3x3 = new JRadioButton("Grid 3x3");
	JRadioButton gameGridButton6x6 = new JRadioButton("Grid 6x6");


	//Game variable
	final static String PLAYER_X = "X";
	final static String PLAYER_O = "O";
	String currentPlayer = PLAYER_X;
	static boolean gameOver = false;
	static int turns = 0;


	//Win-Lose-Tie variable
	private final static String WIN = "Win: ";
	private final static String LOSE = "Lose: ";
	private final static String TIE = "Tie: ";
	static int counterWin = 0;
	static int counterLose = 0;
	static int counterTie = 0;


	//Board size
	final static int NUMBER_3 = 3;
	final static int NUMBER_6 = 6;
	final static int JBUTTON_SIZE = 40;
	final static int ROW_3X3 = NUMBER_3;
	final static int COL_3X3 = NUMBER_3;
	final static int ROW_6X6 = NUMBER_6;
	final static int COL_6X6 = NUMBER_6;


	public TicTacToe() {
		//create WINDOW frame
		frame.setVisible(true);
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
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
		prepareGameGrid(gameGridButton3x3, "3x3");
		prepareGameGrid(gameGridButton6x6, "6x6");


		//ButtonGroup for grid selection
		ButtonGroup gridGroup = new ButtonGroup();
		gridGroup.add(gameGridButton3x3);
		gridGroup.add(gameGridButton6x6);


		//ActionListener for 3x3 and 6x6
		gameGridButton3x3.addActionListener(e -> {
			{
				choseBoard(TicTacToe.this);
				choseRowsColumns(TicTacToe.this);
				if (boardPanel.getComponentCount() == 0) {
					//Legend
					//int rows - number of rows of the grid
					//int cols - number of columns of the grid
					//int size - size of the "X" and "O" variant
					cb.createBoard(TicTacToe.this, NUMBER_3, NUMBER_3, JBUTTON_SIZE);
				} else if (boardPanel.getComponentCount() > 0) {
					boardPanel.removeAll();
					boardPanel.revalidate();
					boardPanel.repaint();
					cb.createBoard(TicTacToe.this, NUMBER_3, NUMBER_3, JBUTTON_SIZE);
				}
			}
		});
		gameGridButton6x6.addActionListener(e -> {
			{
				choseBoard(TicTacToe.this);
				choseRowsColumns(TicTacToe.this);
				if (boardPanel.getComponentCount() == 0) {
					cb.createBoard(TicTacToe.this, NUMBER_6, NUMBER_6, JBUTTON_SIZE);
				} else if (boardPanel.getComponentCount() > 0) {
					boardPanel.removeAll();
					boardPanel.revalidate();
					boardPanel.repaint();
					cb.createBoard(TicTacToe.this, NUMBER_6, NUMBER_6, JBUTTON_SIZE);
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


	public void setTextWinLoseTie() {
		gameCounterLabel.setText(WIN + counterWin + "   " + LOSE + counterLose + "   " + TIE + counterTie);
	}


	public void prepareGameGrid(JRadioButton jrb, String text) {
		jrb.setText(text);
		jrb.setBackground(Color.DARK_GRAY);
		jrb.setForeground(Color.WHITE);
		jrb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jrb.setAlignmentX(Component.CENTER_ALIGNMENT);
		choseBoarSize.setLayout(new BoxLayout(choseBoarSize, BoxLayout.X_AXIS));
		choseBoarSize.add(jrb);
		mainJPanel.add(choseBoarSize);
	}


	public int[] choseRowsColumns(TicTacToe ttc) {
		if (ttc.gameGridButton3x3.isSelected()) {
			rowsColumns[0] = TicTacToe.ROW_3X3;
			rowsColumns[1] = TicTacToe.COL_3X3;
		} else if (ttc.gameGridButton6x6.isSelected()) {
			rowsColumns[0] = TicTacToe.ROW_6X6;
			rowsColumns[1] = TicTacToe.COL_6X6;
		}
		return rowsColumns;
	}


	public JButton[][] choseBoard(TicTacToe ttc) {
		if (ttc.gameGridButton3x3.isSelected()) {
			return chosenBoard = ttc.boardButton3x3;
		}
		return chosenBoard = ttc.boardButton6x6;
	}
}
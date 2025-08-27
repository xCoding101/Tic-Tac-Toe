package v_1_1;

public class Main {

    public static void main(String[] args) {
        //program initialization in default constructor of class TicTacToe
        TicTacToe ticTacToe = new TicTacToe();

        CreateBoard cb = new CreateBoard();
        CheckWinConditions cwc = new CheckWinConditions();

        //initialize create 3x3 board
        cb.createBoard3x3(ticTacToe,cwc);



    }

}

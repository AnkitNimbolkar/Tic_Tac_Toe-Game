import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];   // declared a 3x3 array

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner in = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + " enter: ");
            int row = in.nextInt();        // taking input row column input from user to put X or O.
            int col = in.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won.");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else{
                System.out.println("Invalid input");
                System.out.println();
            }
        }
    }

    public static boolean haveWon(char[][] board, char player) {           // Method for checking player won if the row or column or diagonal cells are all X either O.

        for (int row = 0; row < board.length; row++) {   // checking in rows if all cols in a row are X either O
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board[0].length; col++) {    // checking in columns if all rows in a column are X either O
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {   // checking the left diagonal
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {   // checking the right diagonal
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {            // Method to print board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

}

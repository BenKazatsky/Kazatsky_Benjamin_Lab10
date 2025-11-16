//Main Game Loop Do-While
//Call clearboard
//current player
//move count
//game done/false
//Active Game Loop
//Get Valid Move
//get display
//prompt player for row
//prompt player for column
//convert to correct terms
//check if move is valid, then do it
//else invalid move
//end do while
//check game status
//if movecount >=5
//If the player has all set gamedone true
//else if move count== 9 with no win
//call a tie
//game donetrue
//end if
//gamedone false
//switch current player
//end current game loop
//ask user to play again Y/N
//end main g1
//me loop


import java.util.Scanner;

public class Main {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    private static String currentPlayer = "X";
    private static int moveCount = 0;
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        boolean playing = true;

        do {
            clearBoard();
            currentPlayer = "X";
            moveCount = 0;
            boolean gameDone = false;

            while(!gameDone) {

                int rowMove;
                int colMove;
                boolean isValid = false;

                do {
                    display();

                    System.out.println("It is " + currentPlayer + "'s turn.");

                    rowMove = SafeInput.getRangedInt(console, "Enter row", 1, 3);
                    colMove = SafeInput.getRangedInt(console, "Enter column", 1, 3);

                    int rowIdx = rowMove - 1;
                    int colIdx = colMove - 1;

                    if (isValidMove(rowIdx, colIdx)) {
                        board[rowIdx][colIdx] = currentPlayer;
                        moveCount++;
                        isValid = true;
                    } else {
                        System.out.println("\n*** That is not a valid move. Try again! ***\n");
                    }

                } while(!isValid);

                if (moveCount >= 5) {
                    if (isWin(currentPlayer)) {
                        display();
                        System.out.println("\n🎉 Player " + currentPlayer + " WINS! 🎉\n");
                        gameDone = true;
                    }
                }

                if (!gameDone && moveCount == 9) {
                    if (isTie()) {
                        display();
                        System.out.println("\n🤝 It's a TIE! 🤝\n");
                        gameDone = true;
                    }
                }

                if (!gameDone) {
                    if (currentPlayer.equals("X")) {
                        currentPlayer = "O";
                    } else {
                        currentPlayer = "X";
                    }
                }
            }

            playing = SafeInput.getYNConfirm(console, "Play again");

        } while(playing);
    }

    private static void clearBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("\n-----------------");
        for (int r = 0; r < ROWS; r++) {
            System.out.print("|");
            for (int c = 0; c < COLS; c++) {
                System.out.print(" " + board[r][c] + " ");
                System.out.print("|");
            }
            System.out.println();
            System.out.println("-----------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagnalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int c = 0; c < COLS; c++) {
            if(board[0][c].equals(player) && board[1][c].equals(player) && board[2][c].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int r = 0; r < ROWS; r++) {
            if(board[r][0].equals(player) && board[r][1].equals(player) && board[r][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player) {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        if (moveCount == 9) {
            return true;
        }
        return false;
    }
}
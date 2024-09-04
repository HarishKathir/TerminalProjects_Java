import java.util.Scanner;

/**
 * This class is a Terminal Tic Tac Toe game
 */
public class App {

    /**
     * Validates the Game and player,
     * @param arr a String Array of size 3x3
     * @param initialPlayer as String either "X" or "O"
     */

    public static void gameCanvas(String[][] arr, String initialPlayer) {
        //Initializes the game 
        boolean gameOngoing = true;

        //prints the board initially with empty cells
        printBoard(arr);

        //Loops till if a player is won or game is draw
        while (gameOngoing) {
            System.out.println((initialPlayer.equals("X")) ? "X turn" : "O Turn");

            //checks for the valid moves
            boolean validMove = userInputs(arr, initialPlayer);

            if (validMove) {
                printBoard(arr);
                if (gameValidation(arr, initialPlayer)) {
                    System.out.println(initialPlayer + " wins");
                    gameOngoing = false; // returns false to exit the loop if a Player is won
                } else if (isBoardFull(arr)) {
                    System.out.println("It's a draw");
                    gameOngoing = false; // returns false ot exit the loop if the game is draw
                } else {
                    initialPlayer = (initialPlayer.equals("X")) ? "O" : "X"; // continues to run till the above conditions are met
                }
            }
        }
    }
    /**
     * Validates the game 
     *  -- checks the row for a strike
     *  -- checks the column for a strike
     *  -- checks the diagonal for a strike
     * @param arr as the String array of size 3x3
     * @param player a String Character as either "X or "O
     * @return a boolean , true if the condition is met or returns false 
     */
    public static boolean gameValidation(String[][] arr, String player) {
        // Check rows and columns
    for (int i = 0; i < 3; i++) {
        //Checks the rows
        if (arr[i][0] != null && arr[i][0].equals(player) &&
            arr[i][1] != null && arr[i][1].equals(player) &&
            arr[i][2] != null && arr[i][2].equals(player)) {
            return true;
        }
        //Checks the columns
        if (arr[0][i] != null && arr[0][i].equals(player) &&
            arr[1][i] != null && arr[1][i].equals(player) &&
            arr[2][i] != null && arr[2][i].equals(player)) {
            return true;
        }
    }
    // Check diagonals
    if (arr[0][0] != null && arr[0][0].equals(player) &&
        arr[1][1] != null && arr[1][1].equals(player) &&
        arr[2][2] != null && arr[2][2].equals(player)) {
        return true;
    }
    if (arr[0][2] != null && arr[0][2].equals(player) &&
        arr[1][1] != null && arr[1][1].equals(player) &&
        arr[2][0] != null && arr[2][0].equals(player)) {
        return true;
    }
    return false;
    }

    /**
     * Validates the user Inputs,
     * Uses a isValidPosition method to check the position, 
     *  -- loops till a valid position is set 
     *  -- loops if the new position is same as a marked position
     * @param arr String array for size 3x3
     * @param player is a String either "X" or "O"
     * @return a boolean , true if the player marks the correct position else returns false  
     */
    public static boolean userInputs(String[][] arr, String player) {
        Scanner sc = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Enter row and column (1-3)");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;
            if (isValidPosition(row, col) && arr[row][col] == null) {
                arr[row][col] = player;
                return true;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    /**
     * Validates the position to be marked 
     * @param row as the row of the String array
     * @param col as the column of the String array
     * @return a boolean , true if the condition is met or else false
     */
    public static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    /**
     * Prints the board for a 2D array of size 3 x 3
     * @param arr
     */
    public static void printBoard(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | ");
                System.out.print((arr[i][j] == null) ? "-" : arr[i][j]);
            }
            System.out.print(" | ");
            System.out.println();
        }
    }
    /**
     * validates if the board is full , ie., if all position are marked
     * @param arr String array of size 3x3
     * @return a boolean , true if the condition is met or else false
     */
    public static boolean isBoardFull(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Displays Options as 1 for X || 2 for O 
     * Gets input from the user
     * @return a String X or O using the playerTurns method
     */
    public static String choosePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1 is X, press 1");
        System.out.println("Player 2 is O, press 2");
        int playerChoice = sc.nextInt();
        return (playerTurns(playerChoice) == 1) ? "X" : "O";
    }

    /**
     * 
     * @param choice
     * @return 1 or 0 based on param
     */
    
    public static int playerTurns(int choice) {
        return (choice == 1) ? 1 : 0;
    }

    //Main class 
    public static void main(String[] args) {
        String[][] arr = new String[3][3];
        String initialPlayer = choosePlayer();
        gameCanvas(arr, initialPlayer);
    }
}
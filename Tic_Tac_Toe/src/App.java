import java.util.Scanner;

public class App {

    public static void gameCanvas(String[][] arr, String initialPlayer) {
        boolean gameOngoing = true;
        while (gameOngoing) {
            System.out.println((initialPlayer.equals("X")) ? "X turn" : "O Turn");
            boolean validMove = userInputs(arr, initialPlayer);
            if (validMove) {
                printBoard(arr);
                if (gameValidation(arr, initialPlayer)) {
                    System.out.println(initialPlayer + " wins");
                    gameOngoing = false;
                } else if (isBoardFull(arr)) {
                    System.out.println("It's a draw");
                    gameOngoing = false;
                } else {
                    initialPlayer = (initialPlayer.equals("X")) ? "O" : "X";
                }
            }
        }
    }

    public static boolean gameValidation(String[][] arr, String player) {
        // Check rows and columns
    for (int i = 0; i < 3; i++) {
        if (arr[i][0] != null && arr[i][0].equals(player) &&
            arr[i][1] != null && arr[i][1].equals(player) &&
            arr[i][2] != null && arr[i][2].equals(player)) {
            return true;
        }
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

    public static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

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

    public static String choosePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1 is X, press 1");
        System.out.println("Player 2 is O, press 2");
        int playerChoice = sc.nextInt();
        return (playerTurns(playerChoice) == 1) ? "X" : "O";
    }

    public static int playerTurns(int choice) {
        return (choice == 1) ? 1 : 0;
    }

    public static void main(String[] args) {
        String[][] arr = new String[3][3];
        String initialPlayer = choosePlayer();
        gameCanvas(arr, initialPlayer);
    }
}
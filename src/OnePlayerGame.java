import java.util.Scanner;
import java.util.Random;

public class OnePlayerGame {
    public static void createBoardArray(String[][] board){
        int i = 1;
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                board[x][y] = String.valueOf(i);
                i = i + 1;
            }
        }
    }
    public static void printBoard(String[][] board) {
        for (int y = 0; y < 3; y++){
            if (y > 0) {
                System.out.println("\n-----|-----|-----");
            }
            else {
                System.out.println();
            }
            for (int x = 0; x < 3; x++){
                System.out.print("  " + board[x][y]);
                if (x < 2){
                    System.out.print("  |");
                }
            }
        }
        System.out.println("\n");
    }
    public static void playerTurn(String[][] board, String figure){
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        int x = 3;
        int y = 3;
        System.out.print("Enter a number between 1 and 9: ");
        while (again) {
            int cell = sc.nextInt();
            again = false;
            //convert cell to x y coords
            switch (cell) {
                case 1:
                    x = 0;
                    y = 0;
                    break;
                case 2:
                    x = 1;
                    y = 0;
                    break;
                case 3:
                    x = 2;
                    y = 0;
                    break;
                case 4:
                    x = 0;
                    y = 1;
                    break;
                case 5:
                    x = 1;
                    y = 1;
                    break;
                case 6:
                    x = 2;
                    y = 1;
                    break;
                case 7:
                    x = 0;
                    y = 2;
                    break;
                case 8:
                    x = 1;
                    y = 2;
                    break;
                case 9:
                    x = 2;
                    y = 2;
                    break;
                default:
                    System.out.println("That cell doesn't exist. Enter a number of an existing cell: ");
                    again = true;
            }
            if (board[x][y] != "X" && board[x][y] != "O") {
                board[x][y] = figure;
            } else if (board[x][y] != "X" || board[x][y] != "O") {
                System.out.println("That cell is already taken. Enter a number of a cell that isn't taken: ");
                again = true;
            }
        }
    }
    public static void computerTurn(String[][] board, String figure){
        boolean again = true;
        int x = 3;
        int y = 3;
        System.out.println("The computer is thinking...");
        while (again) {
            Random rn = new Random();
            int cell = rn.nextInt(9) + 1;
            again = false;
            //convert cell to x y coords
            switch (cell) {
                case 1:
                    x = 0;
                    y = 0;
                    break;
                case 2:
                    x = 1;
                    y = 0;
                    break;
                case 3:
                    x = 2;
                    y = 0;
                    break;
                case 4:
                    x = 0;
                    y = 1;
                    break;
                case 5:
                    x = 1;
                    y = 1;
                    break;
                case 6:
                    x = 2;
                    y = 1;
                    break;
                case 7:
                    x = 0;
                    y = 2;
                    break;
                case 8:
                    x = 1;
                    y = 2;
                    break;
                case 9:
                    x = 2;
                    y = 2;
                    break;
                default:
                    again = true;
            }
            if (board[x][y] != "X" && board[x][y] != "O") {
                System.out.println("The computer is playing in cell: " + cell);
                board[x][y] = figure;
            } else {
                again = true;
            }
        }
    }
    public static void printEnterMove(String figure){
        if (figure == "X"){
            System.out.println("It's your turn");
        } else if (figure == "O") {
            System.out.println("The computer is playing...");
        }
    }
    public static String checkWinner(String[][] board){
        //horizontal
        String line1 = board[0][0] + board[1][0] + board[2][0];
        String line2 = board[0][1] + board[1][1] + board[2][1];
        String line3 = board[0][2] + board[1][2] + board[2][2];
        //vertikal
        String line4 = board[0][0] + board[0][1] + board[0][2];
        String line5 = board[1][0] + board[1][1] + board[1][2];
        String line6 = board[2][0] + board[2][1] + board[2][2];
        //diagonal
        String line7 = board[0][0] + board[1][1] + board[2][2];
        String line8 = board[2][0] + board[1][1] + board[0][2];
        if(line1.contains("XXX")||
                line2.contains("XXX")||
                line3.contains("XXX")||
                line4.contains("XXX")||
                line5.contains("XXX")||
                line6.contains("XXX")||
                line7.contains("XXX")||
                line8.contains("XXX")){
            return "X";
        } else if (line1.contains("OOO")||
                line2.contains("OOO")||
                line3.contains("OOO")||
                line4.contains("OOO")||
                line5.contains("OOO")||
                line6.contains("OOO")||
                line7.contains("OOO")||
                line8.contains("OOO")) {
            return "O";
        } else{
            return "-";
        }
    }


    public static void main(String[] args) {
        System.out.println("Playing Tic Tac Toe against the computer");
        String[][] board = new String[3][3];

        createBoardArray(board);
        printBoard(board);

        String figure = "O";
        int moveCounter = 0;
        //game loop
        while (checkWinner(board) == "-" && moveCounter <= 8) {
            moveCounter = moveCounter + 1;
            switch (figure) {
                case "X":
                    figure = "O";
                    break;
                case "O":
                    figure = "X";
                    break;
            }
            printEnterMove(figure);
            switch (figure) {
                case "X":
                    playerTurn(board, figure);
                    break;
                case "O":
                    computerTurn(board, figure);
                    break;
            }
            printBoard(board);
        }
        switch (checkWinner(board)){
            case "X":
                System.out.println("You win!");
                break;
            case "O":
                System.out.println("The computer wins!");
                break;
            default:
                System.out.println("It's a draw");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("Enter 1 to play again");
        System.out.println("Enter 2 to go to the main menu");
        System.out.println("Enter 3 to exit");
        System.out.print("--> ");
        int gamemode = sc.nextInt();
        boolean again = true;
        while (again) {
            again = false;
            switch (gamemode) {
                case 1:
                    OnePlayerGame.main(null);
                    break;
                case 2:
                    Main.main(null);
                    break;
                case 3:
                    System.out.println("Leaving Game...");
                    break;
            }
        }
    }
}

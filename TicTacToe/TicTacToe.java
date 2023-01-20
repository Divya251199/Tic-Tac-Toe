import java.util.*;
import java.io.*;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create 3 x 3 2d array 
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);


        //  as it's running for only one move
        while(true) {
            playerTurn(board, sc);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        sc.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if( hasContestantWon(board, 'X') ) {
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }      

        if( hasContestantWon(board, 'O') ) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        } 

        // to check if the places are blank and there's no winner
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if( board[i][j] == ' ' ) {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie");
        return true;
    }



    private static boolean hasContestantWon(char[][] board, char symbol) {
        //Check first row
        if ( (board[0][0] == symbol  && board[0][1] == symbol && board[0][2] == symbol ) || 
             (board[1][0] == symbol  && board[1][1] == symbol && board[1][2] == symbol ) ||
             (board[2][0] == symbol  && board[2][1] == symbol && board[2][2] == symbol ) ||
             
             // check first column
             (board[0][0] == symbol  && board[1][0] == symbol && board[2][0] == symbol ) || 
             (board[0][1] == symbol  && board[1][1] == symbol && board[2][1] == symbol ) ||
             (board[0][2] == symbol  && board[1][2] == symbol && board[2][2] == symbol ) ||
             
             // diagonal check
             (board[0][0] == symbol  && board[1][1] == symbol && board[2][2] == symbol ) ||
             (board[0][2] == symbol  && board[1][1] == symbol && board[2][0] == symbol ) ) {
                return true;
            }
        return false;
    }




    private static void computerTurn(char[][] board) {
        // random function for computer's play
        
        Random ran = new Random();
        int computerMove;
        while (true) {
            // we want numbers 1-9; but we get 0-8 
            // add 1 to it
            // then check if it's a valid move
            computerMove = ran.nextInt(9) + 1;
            if ( isValidMove(board, Integer.toString(computerMove)) ) {
                break;
            }
        }
        System.out.println("Computer chose" + computerMove);
        // play computer's move
        placeMove(board, Integer.toString(computerMove), 'O');
    }



    private static boolean isValidMove ( char[][] board, String position ) {
        // check if the input given by player/computer is available or not
            switch(position) {
            case "1":
                return board[0][0] == ' ';
            case "2":
                return board[0][1] == ' ';
            case "3":
                return board[0][2] == ' ';
            case "4":
                return board[1][0] == ' ';
            case "5":
                return board[1][1] == ' ';
            case "6":
                return board[1][2] == ' ';
            case "7":
                return board[2][0] == ' ';
            case "8":
                return board[2][1] == ' ';
            case "9":
                return board[2][2] == ' ';
            default: 
                return false;
        }

    }


    private static void playerTurn(char[][] board, Scanner sc) {
        String userInput;
        while(true) {
            // To take input of number of box user want to add nought or cross
            System.out.println("Where would you like to play(0-9)");
            userInput = sc.nextLine();
            if(isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput +  " is not a valid move");
            }
        }
        placeMove(board, userInput, 'X');
        // can close scanner as we don't need it again
    }



        private static void placeMove(char[][] board, String position, char symbol ) {
        // take input from player and computer and put symbol X or O on that position
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;

            case "2":
                board[0][1] = symbol;
                break;

            case "3":
                board[0][2] = symbol;
                break;

            case "4":
                board[1][0] = symbol;
                break;

            case "5":
                board[1][1] = symbol;
                break;

            case "6":
                board[1][2] = symbol;
                break;

            case "7":
                board[2][0] = symbol;
                break;

            case "8":
                board[2][1] = symbol;
                break;

            case "9":
                board[2][2] = symbol;
                break;

            default: 
                System.out.println(":(");
        }
        printBoard(board);

    }


    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}

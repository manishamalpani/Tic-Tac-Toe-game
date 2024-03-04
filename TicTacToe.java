import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[3][3];

        for(int row = 0;row < board.length;row++){
            for(int col = 0;col< board[row].length;col++){
                board[row][col] = ' ';
            }
        }

        System.out.println("-------------Game Started-------------");
        System.out.println();
        System.out.print("Which player will have first turn(X/O): ");
        char player = sc.next().charAt(0);

        while(player != 'X' && player != 'x' && player != 'O' && player != 'o'){
            System.out.println("Invalid player. Try Again!!!");
            System.out.print("Which player will have first turn(X/O): ");
            player = sc.next().charAt(0);
        }

        boolean GameOver = false;

        while(!GameOver){
            printBoard(board);
            if(Check(board)){
                System.out.println("No moves left.");
                System.out.println("-------------Game Over-------------");
                return;
            }
            System.out.print("Player " + player + " enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            while(row >=3 || col >= 3 || row < 0 || col < 0){
                System.out.println("Invalid Input(row and col should be greater than equal to 0 and less than equal to 2) . Try Again!!!");
                System.out.print("Player " + player + " enter: ");
                row = sc.nextInt();
                col = sc.nextInt();
            }
            while(board[row][col] != ' '){
                System.out.println("Invalid Input. Try Again!!!");
                System.out.print("Player " + player + " enter: ");
                row = sc.nextInt();
                col = sc.nextInt();
                while(row >=3 || col >= 3 || row < 0 || col < 0){
                    System.out.println("Invalid Input(row and col should be greater than equal to 0 and less than equal to 2) . Try Again!!!");
                    System.out.print("Player " + player + " enter: ");
                    row = sc.nextInt();
                    col = sc.nextInt();
                }
            }

            board[row][col] = player;
            System.out.println();
            GameOver = hasWon(board, player);
            if(player == 'X' || player == 'x'){
                player = 'O';
            }else{
                player = 'X';
            }

        }

        System.out.println("Player " + player + " has won!!!!");
    }

    private static boolean Check(char[][] board) {
        for(int row = 0;row < board.length;row++){
            for(int col = 0;col<board.length;col++){
                if(board[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasWon(char[][] board, char player) {
        for(int row = 0; row < board.length; row ++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        for(int col = 0; col < board.length; col ++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for(int row = 0;row < board.length;row++){
            System.out.println("-|-----|-----|-----|-");
            System.out.print(" | ");
            for(int col = 0;col< board[row].length;col++){
                System.out.print(" " + board[row][col] + "  | ");
            }

            System.out.println();
        }
        System.out.println("-|-----|-----|-----|-");
        System.out.println();
    }
}

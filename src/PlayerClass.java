import java.util.Scanner;

public class PlayerClass implements PlayerInterface {
    private final char player;
    private int row,column;
    public PlayerClass(char player) {
        this.player = player;
    }

    @Override
    public boolean checkWin(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                if (arr[i][0] == player) {
                    return win(arr);
                }
            } else if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                if (arr[0][i]==player) {
                    return win(arr);
                }
            }
        }
        if (arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2]){
            if (arr[1][1] == player) {
                return win(arr);
            }
        } else if (arr[2][0]==arr[1][1]&&arr[1][1]==arr[0][2]) {
            if (arr[1][1] == player) {
                return win(arr);
            }
        }
        return true;
    }
    private boolean win(char[][] arr){
        Main.printBoard(arr);
        System.out.println("\nWinner is "+player+".");
        return false;
    }
    private boolean isValidMove(char[][] arr) {
        if (row<=0||row>=4){
            System.out.println("""
                    
                    Please enter valid row!!
                    """);
            return false;
        } else if (column<=0||column>=4) {
            System.out.println("""
                    
                    Please enter valid column!!
                    """);
            return false;
        }
        if (arr[row-1][column-1]!=' '){
            System.out.println("""
                    
                    Please enter empty coordinate!!
                    """);
            return false;
        }
        return true;
    }

    @Override
    public void makeMove(char[][] arr) {
        getIndex(arr);
        arr[row-1][column-1]=player;
    }
    private void getIndex(char[][] arr) {
        Scanner sr= new Scanner(System.in);
        do {
            System.out.println("It's the player "+player+"'s turn.");
            System.out.print("Please enter row(1,2,3): ");
            row = sr.nextInt();
            System.out.print("Please enter column(1,2,3): ");
            column = sr.nextInt();
        } while (!isValidMove(arr));
    }
}

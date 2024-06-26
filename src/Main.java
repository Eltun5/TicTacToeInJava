public class Main {
    public static void main(String[] args) {
        char[][] arr = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        PlayerO PO=new PlayerO();
        PlayerX PX=new PlayerX();
        boolean checkTurn=true;
        System.out.println("""
                TicTacToe has started
                
                
                The game has 4 simple rules.
                
                1. The game is played on a 3x3 board.
                2. Players take turns to place their marker (either 'X' or 'O') in an empty cell.
                3. The first player to align three of their markers horizontally, vertically, or diagonally wins.
                4. If all cells are filled and no player has won, the game ends in a draw.
                
                
                """);
        while (PX.checkWin(arr)&& PO.checkWin(arr)&&!isDraw(arr,PX,PO)) {
            printBoard(arr);
            if (checkTurn) {
                PX.makeMove(arr);
                checkTurn=false;
            }else {
                PO.makeMove(arr);
                checkTurn=true;
            }
        }
    }

    public static void printBoard(char[][] arr) {
        System.out.printf("""
                           |  1  |  2  |  3
                        ___|_____|_____|_____
                           |     |     |
                        1  |  %s  |  %s  |  %s
                        ___|_____|_____|_____
                           |     |     |
                        2  |  %s  |  %s  |  %s
                        ___|_____|_____|_____
                           |     |     |
                        3  |  %s  |  %s  |  %s
                           |     |     |
                        """, arr[0][0], arr[0][1], arr[0][2]
                , arr[1][0], arr[1][1], arr[1][2]
                , arr[2][0], arr[2][1], arr[2][2]);
    }
    public static boolean isDraw(char[][] arr,PlayerX PX,PlayerO PO){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (arr[i][j]==' '){
                    return false;
                }
            }
        }
        if (PX.checkWin(arr)&&PO.checkWin(arr)){
            printBoard(arr);
            System.out.println("""
                    
                    There is no winner.
                    """);
            return true;
        }
        return false;
    }
}
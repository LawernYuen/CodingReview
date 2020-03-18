package CodingDaily;

public class SurroundedRegion {
    public void solve(char[][] board){
        if (board == null || board.length < 3 || board[0].length < 3)
            return;
        for (int i = 1; i < board.length-1; i++){
            for (int j = 1; j < board[0].length-1; j++){
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                if (board[i][j] == 'O'){
                    isVisited[i][j] = true;
                    if (solveCore(board, isVisited, i, j-1)
                            && solveCore(board, isVisited, i, j+1)
                            && solveCore(board, isVisited, i-1, j)
                            && solveCore(board, isVisited, i+1, j))
                        board[i][j] = 'X';
                    else
                        isVisited[i][j] = false;
                }
            }
        }
        return;
    }

    private static boolean solveCore(char[][] board, boolean[][] isVisited, int i, int j){
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1)
            return false;
        if (board[i][j] == 'X' || isVisited[i][j])
            return true;
        else if (board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1))
            return false;
        isVisited[i][j] = true;
        if (solveCore(board, isVisited, i, j-1)
                && solveCore(board, isVisited, i, j+1)
                && solveCore(board, isVisited, i-1, j)
                && solveCore(board, isVisited, i+1, j))
            return true;
        else {
            isVisited[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args){
//        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        char[][] board = {{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},
//                {'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
        char[][] board = {{'X','X','X','X','O','O','X','X','O'},{'O','O','O','O','X','X','O','O','X'},
                {'X','O','X','O','O','X','X','O','X'},{'O','O','X','X','X','O','O','O','O'},
                {'X','O','O','X','X','X','X','X','O'},{'O','O','X','O','X','O','X','O','X'},
                {'O','O','O','X','X','O','X','O','X'},{'O','O','O','X','O','O','O','X','O'},
                {'O','X','O','O','O','X','O','X','O'}};
        SurroundedRegion demo = new SurroundedRegion();
        demo.solve(board);
    }
}

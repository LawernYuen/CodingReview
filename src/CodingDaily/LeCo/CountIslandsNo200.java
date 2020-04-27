package CodingDaily.LeCo;

public class CountIslandsNo200 {
    private int ans = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1') {
                    ans++;
                    countIslands(grid, i, j);
                }
            }
        }
        return ans;
    }
    private void countIslands(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        countIslands(grid, i-1, j);
        countIslands(grid, i+1, j);
        countIslands(grid, i, j-1);
        countIslands(grid, i, j+1);
    }
}

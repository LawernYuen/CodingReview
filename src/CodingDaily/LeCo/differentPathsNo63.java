package CodingDaily.LeCo;

public class differentPathsNo63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++)
            if (obstacleGrid[i][0] != 1 && dp[i-1][0] != 0)
                dp[i][0] = 1;
        for (int i = 1; i < obstacleGrid[0].length; i++)
            if (obstacleGrid[0][i] != 1 && dp[0][i-1] != 0)
                dp[0][i] = 1;
        for (int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1)
                    dp[i][j] = 0;
                else if (obstacleGrid[i-1][j] == 1)
                    dp[i][j] = dp[i][j-1];
                else if (obstacleGrid[i][j-1] == 1)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        differentPathsNo63 demo = new differentPathsNo63();
        int[][] a = {{0,0},{0,1}};
        int ans = demo.uniquePathsWithObstacles(a);
        System.out.println(ans);
    }
}

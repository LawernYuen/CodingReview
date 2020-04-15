package CodingDaily.LeCo;

import java.util.List;

public class minPathTriNo120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++){
            for (int j = 0; j <= i; j++){
                if (i == 0 && j == 0)
                    dp[i][j] = triangle.get(i).get(j);
                else if (j == 0)
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                else if (j == i)
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                if (i == m-1)
                    ans = Math.min(ans, dp[i][j]);
            }
        }
        return ans;
    }
}

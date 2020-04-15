package CodingDaily.LeCo;

public class maxProfit3No123 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            for (int j = 2; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[prices.length-1][2][0];
    }

    public static void main(String[] args) {
        int[] a = {3,3,5,0,0,3,1,4};
        maxProfit3No123 demo = new maxProfit3No123();
        int ans = demo.maxProfit(a);
        System.out.println(ans);
    }
}

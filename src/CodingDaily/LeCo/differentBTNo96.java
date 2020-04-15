package CodingDaily.LeCo;

public class differentBTNo96 {
    public int numTrees(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++)
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j-1] * dp[i-j];
        return dp[n];
    }

    public static void main(String[] args) {
        differentBTNo96 demo = new differentBTNo96();
        int ans = demo.numTrees(3);
        System.out.println(ans);
    }
}

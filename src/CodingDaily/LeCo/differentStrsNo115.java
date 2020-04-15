package CodingDaily.LeCo;

public class differentStrsNo115 {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return 0;
        int[][] dp = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++){
            for (int j = 0; j < s.length(); j++){
                if (i == 0 && j == 0 && t.charAt(i) == s.charAt(j))
                    dp[i][j] = 1;
                else if (i == 0 && t.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i][j-1] + 1;
                else if (j == 0)
                    dp[i][j] = 0;
                else if (t.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[t.length()-1][s.length()-1];
    }

    public static void main(String[] args) {
        differentStrsNo115 demo = new differentStrsNo115();
        String s = "aacaacca";
        String t = "ca";
        int ans = demo.numDistinct(s, t);
        System.out.println(ans);
    }
}

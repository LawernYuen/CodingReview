package CodingDaily;

public class LongestPanlindromicSeq {
    public int findSeq1(String str){
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int hi = 1; hi < n; hi++){
            dp[hi][hi] = 1;
            for (int lo = hi; lo >= 0; lo--){
                if (str.charAt(lo) == str.charAt(hi))
                    dp[lo][hi] = dp[lo+1][hi-1] + 2;
                else
                    dp[lo][hi] = Math.max(dp[lo+1][hi], dp[lo][hi-1]);
            }
        }
        return dp[0][n-1];
    }

    public int findSeq2(String str){
        int[] preRow = new int[str.length()];
        for (int i = str.length()-1; i >= 0; i--){
            int[] curRow = new int[str.length()];
            curRow[i] = 1;
            for (int j = i+1; j < str.length(); j++){
                int left = curRow[j-1];
                int bottom = preRow[j];
                int leftbottom = preRow[j-1];
                if (str.charAt(i) == str.charAt(j))
                    curRow[j] = leftbottom + 2;
                else
                    curRow[j] = Math.max(left, bottom);
            }
            preRow = curRow;
        }
        return preRow[str.length()-1];
    }
}

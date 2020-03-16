package CodingDaily;

public class NoOfPalindromic {
    static int num = 0;
    public int getNo1(String str){
        for(int i = 0; i < str.length(); i++){
            centerSpread(str, i, i);
            centerSpread(str, i, i+1);
        }
        return num;
    }
    private static void centerSpread(String str, int lo, int hi){
        while (lo >= 0 && hi < str.length() && str.charAt(lo) == str.charAt(hi)){
            lo--;
            hi++;
            num++;
        }
    }

    private int getNo2(String str){
        int ans = 0;
        boolean[][] dp = new boolean[str.length()][str.length()];
        for (int i = str.length()-1; i >= 0; i--){
            for (int j = i; j < str.length(); j++){
                dp[i][j] = (str.charAt(i) == str.charAt(j)) && (j-i<=2 || dp[i+1][j-1]);
                if (dp[i][j])   ans++;
            }
        }
        return ans;
    }
}

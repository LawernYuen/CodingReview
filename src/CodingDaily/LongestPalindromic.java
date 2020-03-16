package CodingDaily;

public class LongestPalindromic {
    public String findLongest1(String str){
        int len = str.length();
        if (len < 2)  return str;
        int maxLen = 1;
        String ans = str.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        for (int hi = 1; hi < len; hi++){
            for (int lo = 0; lo < hi; lo++){
                if (str.charAt(lo) == str.charAt(hi) && (hi-lo<=2 || dp[lo+1][hi-1])){
                    dp[lo][hi] = true;
                    if (hi - lo + 1 > maxLen){
                        maxLen = hi - lo + 1;
                        ans = str.substring(lo, hi+1);
                    }
                }
            }
        }
        return ans;
    }

    private static int start, maxLeng;
    public String findLongest2(String str){
        if (str == null || str.length() < 2)    return str;
        for (int i = 0; i < str.length(); i++){
            centerSpread(str, i, i);
            centerSpread(str, i, i+1);
        }
        return str.substring(start, start+maxLeng);
    }
    private static void centerSpread(String str, int i, int j){
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        if (maxLeng < j - i - 1){
            start = i + 1;
            maxLeng = j - i + 1;
        }
    }
}

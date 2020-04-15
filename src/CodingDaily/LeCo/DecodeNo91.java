package CodingDaily.LeCo;

public class DecodeNo91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        if (s.charAt(s.length()-1) != '0')
            dp[s.length()-1] = 1;
        for (int i = s.length()-2; i >= 0; i--){
            int digit1 = s.charAt(i) - '0';
            int digit2 = s.charAt(i+1) - '0';
            if (digit1*10 + digit2 >= 1 && digit1*10 + digit2 <= 26 && digit1 != 0 && digit2 != 0)
                dp[i] = dp[i+1] + 1;
            else
                dp[i] = dp[i+1];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        DecodeNo91 demo = new DecodeNo91();
        String s = "12";
        int ans = demo.numDecodings(s);
        System.out.println(ans);
    }
}

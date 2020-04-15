package CodingDaily.LeCo;

import java.util.Scanner;
public class longstPalinNo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        boolean[][] dp = new boolean[str.length()][str.length()];
        int[] max = {0,0,0};
        for (int i = str.length()-1; i >= 0; i--){
            dp[i][i] = true;
            for (int j = i+1; j < str.length(); j++){
                if (str.charAt(i) == str.charAt(j)){
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                    if (j-i+1 > max[0] && dp[i][j]){
                        max[0] = j-i+1;
                        max[1] = i;
                        max[2] = j;
                    }
                }
                else
                    dp[i][j] = false;
            }
        }
        if (max[1] == max[2])
            System.out.println(String.valueOf(str.charAt(max[1])));
        else
            System.out.println(str.substring(max[1],max[1]+max[0]));
    }
//    private static boolean isPalin(String str){
//        int i = 0, j = str.length()-1;
//        while (str.charAt(i) == str.charAt(j)){
//            if (i >= j)
//                return true;
//            i++;
//            j--;
//        }
//        return false;
//    }
}

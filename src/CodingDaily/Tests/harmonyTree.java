package CodingDaily.Tests;

import java.util.Scanner;
public class harmonyTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int m = in.nextInt();
        int[] hNum = new int[num];
        int ans = 0;
        for (int i = 0; i < num; i++){
            hNum[i] = in.nextInt();
        }
        for (int i = num-1; i >= 0; i--){
            int sum = hNum[i];
            if (sum % m == 0)
                ans++;
            for (int j = i+1; j < num; j++){
                sum += hNum[j];
                if (sum % m == 0)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}

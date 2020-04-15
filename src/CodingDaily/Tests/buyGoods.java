package CodingDaily.Tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class buyGoods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] prices = new int[num];
        int times = 0;
        long ans = 0;
        for (int i = 0; i < num; i++)
            prices[i] = in.nextInt();
        Arrays.sort(prices);
        for (int i = num-1; i >= 0; i--){
            if (times != 2) {
                ans += prices[i];
                times++;
            }
            else
                times = 0;
        }
        System.out.println(ans);
    }
}

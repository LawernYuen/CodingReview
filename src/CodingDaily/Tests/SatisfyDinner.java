package CodingDaily.Tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class SatisfyDinner {
    public int[] WaitInLine (int[] a, int[] b) {
        int[][] div = new int[a.length][2];
        for (int i = 0; i < a.length; i++){
            div[i][0] = a[i] + b[i];
            div[i][1] = i;
        }
        Arrays.sort(div, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++)
            ans[i] = div[i][1]+1;
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {8,9,7};
        int[] b = {5,8,3};
        SatisfyDinner demo = new SatisfyDinner();
        int[] ans = demo.WaitInLine(a,b);
        System.out.println(ans);
    }
}

package CodingDaily.Tests;

import java.util.Scanner;
public class Pyrmaid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int state = 0;
        int[] sum = new int[1];
        int[] optt = {1,2,3};
        for (int i = 0; i < 3; i++)
            circle(state, k-1, optt[i], sum);
        System.out.println(sum[0]);
    }
    private static boolean circle(int state, int k, int opt, int[] sum){
        state = state + opt;
        if (state < 0 || state > 3 || (k == 0 && state != 0))
            return false;
        if (k == 0 && state == 0) {
            sum[0]++;
            return true;
        }
        circle(state, k-1, 1, sum);
        circle(state, k-1, 2, sum);
        circle(state, k-1, 3, sum);
        circle(state, k-1, -1, sum);
        circle(state, k-1, -2, sum);
        circle(state, k-1, -3, sum);
        return true;
    }
}

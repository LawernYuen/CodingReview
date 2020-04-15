package CodingDaily.Tests;

import java.util.Scanner;
public class FixBug {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int right = n*(k-1);
        double left = k - 1/Math.pow(k,n-1);
        double x = right / left;
        int xx = (int) Math.ceil(x);
        while (true){
            int sum = getSum(xx, k);
            if (sum >= n)
                break;
            xx++;
        }
        System.out.println(xx);
    }
    private static int getSum(int x, int k){
        int sum = 0;
        int m = 0;
        while (x / Math.pow(k,m) >= 1)
            m++;
        for (int i = 0; i < m; i++)
            sum += Math.floor(x / Math.pow(k,i));
        return sum;
    }
}

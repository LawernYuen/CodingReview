package CodingDaily.Tests;

import java.util.Arrays;
import java.util.Scanner;

public class remArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long[] numArray = new long[num];
        for (int i = 0; i < num; i++)
            numArray[i] = in.nextLong();
//        Arrays.sort(numArray);
//        for (int i = 0; i < num; i++){
//            if (numArray[num-i-1]+i < num) {
//                System.out.println(i);
//                break;
//            }
//        }
        int times = 0;
        while (true){
            int max = getMax(numArray);
            if (numArray[max] < num){
                System.out.println(times);
                break;
            }
            numArray[max] -= (num+1);
            for (long idx : numArray)
                idx++;
            times++;
        }
    }
    private static int getMax(long[] a){
        int max = 0;
        for (int i = 1; i < a.length; i++)
            if (a[max] < a[i])
                max = i;
        return max;
    }
}

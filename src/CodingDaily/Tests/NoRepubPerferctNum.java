package CodingDaily.Tests;

import java.util.*;
public class NoRepubPerferctNum {
    public int[] GetPowerFactor (int R, int N) {
        if (N == 0 && R == 0)
            return new int[]{0};
        else if (N * R == 0)
            return null;
        int times = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (R > 0){
            if (R % N != 0) {
                list.add(times);
                R = R - 1;
                if (R % N != 0)
                    return null;
            }
            R = R / N;
            times++;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return  ans;
    }

    public static void main(String[] args) {
        NoRepubPerferctNum demo = new NoRepubPerferctNum();
        int[] a = demo.GetPowerFactor(1, 3);
        System.out.println(a);
    }
}

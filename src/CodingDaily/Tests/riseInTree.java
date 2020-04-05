package CodingDaily.Tests;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class riseInTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        HashMap<Integer, Integer> weights = new HashMap<>(num);
        int[] weight = new int[num];
        for (int i = 0; i < num; i++) {
            weight[i] = in.nextInt();
            weights.put(i, weight[i]);
        }
        Arrays.sort(weight);
        boolean[][] isLinked = new boolean[num][num];
        for (int i = 0; i < num-1; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            isLinked[m][n] = true;
            isLinked[n][m] = true;
        }
        int[] maxLength = new int[num];
        for (int i = num-1; i >= 0; i--){
            for (int j = i; j < num-1; j++){
                if (isLinked[i][j])
                    if (maxLength[i] < 1+maxLength[j])
                        maxLength[i] = 1 + maxLength[j];
            }
        }
        System.out.println(maxLength[0]);
    }
}

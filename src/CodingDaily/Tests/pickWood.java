package CodingDaily.Tests;

import java.util.Scanner;

public class pickWood {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numGroup = in.nextInt();
        while (in.hasNextInt()) {
            int numWood = in.nextInt();
            int[] length = new int[numWood];
            int[] weight = new int[numWood];
            for (int i = 0; i < numWood; i++)
                length[i] = in.nextInt();
            for (int i = 0; i < numWood; i++)
                weight[i] = in.nextInt();
            int[] rank = new int[numWood];
            int result = 0;
            for (int i = 0; i < numWood; i++) {
                for (int j = i + 1; j < numWood; j++) {
                    if (dominates(length, weight, i, j))
                        rank[i]++;
                    if (dominates(length, weight, j, i))
                        rank[j]++;
                }
            }
            for (int r : rank){
                if (result < r)
                    result = r;
            }
            result = numWood - result;
            System.out.println(result);
        }
    }
    private static boolean dominates(int[] obj1, int[] obj2, int m, int n){
        if ((obj1[m] >= obj2[m] && obj1[n] >= obj2[n]))
            return true;
        else
            return false;
    }
}

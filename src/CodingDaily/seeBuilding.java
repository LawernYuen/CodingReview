package CodingDaily;

import java.util.Scanner;

public class seeBuilding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] building = new int[num];
        for (int i = 0; i < num; i++)
            building[i] = in.nextInt();
        int[] ans = new int[num];
        for (int i = 0; i < num; i++){
            ans[i]++;
            if (i > 0) {
                int max = building[i-1];
                ans[i]++;
                for (int j = i - 1; j >= 0; j--) {
                    if (building[j] > max) {
                        max = building[j];
                        ans[i]++;
                    }
                }
            }
            if (i < num-1){
                int max = building[i+1];
                ans[i]++;
                for (int j = i + 1; j < num; j++) {
                    if (building[j] > max) {
                        max = building[j];
                        ans[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < num; i++)
            System.out.print(ans[i] + " ");
    }
}

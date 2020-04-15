package CodingDaily.Tests;

import java.util.Scanner;
public class HeadCharge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int ans = 0;
        int[] seq1 = new int[num];
        int[] seq2 = new int[num];
        for (int i = 0; i < num; i++){
            int temp = in.nextInt();
            seq1[temp-1] = i;
        }
        for (int i = 0; i < num; i++){
            int temp = in.nextInt();
            seq2[temp-1] = i;
        }
        for (int i = 0; i < num; i++)
            for (int j = i+1; j < num; j++) {
                if (seq1[i] > seq1[j] && seq2[i] < seq2[j]) {
                    ans++;
                    break;
                }
            }
        System.out.println(ans);
    }
}

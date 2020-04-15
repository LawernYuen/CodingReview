package CodingDaily.Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class AnimalVote {
    private static int ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>(num+1);
//        for (int i = 0; i < num+1; i++){
//            ArrayList<Integer> templist = new ArrayList<>();
//            list.add(templist);
//        }
//        for (int i = 1; i < num+1; i++) {
//            int temp = in.nextInt();
//            list.get(temp).add(i);
//        }
//        for (int i = 1; i < num+1; i++){
//            if (list.get(i).isEmpty())
//                System.out.println(1);
//            else {
//                ArrayList<Integer> templist = list.get(i);
//                ans = 0;
//                for (Integer integer : templist) {
//                    ans++;
//                    getMember(list.get(integer), list);
//                }
//                System.out.println(ans+1);
//            }
//        }
        int[] admire = new int[num];
        for (int i = 0; i < num; i++)
            admire[i] = in.nextInt();
        int[] dp = new int[num];
        Arrays.fill(dp, 1);
        for (int i = num-1; i > 0; i--)
            dp[admire[i]-1] += dp[i];
        for (int i = 0; i < num; i++)
            System.out.println(dp[i]);
    }
    private static void getMember(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> Mlist){
        if (!list.isEmpty()) {
            ans++;
            for (Integer integer : list) getMember(Mlist.get(integer), Mlist);
        }
    }
}

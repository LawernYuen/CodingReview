package CodingDaily.Tests;

import java.util.*;

public class TrainSeat {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] table = new int[num][2];
        for (int i = 0; i < num; i++){
            table[i][0] = in.nextInt();
            table[i][1] = in.nextInt();
        }
        Arrays.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> anslist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(table[0][0]);
        list.add(table[0][1]);
        anslist.add(list);
        for (int i = 1; i < num; i++){
            int upper = anslist.get(anslist.size()-1).get(1);
            if (!(table[i][1] <= upper)){
                List<Integer> templist = new ArrayList<>();
                templist.add(table[i][0]);
                templist.add(table[i][1]);
                anslist.add(templist);
            }
        }
        System.out.println(num-anslist.size());
    }
}

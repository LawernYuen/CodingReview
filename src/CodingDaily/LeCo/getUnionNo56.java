package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class getUnionNo56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ansList.add(new ArrayList<>(2));
        ansList.get(0).add(intervals[0][0]);
        ansList.get(0).add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= ansList.get(ansList.size()-1).get(1) &&
                    intervals[i][0] >= ansList.get(ansList.size()-1).get(0)){
                if (!(intervals[i][1] <= ansList.get(ansList.size()-1).get(1) &&
                        intervals[i][0] >= ansList.get(ansList.size()-1).get(0))) {
                    ArrayList<Integer> list = ansList.get(ansList.size() - 1);
                    int upper = Math.max(list.get(1), intervals[i][1]);
                    ansList.remove(ansList.size()-1);
                    ansList.add(new ArrayList<>(2));
                    ansList.get(ansList.size()-1).add(list.get(0));
                    ansList.get(ansList.size()-1).add(upper);
                }
            }
            else {
                ansList.add(new ArrayList<>(2));
                ansList.get(ansList.size()-1).add(intervals[i][0]);
                ansList.get(ansList.size()-1).add(intervals[i][1]);
            }
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++){
            ans[i][0] = ansList.get(i).get(0);
            ans[i][1] = ansList.get(i).get(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{1,10}};
        getUnionNo56 demo = new getUnionNo56();
        int[][] ans = demo.merge(intervals);
        System.out.println(ans);
    }
}

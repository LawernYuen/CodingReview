package CodingDaily.LeCo;

import java.util.Arrays;
import java.util.Comparator;

public class courseFormNo207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.sort(prerequisites, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });
        for (int i = 1; i < prerequisites.length; i++)
            if (prerequisites[i][1] < prerequisites[i-1][1])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{3,0},{0,1}};
        courseFormNo207 demo = new courseFormNo207();
        boolean ans = demo.canFinish(4, a);
        System.out.println(ans);
    }
}

package CodingDaily.LeCo;

import java.util.Arrays;

public class differentPathsNo62 {
//    private int times;
//    public int uniquePaths(int m, int n) {
//        times = 0;
//        int[] array = new int[2];
//        move(1, 1, m, n);
//        return times;
//    }
//    private void move(int row, int column, int m, int n){
//        if (row == m && column == n){
//            times++;
//            return;
//        }
//        if (row > m || column > n)
//            return;
//        move(row+1, column, m, n);
//        move(row, column+1, m, n);
//    }
//
//    public static void main(String[] args) {
//        differentPathsNo62 demo = new differentPathsNo62();
//        int ans = demo.uniquePaths(23,12);
//        System.out.println(ans);
//    }
    public int uniquePaths(int m, int n) {
        int[] path = new int[n];
        Arrays.fill(path, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                path[j] += path[j-1];
        return path[n-1];
    }
}

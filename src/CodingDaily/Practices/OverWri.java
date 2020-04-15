package CodingDaily.Practices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OverWri {
    private static int[][] array;

    public static void main(String[] args) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }
}

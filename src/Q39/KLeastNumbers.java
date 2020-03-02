import java.util.ArrayList;

public class KLeastNumbers{
    // method1: partition
    public ArrayList<Integer> GetLeastNumbers1(int[] input, int k){
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        if (input == null || k <= 0 || k > input.length)
            return leastNumbers;
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k-1){
            if (index < k-1) {
                start = index + 1;
                index = partition(input, start, end);
            }
            else {
                end = end - 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++)
            leastNumbers.add(input[i]);
        return leastNumbers;
    }

    private int partition(int[] array, int low, int high){
        int key = array[low];
        while (low < high){
            while (low < high && array[high] >= key)
                high--;
            while (low < high && array[low] <= key)
                low++;
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        return low;
    }

    // traverse and compare, use heap for restoring
}
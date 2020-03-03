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
    public ArrayList<Integer> GetLeastNumbers2(int[] input, int k){
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        if (input == null || k <= 0 || k > input.length)
            return leastNumbers;
        int[] numbers = new int[k];
        for (int i = 0; i < k; i++)
            numbers[i] = input[i];
        for (int i = (k>>1)-1; i >= 0; i--)
            adjustHeap(numbers, i, k-1);
        for (int i = k; i < input.length; i++)
            if (input[i] < numbers[0]){
                numbers[0] = input[i];
                adjustHeap(numbers, 0, k-1);
            }
        for (int n : numbers)
            leastNumbers.add(n);
        return leastNumbers;
    }

    private void adjustHeap(int[] array, int start, int end){
        int temp = array[start];
        int child = (start<<1) + 1;
        while (child <= end) {
            if (child + 1 <= end && array[child + 1] > array[child])
                child++;
            if (array[child] < temp)
                break;
            array[start] = array[child];
            start = child;
            child = (child<<1) + 1;
        }
        array[start] = temp;
    }
}
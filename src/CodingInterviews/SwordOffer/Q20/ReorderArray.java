public class ReorderArray{
    public void reorderArray(int[] array){
        if (array == null || array.length == 0)
            return;
        int low = 0, high = array.length - 1;
        int temp;
        while (low < high){
            while (low < array.length && (array[low]&1) != 0)
                low++;
            while (high >= 0 && (array[high]&1) == 0)
                high--;
            if (low < high){
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }
}
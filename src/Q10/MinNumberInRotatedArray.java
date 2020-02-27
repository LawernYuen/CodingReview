public class MinNumberInRotatedArray{
    public int minNumberInRotatedArray(int[] array){
        if (array == null || array.length <= 0)
            throw new RuntimeException("Wrong Arguments!");
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;

        if (array[low] < array[high])
            return array[low];
        if (array[mid] == array[high] && array[mid] == array[low]){
            for (int i = 1; i <= high; i++)
                if (array[i] < array[i-1])
                    return array[i];
            return array[low];
        }

        while (low < high){
            if (high - low == 1)
                break;
            mid = (low + high) / 2;
            if (array[mid] <= array[high])
                high = mid;
            if (array[mid] > array[high])
                low = mid;
        }
        return array[high];
    }
}
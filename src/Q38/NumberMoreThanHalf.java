public class NumberMoreThanHalf{
    boolean isInputInvalid = true;

    // method1,partition
    public int partition(int[] array){
        if (array == null || array.length <= 0)
            return false;
        int low = 0;
        int high = array.length - 1;
        int index = partition(array, low, high);
        while (index != array.length>>1){
            if (index < array.length>>1){
                low = index + 1;
                index = partition(array, low, high);
            }
            else {
                high = index - 1;
                index = partition(array, low, high);
            }
        }
        int num = array[index];
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == num)
                count++;
        if (count > array.length>>1){
            isInputInvalid = false;
            return num;
        }
        return false;
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

    // method2: traverse and count
    public int TraverseAndCount(int[] array){
        if (array == null || array.length <= 0)
            return false;
        int num = array[0], count = 1;
        for (int i = 1; i < array.length; i++){
            if (count == 0){
                num = array[i];
                count++;
            }
            else if (array[i] == num)
                count++;
            else
                count--;
        }
        if (count > 0){
            int times = 0;
            for (int i = 0; i < array.length; i++){
                if (array[i] == num)
                    times++;
            }
            if (times > array.length>>1){
                isInputInvalid = false;
                return num;
            }
        }
        return false;
    }
}
public class GetIndex{
    public int getIndex(int[] array){
        if (array == null || array.length <= 0)
            return -1;
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) >> 1;
            if (array[mid] > mid)
                hi = mid - 1;
            else if (array[mid] < mid)
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
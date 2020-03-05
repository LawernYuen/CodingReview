public class MissingNum{
    public int getMissingNum(int[] array){
        if (array == null || array.length <= 0)
            return -1;
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) >> 1;
            if (array[mid] != mid){
                if (mid == 0 || array[mid-1] == mid-1)
                    return mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        return -1;
    }
}
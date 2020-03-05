public class NumOfK{
    public int getNumOfK(int[] array, int k){
        if (array == null || array.length <= 0)
            return 0;
        int firstK = getFirstK(array, 0, array.length-1, k);
        if (firstK == -1)
            return 0;
        int lastK = getLastK(array, firstK, array.length-1, k);
        return lastK-firstK+1;
    }

    private int getFirstK(int[] array, int lo, int hi, int k){
        if (lo > hi)
            return -1;
        int mid = (lo + hi) >> 1;
        if (array[mid] == k){
            if (mid == 0 || array[mid-1] != k)
                return mid;
            else
                hi = mid - 1;
        }
        else if (array[mid] < k)
            lo = mid + 1;
        else
            hi = mid - 1;
        return getFirstK(array, lo, hi, k);
    }

    private int getLastK(int[] array, int lo, int hi, int k){
        if (lo > k)
            return -1;
        int mid = (lo + hi) >> 1;
        if (array[mid] == k){
            if (mid == array.length-1 || array[mid+1] != k)
                return mid;
            else
                lo = mid + 1;
        }
        else if (array[mid] < k)
            lo = mid + 1;
        else
            hi = mid - 1;
        return getLastK(array, lo, hi, k);
    }
}
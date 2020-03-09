public class MergeSort{
    private static int[] aux;

    public static void sort(int[] a){
        aux = a;
        sort(a, 0, a.length-1);
    }

    public static void merge(int[] a, int lo, int mid, int hi){
        // 将a[lo..mid] 和 a[mid+1..hi]归并
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) // 构造辅助数组
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                // 左半边用尽，取右半边的数组
                a[k] = aux[j++];
            else if (j > hi)           // 右半边用尽，取左半边的数组
                a[k] = aux[i++];
            else if (aux[j] < aux[i])  // 右半边当前元素小于左半边当前元素，取右半边
                a[k] = aux[j++];
            else                       // 左半边当前元素小于右半边当前元素，取左半边
                a[k] = aux[i++];
        }
    }

    private static void sort(int[] a, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
}
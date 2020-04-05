package CodingDaily.Practices;

public class quicksort {
    public void sort(int[] array, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = partition(array, lo, hi);
        sort(array, lo, mid-1);
        sort(array, mid+1, hi);
    }
    private static int partition(int[] array, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int key = array[lo];
        while (true){
            while (array[++i] < key)
                if (i == hi)
                    break;
            while (array[--j] > key)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(array, i, j);
        }
        if (array[i] > key)
            exch(array, lo, --i);
        else
            exch(array, lo, i);
        return i;
    }
    private static void exch(int[] a, int m, int n){
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public static void main(String[] args){
        quicksort demo = new quicksort();
        int a[] = {5,3,8,4,2,5};
        demo.sort(a, 0, a.length-1);
        for (int i : a)
            System.out.print(i);
    }
}

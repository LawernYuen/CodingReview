package CodingDaily.Tests;

public class constructTriangle {
    public int constructTri(int[] array){
        quickSort(array, 0, array.length-1);
        for (int i = array.length-3; i >= 0; i--)
            if (array[i] < array[i+1] + array[i+2] && array[i] > Math.abs(array[i+1] - array[i+2]))
                return array[i]+array[i+1]+array[i+2];
        return 0;
    }
    private void quickSort(int[] array, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = partition(array, lo, hi);
        quickSort(array, lo, mid-1);
        quickSort(array, mid+1, hi);
    }
    private int partition(int[] array, int lo, int hi){
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
    private void exch(int[] a, int m, int n){
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3,4};
        constructTriangle demo = new constructTriangle();
        int ans = demo.constructTri(a);
        System.out.println(ans);
    }
}

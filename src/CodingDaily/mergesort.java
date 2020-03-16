package CodingDaily;

public class mergesort {
    private static int[] aux;
    public void sort(int[] array){
        aux = new int[array.length];
        sort(array, 0, array.length-1);
    }
    private static void sort(int[] array, int lo, int hi){
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        sort(array, lo, mid);
        sort(array, mid+1, hi);
        merge(array, lo, mid, hi);
    }
    private static void merge(int[] a, int lo, int mid, int hi){
        if (lo >= hi)
            return;
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++){
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[i] < aux[j])
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static void main(String[] args){
        mergesort demo = new mergesort();
        int a[] = {5,3,8,4,2,5};
        demo.sort(a);
        for (int i : a)
            System.out.print(i);
    }
}

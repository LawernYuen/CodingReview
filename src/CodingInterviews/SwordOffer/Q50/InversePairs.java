public class InversePairs{
    public int inversePairs(int[] array){
        if (array == null || array.length <= 0)
            return 0;
        int count = getCount(array, 0, array.length-1);
        return count;
    }

    private int getCount(int[] array, int lo, int hi){
        if (lo >= hi)
            return 0;
        int mid = (lo + hi) >> 1;
        int left = getCount(array, lo, mid);
        int right = getCount(array, mid+1, hi);

        int count = 0;
        int i = lo, j = mid+1;
        int[] temp = new int[hi-lo+1];
        int k = 0;
        while (i <= mid && j <= hi){
            if (array[i] > array[j]){
                count += (mid-i+1);
//                System.out.println("["+array[i]+","+array[j]+"]");
//                System.out.println(count+" "+left+" "+right);
                temp[k++] = array[j++];
            }
            else
                temp[k++] = array[i++];
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= hi)
            temp[k++] = array[j++];
        for (k = 0; k < hi-lo+1; k++)
            array[lo+k] = temp[k];
        return count+left+right;
    }

    public static void main(String[] args){
        InversePairs demo = new InversePairs();
        int[] a = new int[]{7,5,6,4};
        int num = demo.inversePairs(a);
        System.out.print(num);
    }
}
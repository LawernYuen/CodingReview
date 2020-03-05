public class RotateString{
    public String rotateString(char[] array, int n){
        if (array == null || array.length <= 0 || n <= 0 || n > array.length)
            return String.valueOf(array);
        reverse(array, 0, n-1);
        reverse(array, n, array.length-1);
        reverse(array, 0, array.length-1);
        return String.valueOf(array);
    }

    private void reverse(char[] array, int lo, int hi){
        while (lo < hi){
            char temp = array[lo];
            array[lo] = array[hi];
            array[hi] = temp;
            lo++;
            hi--;
        }
    }
}
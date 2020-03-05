public class ReverseWord{
    public String reverseWord(char[] array){
        if (array == null || array.length <= 0)
            return String.valueOf(array);
        // reverse whole sentence
        reverse(array, 0, array.length-1);
        // reverse each word
        int lo = 0, hi = 0;
        while (lo < array.length){
            while (hi < array.length && array[hi] != ' ')
                hi++;
            reverse(array, lo, hi-1);
            lo = ++hi;
        }
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
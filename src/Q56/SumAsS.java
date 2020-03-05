public class SumAsS{
    public void findSum(int[] array, int sum){
        if (array == null || array.length <= 0)
            return;
        int lo = 0, hi = array.length - 1;
        while (lo < hi){
            if (array[lo] + array[hi] == sum){
                System.out.println(array[lo] + " " + array[hi]);
                break;
            }
            else if (array[lo] + array[hi] < sum)
                lo++;
            else
                hi--;
        }
        return;
    }
}
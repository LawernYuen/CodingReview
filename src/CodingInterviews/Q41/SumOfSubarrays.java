public class SumOfSubarrays{
    boolean InvalidInput = false;
    public int findSum(int[] array){
        if (array == null || array.length <= 0) {
            InvalidInput = true;
            return 0;
        }
        int sum = array[0], maxSum = array[0];
        for (int i = 0; i < array.length; i++){
            // check if the sum till last turn is positive
            if (sum < 0)
                sum = array[i];
            else
                sum+=array[i];
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}
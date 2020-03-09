public class MaxProfit{
    public int MaxDiff(int[] array){
        if (array == null || array.length < 2)
            return -1;
        int min = array[0];

        int maxDiff = array[1] - min;
        for (int i = 1; i < array.length; i++){
            if (array[i-1] < min)
                min = array[i-1];
            if (array[i] - min > maxDiff)
                maxDiff = array[i] - min;
        }
        return maxDiff;
    }

    public static void main(String[] args){
        int[] array = {7, 3, 5, 2, 3};
        MaxProfit demo = new MaxProfit();
        int num = demo.MaxDiff(array);
        System.out.print(num);
    }
}
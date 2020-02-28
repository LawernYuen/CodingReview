public class CuttingRope{
    // DP
    public int maxProductAfterCutting1(int length){
        if (length <= 1)
            return 0;
        else if (length == 2)
            return 1;
        else if (length == 3)
            return 2;
        int[] product = new int[length+1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        for (int i = 4; i <= length; i++){
            int max = 0;
            for (int j = 1; j<= i/2; j++)
                if (max < product[j] * product[i-j])
                    max = product[j] * product[i-j];
            product[i] = max;
        }
        return product[length];
    }

    // Greedy
    public int maxProductAfterCutting2(int length){
        if (length <= 1)
            return 0;
        else if (length == 2)
            return 1;
        else if (length == 3)
            return 2;
        int timesOf3 = length/3;
        if (length - timesOf3*3 == 1)
            timesOf3--;
        int timesOf2 = (length-timesOf3*3) / 2;
        return (int) (Math.pow(3,timesOf3) * Math.pow(2,timesOf2));
    }
}
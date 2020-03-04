public class FindUglyNum{
    public int[] findUglyNum(int n){
        if (n <= 0)
            return null;
        int result = new int[n];
        result[0] = 1;
        int divisor2 = 0;
        int divisor3 = 0;
        int divisor5 = 0;
        for (int i = 1; i < n; i++){
            int product2 = result[divisor2] * 2;
            int product3 = result[divisor3] * 3;
            int product5 = result[divisor5] * 5;
            int min = Math.min(product2, Math.min(product3, product5));
            result[i] = min;
            if (product2 == result[i])
                divisor2++;
            if (product3 == result[i])
                divisor3++;
            if (product5 == result[i])
                divisor5++;
        }
        return result;
    }
}
public class Accumulate{
    public int getSum(int n){
        int sum = n;
        boolean flag = (n > 1) && ((sum += getSum(n-1)) > 0);
//        boolean flag = (n < 1) || ((sum += getSum(n-1)) > 0);
        return sum;
    }
}
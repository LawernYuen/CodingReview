public class Fibonacci{
    public long Fib(long n){
        if (n < 0)
            throw new RuntimeException("Wrong Arguments!");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long prepre = 0;
        long pre = 1;
        long result = 1;
        for (long i = 2; i <= n; i++){
            result = prepre + pre;
            prepre = pre;
            pre = result;
        }
        return result;
    }
}
public class Power{
    boolean IsInvalid = false;

    public double power(double base, int exponent){
        double result;
        if (exponent > 0)
            result = powerCore(base, exponent);
        else if (exponent < 0){
            if (base == 0){
                IsInvalid = true;
                return 0;
            }
            result = 1 / powerCore(base, -exponent);
        }
        else
            return 1;
    }

    private double powerCore(double base, int exponent){
        if (exponent == 1)
            return base;
        double result = powerCore(base, exponent>>1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }
}
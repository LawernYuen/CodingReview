import java.text.NumberFormat;

public class DicesProb{
    private static final int maxValue = 6;

    // method1: recursive
    // 这种递归都是外面两层循环，实际上外面一层是为了方便第二层调用自己，
    // 真正递归还构成一层循环，循环次数就是递归次数，比如数的位数，骰子
    // 的个数，表面上的循环次数是每个位数/个数可能出现的情况
    public void dicesProb1(int number){
        if (number <= 0)
            return;
        int[] prob = new int[maxValue*number - number + 1];
        for (int i = 0; i < prob.length; i++)
            prob[i] = 0;

        for (int i = 1; i <= maxValue; i++)
            calProb(prob, number, number-1, i);

        // all possible situations
        int totalCount = (int)Math.pow(maxValue, number);
        for (int i = 0; i < prob.length; i++){
            double ratio = (double)prob[i] / totalCount;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);
            System.out.println("The probability of "+(i+number)+" is "+format.format(ratio));
        }
    }

    private void calProb(int[] prob, int number, int current, int sum){
        if (current == 0){
            // 'cause the index starts from n: the number of dices
            prob[sum-number]++;
            return;
        }
        for (int i = 1; i <= maxValue)
            calProb(prob, number, number-1, sum+i);
    }

    // method2: based on loops, add one dice each loop
    public void dicesProb(int number){
        if (number <= 0)
            return;
        int[][] prob = new int[2][number*maxValue+1];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < number*maxValue+1; j++)
                prob[i][j] = 0;

        for (int i = 1; i <= 6; i++)
            prob[0][i] = 1;
        int flag = 0;
        for (int current = 2; current <= number; current++){
            // after adding the nth dice the smallest number could
            // only be n
            for (int i = 1; i < current; i++)
                prob[1-flag][i] = 0;

            // after adding a new dice, the occurences of n is
            // (n-1)+(n-2)+...+(n-6) for the new dice coule be
            // 1,2,...,6
            for (int i = current; i < current*maxValue; i++)
                // j cannot be larger than i 'cause i-j
                for (int j = 1; j <= 6 && j < i; j++)
                    prob[1-flag][i] += prob[flag][i-j];
            flag = 1 - flag;
        }

        int totalCount = (int) Math.pow(maxValue, number);
        for (int i = number; i <= number*6; i++){
            double ratio = (double)prob[flag][i] / totalCount;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);
            System.out.println("The probability of "+(i+number)+" is "+format.format(ratio));
        }
    }
}
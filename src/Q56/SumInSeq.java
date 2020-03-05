import java.util.ArrayList;

public class SumInSeq{
    // method1, 2 pointers to maintain a seq
    public ArrayList<ArrayList<Integer>> findSeq1(int sum){
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
        if (sum <= 0)
            return seqList;

        int lo = 1;
        int hi = 2;
        int currentSum = lo + hi;
        while (lo <= sum/2){
            if (currentSum == sum){
                ArrayList<Integer> seq = new ArrayList<Integer>();
                for (int i = lo; i <= hi; i++)
                    seq.add(i);
                seqList.add(seq);
                currentSum -= lo;
                lo++;
            }
            if (currentSum < sum){
                hi++;
                currentSum += hi;
            }
            if (currentSum > sum){
                currentSum -= lo;
                lo++;
            }
        }
        return seqList;
    }

    // method2 analysis
    public ArrayList<ArrayList<Integer>> findSeq2(int sum) {
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
        if (sum <= 0)
            return seqList;

        for (int n = (int)Math.sqrt(2*sum); n >= 2; n--){
            if (((n&1)!=0 && sum%n==0) || ((n&1==0) && (sum%n)*2==n)){
                ArrayList<Integer> seq = new ArrayList<Integer>();
                for (int j = 0, k = (sum/n)-(n-1)/2; j < n; j++, k++)
                    seq.add(k);
                seqList.add(seq);
            }
        }
        return seqList;
    }
}
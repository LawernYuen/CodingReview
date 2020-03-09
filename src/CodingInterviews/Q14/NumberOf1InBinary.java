public class NumberOf1InBinary{
    public int NumberOfOne1(int n){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public int NumberOfOne2(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
}
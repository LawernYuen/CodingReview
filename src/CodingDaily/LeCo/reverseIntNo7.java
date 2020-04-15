package CodingDaily.LeCo;

public class reverseIntNo7 {
    public int reverse(int x) {
        if (x < 10 && x > -10)
            return x;
        int[] array = new int[10];
        int count = 0;
        int y = x;
        while (y % 10 == 0){
            count++;
            y /= 10;
        }
        y = x;
        int idx = 0;
        while (y != 0){
            array[idx] = y % 10;
            idx++;
            y /= 10;
        }
        long ans = 0;
        for (int i = count; i < idx; i++){
            if (x >= 0)
                ans = ans*10 + array[i];
            else
                ans = ans*10 - array[i];
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;
        else
            return x>0 ? (int)ans : (int)-ans;
    }

    public static void main(String[] args) {
        reverseIntNo7 demo = new reverseIntNo7();
        int ans = demo.reverse(1534236469);
        System.out.println(ans);
    }
}

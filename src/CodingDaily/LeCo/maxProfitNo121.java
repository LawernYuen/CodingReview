package CodingDaily.LeCo;

public class maxProfitNo121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        maxProfitNo121 demo = new maxProfitNo121();
        int ans = demo.maxProfit(a);
        System.out.println(ans);
    }
}

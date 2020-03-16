package CodingDaily;

public class DupIn3Array {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int ans = 0, temp = 0;
        for (int value : A) {
            temp = 1;
            for (int j = 31; j >= 0; j--) {
                if ((value & temp) != 0)
                    count[j]++;
                temp = temp << 1;
            }
        }
        for(int i = 0; i <= 31; i++){
            if(count[i] % 3 != 0)
                ans = (ans<<1) + 1;
            else
                ans = ans << 1;
        }
        return ans;
    }
    public static void main(String[] args){
        DupIn3Array demo = new DupIn3Array();
        int[] a = {1};
        demo.singleNumber(a);
    }
}

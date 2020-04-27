package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.List;

public class elegantSubarrayNo1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if ((nums[i] & 1) == 1)
                list.add(i);
        int ans = 0;
        if (list.size() < k)
            return ans;
        for (int i = 0; i < list.size()-k+1; i++){
            int start = list.get(i);
            int end = list.get(i+k-1);
            int startprev = i==0 ? -1 : list.get(i-1);
            int endnext = i==list.size()-k ? nums.length : list.get(i+k);
            ans += ((start-startprev) * (endnext-end));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 1};
        elegantSubarrayNo1248 demo = new elegantSubarrayNo1248();
        int ans = demo.numberOfSubarrays(a, 3);
        System.out.println(ans);
    }
}

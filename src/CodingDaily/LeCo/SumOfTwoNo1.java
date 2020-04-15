package CodingDaily.LeCo;

import java.util.Arrays;
import java.util.Comparator;

public class SumOfTwoNo1 {
    public int[] twoSum(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length-1;
        int[] ans = new int[2];
        int[][] numss = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++){
            numss[i][0] = nums[i];
            numss[i][1] = i;
        }
        Arrays.sort(numss, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        while (p1 < p2){
            if (numss[p1][0] + numss[p2][0] == target)
                break;
            else if (numss[p1][0] + numss[p2][0] < target)
                p1++;
            else if (numss[p1][0] + numss[p2][0] > target)
                p2--;
        }
        ans[0] = Math.min(numss[p1][1], numss[p2][1]);
        ans[1] = Math.max(numss[p1][1], numss[p2][1]);
        return ans;
    }
}

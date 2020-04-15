package CodingDaily.LeCo;

public class maxContainerNo11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int p1 = 0, p2 = height.length-1;
        while (p1 < p2){
            ans = Math.max(ans, (p2-p1)*Math.min(height[p2],height[p1]));
            if (height[p2] > height[p1])
                p1++;
            else
                p2--;
        }
        return ans;
    }
}

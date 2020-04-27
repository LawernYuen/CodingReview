package CodingDaily.LeCo;

public class searchInRotatedArrayNo33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int lo = 0;
        int hi = nums.length-1;
        int mid;
        while (lo <= hi){
            mid = lo + (hi-lo) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[lo] <= nums[mid]){
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            }
            else {
                if (target <= nums[hi] && target > nums[mid])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5};
        searchInRotatedArrayNo33 demo = new searchInRotatedArrayNo33();
        int ans = demo.search(array, 3);
        System.out.println(ans);
    }
}

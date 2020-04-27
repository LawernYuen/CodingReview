package CodingDaily.LeCo;

public class JumpGameNo55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        boolean[] isValid = new boolean[nums.length];
        for (int i = nums.length-2; i >= 0; i--){
            if (i + nums[i] >= nums.length-1) {
                isValid[i] = true;
                continue;
            }
            for (int j = 1; j <= nums[i]; j++){
                if (isValid[i+j]) {
                    isValid[i] = true;
                    break;
                }
            }
        }
        return isValid[0];
    }
}

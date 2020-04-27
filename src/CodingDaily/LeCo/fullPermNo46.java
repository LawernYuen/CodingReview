package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.List;

public class fullPermNo46 {
    List<List<Integer>> ansList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        perm(nums, 0);
        return ansList;
    }
    private void perm(int[] nums, int index){
        if (index == nums.length){
            List<Integer> temp = new ArrayList<>(list);
            ansList.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++){
            exch(nums, index, i);
            list.add(nums[index]);
            perm(nums, index+1);
            exch(nums, index, i);
            list.remove(list.size()-1);
        }
    }
    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        fullPermNo46 demo = new fullPermNo46();
        demo.permute(nums);
    }
}

package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.Arrays;

public class recoverBTNo99 {
    ArrayList<Integer> list = new ArrayList<>();
    int index = 0;
    public void recoverTree(TreeNode root) {
        InOrder(root);
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
        Arrays.sort(array);
        recoverCore(root, array);
    }
    private void InOrder(TreeNode root){
        if (root == null)
            return;
        InOrder(root.left);
        list.add(root.val);
        InOrder(root.right);
    }
    private void recoverCore(TreeNode root, int[] array){
        if (root == null)
            return;
        recoverCore(root.left, array);
        root.val = array[index];
        index++;
        recoverCore(root.right, array);
    }
}
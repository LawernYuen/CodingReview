package CodingDaily.LeCo;

public class sumRoot2LeafNo129 {
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return ans;
        int currentSum = 0;
        getSum(root, currentSum);
        return ans;
    }

    private void getSum(TreeNode root, int currentSum){
        currentSum = currentSum*10 + root.val;
        if (root.left == null && root.right == null)
            ans += currentSum;
        else {
            if (root.left != null)
                getSum(root.left, currentSum);
            if (root.right != null)
                getSum(root.right, currentSum);
        }
    }
}

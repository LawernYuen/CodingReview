package CodingDaily;
import java.util.ArrayList;

public class sumNumbers {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int sum(TreeNode root){
        int ans = 0;
        if (root == null)
            return ans;
        return preOrder(root, ans);
    }

//    private int preOrder(TreeNode node, int sum){
//        if (node == null)
//            return 0;
//        sum = sum + node.val;
//        if (node.left == null && node.right == null)
//            return sum;
//        return preOrder(node.left,sum) + preOrder(node.right,sum);
//    }

    private int preOrder(TreeNode node, int sum){
        if (node == null)
            return 0;
        sum = sum + node.val;
        if (node.left == null && node.right == null)
            return sum;
        int left = preOrder(node.left, sum);
        int right = preOrder(node.right, left);
        return right;
    }

    private int test(){
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        sumNumbers demo = new sumNumbers();
        return demo.sum(p1);
    }

    public static void main(String[] args){
        sumNumbers demo = new sumNumbers();
        int a = demo.test();
        System.out.print(a);
    }
}

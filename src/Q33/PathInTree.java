import java.util.ArrayList;

public class PathInTree{
    public class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void findPath(TreeNode root, int target){
        if (root == null)
            return;
        ArrayList<Integer> list = new ArrayList<>();
        printPath(root, target, list);
    }

    private void printPath(TreeNode node, int target, ArrayList<Integer> list){
        if (node == null)
            return;
        list.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            for (Integer integer : list)
                System.out.print(integer + " ");
            System.out.println();
        }
        else {
            printPath(node.left, target, list);
            printPath(node.right, target, list);
        }
        list.remove(list.size() - 1);
    }
}
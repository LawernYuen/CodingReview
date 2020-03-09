import java.util.LinkedList;
import java.util.Stack;

public class PrintTree{
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void printTree1(TreeNode root){
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while (queue.size() != 0){
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        System.out.println();
    }

    public void printTree2(TreeNode root){
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int pCount = 0;
        int nextCount = 1;
        while (!queue.isEmpty()){
            pCount = nextCount;
            nextCount = 0;
            // print node in every floor
            for (int i = 1; i < pCount; i++){
                node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null){
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            System.out.println();
        }
    }

    public void printTree3(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = null;
        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()){
            while (!stack1.empty()){
                node = stack1.pop();
                System.out.print(node.val + " ");
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            System.out.println();
            while (!stack2.empty()){
                node = stack2.pop();
                System.out.print(node.val + " ");
                if (node.left != null)
                    stack1.push(node.right);
                if (node.right != null)
                    stack1.push(node.left);
            }
            System.out.println();
        }
    }
}
package CodingDaily.LeCo;

public class list2treeNo109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode leftend = head;
        ListNode rightstart = head;
        int length = 0;
        while (leftend != null){
            leftend = leftend.next;
            length++;
        }
        if (length == 1)
            return new TreeNode(head.val);
        leftend = head;
        for (int i = 1; i < length/2; i++)
            leftend = leftend.next;
        rightstart = leftend.next;
        leftend.next = null;
        TreeNode node = new TreeNode(rightstart.val);
        rightstart = rightstart.next;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(rightstart);
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        list2treeNo109 demo = new list2treeNo109();
        TreeNode root = demo.sortedListToBST(node1);
    }
}

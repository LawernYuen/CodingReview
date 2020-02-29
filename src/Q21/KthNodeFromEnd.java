import java.util.Stack;

public class KthNodeFromEnd{
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // Stack
    public ListNode KthFromEnd1(ListNode head, int k){
        if (head == null || k <= 0)
            return null;
        int numOfList = 1;
        Stack<ListNode> st = new Stack<ListNode>();
        st.push(head);
        ListNode node = head.next;
        while (node != null){
            numOfList++;
            st.push(node);
            node = node.next;
        }
        if (k > numOfList)
            return null;
        else
            for (int i = 1; i <= k; i++)
                node = st.pop();
        return node;
    }

    // two pointers
    public ListNode KthFromEnd2(ListNode head, int k){
        if (head == null || k <= 0)
            return null;
        ListNode pAhead = head;
        ListNode pBehind = head;
        for (int i = 1; i < k; i++){
            pAhead = pAhead.next;
            if (pAhead == null)
                return null;
        }
        while (pAhead.next != null){
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }
}
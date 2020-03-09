public class ReverseList{
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head){
        if (head == null)
            return null;
        ListNode pNode = head;
        ListNode preNode = null;
        ListNode nextNode = pNode.next;
        while (nextNode != null){
            pNode.next = preNode;
            preNode = pNode;
            pNode = nextNode;
            nextNode = pNode.next;
        }
        pNode.next = preNode;
        return pNode;
    }
}
public class EntryNodeInListLoop{
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    // to confirm if there is a loop
    private ListNode meetingNode(ListNode head){
        if (head == null)
            return null;
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null){
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
            if (pSlow != null && pSlow == pFast)
                return pSlow;
        }
        return null; // no loop
    }
    // to find the entry node
    public ListNode entryNodeOfLoop(ListNode head){
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;

        // to get the size of loop
        int count = 1;
        ListNode pNode1 = meetingNode.next;
        while (pNode1 != meetingNode){
            count++;
            pNode1 = pNode1.next;
        }

        pNode1 = head;
        for (int i = 1; i <= count; i++)
            pNode1 = pNode1.next;
        ListNode pNode2 = head;
        while (pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}
public class DeleteDuplicatedNode{
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode preNode = null;
        ListNode curNode = pHead;
        while (curNode != null){
            boolean needDelete = false;
            if (curNode.next != null && curNode.val == curNode.next.val)
                needDelete = true;
            if (!needDelete) {
                preNode = curNode;
                curNode = curNode.next;
            }
            else {
                int dupValue = curNode.val;
                ListNode tobeDel = curNode;
                while (tobeDel != null && tobeDel.next == dupValue)
                    tobeDel = tobeDel.next;
                preNode.next = tobeDel;
                curNode = tobeDel;
            }
        }
        return pHead;
    }
}
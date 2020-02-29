public class DeleteNodeInList{
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public void deleteNode(ListNode head, ListNode pToBeDeleted){
        if (head == null || pToBeDeleted == null)
            return;
        //待删除节点不是尾节点
        if (pToBeDeleted.next != null){
            pToBeDeleted.val = pToBeDeleted.next.val;
            pToBeDeleted.next = pToBeDeleted.next.next;
        }
        //只有一个节点
        else if (head == pToBeDeleted){
            head = null;
            pToBeDeleted = null;
        }
        //待删除节点为尾节点，需遍历
        else {
            ListNode preNode = head;
            while (preNode.next!=pToBeDeleted && preNode!=null)
                preNode = preNode.next;
            if (preNode == null)
                throw new RuntimeException("Wrong Arguments!");
            preNode.next = null;
            pToBeDeleted = null;
        }
        return;
    }
}
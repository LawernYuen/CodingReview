package CodingDaily;

public class SortList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode sortlist(ListNode head) {
        if(head == null)
            return null;
        else if (head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p2prev = head;
        while(p1 != null){
            p1 = p1.next;
            if(p1 != null)
                p1 = p1.next;
            if (p2 != head)
                p2prev = p2prev.next;
            p2 = p2.next;
        }
        if (p2prev != null)
            p2prev.next = null;
        sortlist(head);
        sortlist(p2);
        return merge(head, p2);
    }
    private static ListNode merge(ListNode p1, ListNode p2){
        if(p1 == null)
            return p2;
        if(p2 == null)
            return p1;
        if(p1.val < p2.val){
            p1.next = merge(p1.next, p2);
            return p1;
        }
        else{
            p2.next = merge(p1, p2.next);
            return p2;
        }
    }
    public void test(){
        ListNode list = new ListNode(7);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(9);
        list.next = node1;
        node1.next = node2;
        node2.next = node3;
//        ListNode list = null;
        SortList demo = new SortList();
        ListNode p = sortlist(list);
    }
    public static void main(String[] args){
        SortList demo = new SortList();
        demo.test();
    }
}
public class CommonNodeOfList{
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // method1: iterate twice
    public ListNode commonNode1(ListNode pHead1, ListNode pHead2) {
        int length1 = 0, length2 = 0;
        ListNode node1 = pHead1, node2 = pHead2;
        while (node1 != null) {
            length1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            length2++;
            node2 = node2.next;
        }
        node1 = pHead1, node2 = pHead2;
        if (length1 > length2) {
            while ( int i = length1 - length2;
            i > 0;
            i--)
            node1 = node1.next;
            while (node1 != null && node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        } else {
            while ( int i = length2 - length1;
            i > 0;
            i--)
            node2 = node2.next;
            while (node2 != null && node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node2;
        }
    }

    // method2: two pointers, list1+list2, list2+list1
    public ListNode commonNode2(ListNode pHead1, ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = p1==null ? pHead2 : p1.next;
            p2 = p2==null ? pHead1 : p2.next;
        }
        return p1;
    }
}
package CodingDaily.LeCo;

public class removeLastNNo19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++)
            p1 = p1.next;
        if (p1 == null)
            return head.next;
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode temp = p2.next;
        temp = temp.next;
        p2.next = temp;
        return head;
    }
}
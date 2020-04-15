package CodingDaily.LeCo;

public class AddTwoNumNo2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = 0, length2 = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null){
            p1 = p1.next;
            length1++;
        }
        while (p2 != null){
            p2 = p2.next;
            length2++;
        }
        if (length1 >= length2)
            return addTwoCore(l1, l2);
        else
            return addTwoCore(l2, l1);
    }
    private ListNode addTwoCore(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        int flag = 0;
        while (true){
            int val = l1.val + l2.val + flag;
            l1.val = val % 10;
            flag = val >= 10 ? 1 : 0;
            if (l1.next == null || l2.next == null)
                break;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1.next != null){
            l1 = l1.next;
            int val = l1.val + flag;
            l1.val = val % 10;
            flag = val >= 10 ? 1 : 0;
            if (flag == 0)
                break;
        }
        if (flag == 1)
            l1.next = new ListNode(1);
        return p1;
    }
}

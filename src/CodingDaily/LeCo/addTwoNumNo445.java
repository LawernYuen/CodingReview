package CodingDaily.LeCo;

public class addTwoNumNo445 {
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
        int dist = Math.abs(length1-length2);
        if (length1 > length2){
            int flag = addCore(l1, l2, dist);
            return remainOperate(l1, flag, dist);
        }
        else {
            int flag = addCore(l2, l1, dist);
            return remainOperate(l2, flag, dist);
        }
    }
    private ListNode remainOperate(ListNode node, int flag, int dist){
        boolean flagg = false;
        ListNode p = node;
        if (flag == 1)
            flagg = getNextSole(p, dist);
        if (!flagg)
            return node;
        else {
            ListNode newNode = new ListNode(1);
            newNode.next = node;
            return newNode;
        }
    }
    private boolean getNextSole(ListNode node, int dist){
        if (dist == 0)
            return true;
        if (dist == 1){
            int val = node.val + 1;
            node.val = val % 10;
            return val >= 10;
        }
        boolean flag = getNextSole(node.next, dist-1);
        if (flag){
            int val = node.val + 1;
            node.val = val % 10;
            return val >= 10;
        }
        else
            return false;
    }
    private int getNext(ListNode node1, ListNode node2){
        if (node1 == null)
            return 0;
        int flag = getNext(node1.next, node2.next);
        int val = node1.val + node2.val + flag;
        node1.val = val % 10;
        if (val >= 10)
            return 1;
        else
            return 0;
    }
    private int addCore(ListNode l1, ListNode l2, int dist){
        while (dist > 0){
            l1 = l1.next;
            dist--;
        }
        return getNext(l1, l2);
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(5);
        ListNode p2 = new ListNode(5);
        addTwoNumNo445 demo = new addTwoNumNo445();
        ListNode p = demo.addTwoNumbers(p1, p2);
        System.out.println(p);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

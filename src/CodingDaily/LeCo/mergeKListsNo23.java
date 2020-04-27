package CodingDaily.LeCo;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKListsNo23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node : lists)
            if (node != null)
                queue.offer(node);
        ListNode root = queue.peek();
        while (!queue.isEmpty()){
            ListNode p = queue.poll();
            if (p.next == null)
                p.next = queue.peek();
            else
                queue.offer(p.next);
            p.next = queue.peek();
        }
        return root;
    }
}

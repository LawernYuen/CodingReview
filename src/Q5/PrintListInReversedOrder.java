import java.util.Stack;
// 主方法可以调用静态的私有类，不能调用非静态方法

public class PrintListInReversedOrder{
    private class ListNode{
        int key;
        ListNode next;
        public ListNode(int key){
            this.key = key;
            this.next = null;
        }
    }

    public void printListReversingly_Iteratively(ListNode node){
        Stack<ListNode> stack = new Stack<ListNode>();
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop().key);
        }
    }

    public void printListReversingly_Recursively(ListNode node){
        if (node != null){
            printListReversingly_Recursively(node.next);
            System.out.println(node.key);
        }
        return;
    }

    public void test1() {
        ListNode aListNode = null;
        printListReversingly_Iteratively(aListNode);
        printListReversingly_Recursively(aListNode);
    }

    public void test2() {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode1.next=ListNode2;
        ListNode2.next=ListNode3;
        printListReversingly_Iteratively(ListNode1);
        printListReversingly_Recursively(ListNode1);
    }

    public void test3() {
        ListNode ListNode1 = new ListNode(1);
        printListReversingly_Iteratively(ListNode1);
        printListReversingly_Recursively(ListNode1);
    }

    public static void main(String[] args){
        PrintListInReversedOrder demo = new PrintListInReversedOrder();
//        ListNode ListNode1 = null;
//        demo.printListReversingly_Iteratively(ListNode1);
//        demo.printListReversingly_Recursively(ListNode1);
//
//        ListNode ListNode21 = new ListNode(1);
//        ListNode ListNode22 = new ListNode(2);
//        ListNode ListNode23 = new ListNode(3);
//        ListNode21.next = ListNode22;
//        ListNode22.next = ListNode23;
//        demo.printListReversingly_Iteratively(ListNode21);
//        demo.printListReversingly_Recursively(ListNode21);
//
//        demo.printListReversingly_Iteratively(ListNode23);
//        demo.printListReversingly_Recursively(ListNode23);
        demo.test1();
        demo.test2();
        demo.test3();
    }
}
public class CopyComplexList{
    private class ComplexListNode{
        int val;
        ComplexListNode next;
        ComplexListNode sibling;
        ComplexListNode(int val, ComplexListNode next, ComplexListNode sibling){
            this.val = val;
            this.next = next;
            this.sibling = sibling;
        }
    }

    // main thread
    public ComplexListNode cloneList(ComplexListNode head){
        cloneNodes(head);
        connectSiblingNodes(head);
        return splitLists(head);
    }

    // clone nodes
    private void cloneNodes(ComplexListNode head){
        ComplexListNode pNode = head;
        while (pNode != null){
            ComplexListNode cloneNode = new ComplexListNode(pNode,
                    pNode.next, null);
            pNode.next = cloneNode;
        }
    }
    // set siblings
    private void connectSiblingNodes(ComplexListNode head){
        ComplexListNode pNode = head;
        while (pNode != null){
            if (pNode != null)
                pNode.next.sibling = pNode.sibling.next;
            pNode = pNode.next.next;
        }
    }
    // split to 2 lists
    private ComplexListNode splitLists(ComplexListNode head){
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;
        ComplexListNode pNode = head;
        if (head != null) {
            clonedHead = head.next;
            clonedNode = pNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next; // to check if is null in next loop
        }
        while (pNode != null) {
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        return clonedHead;
    }
}
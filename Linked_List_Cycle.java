public class Linked_List_Cycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-1);
        listNode.next.next.next.next = listNode.next;
        Linked_List_Cycle linkedListCycle =new Linked_List_Cycle();
        linkedListCycle.hasCycle(listNode);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slowpointer = head;
        ListNode fastpointer = head;

        while (slowpointer != null && fastpointer != null && fastpointer.next != null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
            if (slowpointer == fastpointer) return true;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

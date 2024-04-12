public class Remove_Nth_Node_From_End_List {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Remove_Nth_Node_From_End_List removeNthNodeFromEndList = new Remove_Nth_Node_From_End_List();
        removeNthNodeFromEndList.removeNthFromEnd(listNode,1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;

        // create offset
        while (n > 0) {
            ptr = ptr.next;
            n--;
        }

        // move to end
        ListNode idx = head;
        ListNode prev = null;
        while (ptr != null) {
            ptr = ptr.next;
            prev = idx;
            idx = idx.next;
        }

        // edge case
        if (prev == null) {
            return idx.next;
        }

        prev.next = idx.next;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

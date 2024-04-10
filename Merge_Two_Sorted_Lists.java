public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        Merge_Two_Sorted_Lists mergeTwoSortedLists = new Merge_Two_Sorted_Lists();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        mergeTwoSortedLists.mergeTwoLists(node,node2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeList = new ListNode(0);

        ListNode returnlist = mergeList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val){
                returnlist.next = list1;
                list1 = list1.next;
            }
            else {
                returnlist.next = list2;
                list2 = list2.next;
            }
            returnlist = returnlist.next;
        }

        if (list1 == null){
            returnlist.next = list2;
        }else if (list2 == null){
            returnlist.next = list1;
        }
        return mergeList.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

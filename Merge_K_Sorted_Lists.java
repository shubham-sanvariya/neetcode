public class Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] listNodes = {node1,node2,node3};
        Merge_K_Sorted_Lists mergeKSortedLists = new Merge_K_Sorted_Lists();
        mergeKSortedLists.mergeKLists(listNodes);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1;

        while (interval < lists.length){
            for (int i = 0; i + interval< lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

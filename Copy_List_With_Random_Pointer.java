import java.util.HashMap;
import java.util.Map;

public class Copy_List_With_Random_Pointer {
    public static void main(String[] args) {
        Node node = new Node(7);
        node.random = null;
        node.next = new Node(13);
        node.next.random = new Node(0);
        node.next.next = new Node(11);
        node.next.next.random = new Node(4);
        node.next.next.next = new Node(10);
        node.next.next.next.random = new Node(2);
        node.next.next.next.next = new Node(1);
        node.next.next.next.next.random = new Node(0);

        Copy_List_With_Random_Pointer copyListWithRandomPointer = new Copy_List_With_Random_Pointer();
        copyListWithRandomPointer.copyRandomList(node);
    }

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (map.containsKey(head))
            return map.get(head);

        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }

public static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
}

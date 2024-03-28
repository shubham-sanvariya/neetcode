public class Min_Stack {

    public static void main(String[] args) {
        Min_Stack minStack = new Min_Stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    class Node{
        int val;
        int min;
        Node next;

        public Node(int val,int min,Node next){
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    private Node head;
    public Min_Stack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val,val,null);
        }else {
            Node node = new Node(val,Math.min(head.min,val),head);
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
       return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

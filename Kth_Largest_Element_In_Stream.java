import java.util.PriorityQueue;

public class Kth_Largest_Element_In_Stream {

    public static void main(String[] args) {
        Kth_Largest_Element_In_Stream kth_largest_element_in_stream = new Kth_Largest_Element_In_Stream();
        kth_largest_element_in_stream.KthLargest(3, new int[]{4, 5, 8, 2});
        kth_largest_element_in_stream.add(3);   // return 4
        kth_largest_element_in_stream.add(5);   // return 5
        kth_largest_element_in_stream.add(10);  // return 5
        kth_largest_element_in_stream.add(9);   // return 8
        kth_largest_element_in_stream.add(4);   // return 8
    }
    int k;
    PriorityQueue<Integer> queue;
    public void KthLargest(int k, int[] nums) {
        queue = new PriorityQueue();
        this.k = k;

        for (int num: nums){
            queue.offer(num);
        }

        while(queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k){
            queue.poll();
        }

        return queue.peek();
    }
}

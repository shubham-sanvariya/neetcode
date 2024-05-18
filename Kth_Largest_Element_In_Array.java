import java.util.PriorityQueue;

public class Kth_Largest_Element_In_Array {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        Kth_Largest_Element_In_Array kthLargestElementInArray = new Kth_Largest_Element_In_Array();
        kthLargestElementInArray.findKthLargest(arr,2);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;
        for(int n: nums){
            pq.offer(n);
        }
        while(k > 0){
            ans = pq.poll();
            k--;
        }
        System.out.println(ans);
        return ans;
    }
}

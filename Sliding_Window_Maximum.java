import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        Sliding_Window_Maximum slidingWindowMaximum = new Sliding_Window_Maximum();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        slidingWindowMaximum.maxSlidingWindow(arr,3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> maxQ = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[i])
                maxQ.pollLast();
            maxQ.offerLast(nums[i]);
            if (i >= k && nums[i - k] == maxQ.peekFirst()) // out-of-bounds
                maxQ.pollFirst();
            if (i >= k - 1)
                ans[i - k + 1] = maxQ.peekFirst();
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }
}

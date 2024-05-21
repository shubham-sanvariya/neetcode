import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Find_Median_In_Data_Stream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }


    static class MedianFinder {
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            // Balance the two heaps s.t.
            // |maxHeap| >= |minHeap| and |maxHeap| - |minHeap| <= 1.
            if (maxHeap.size() < minHeap.size())
                maxHeap.offer(minHeap.poll());
            else if (maxHeap.size() - minHeap.size() > 1)
                minHeap.offer(maxHeap.poll());
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size())
                return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
            return (double) maxHeap.peek();
        }

        private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private Queue<Integer> minHeap = new PriorityQueue<>();
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Meeting_Schedule_II {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval interval = new Interval(0,40);
        list.add(interval);
        Interval interval1 = new Interval(5,10);
        list.add(interval1);
        Interval interval2 = new Interval(15,20);
        list.add(interval2);
        Meeting_Schedule_II meetingScheduleIi = new Meeting_Schedule_II();
        meetingScheduleIi.minMeetingRooms(list);
    }

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Use a min-heap to store the end times of ongoing meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            // If the meeting room is free (no ongoing meeting has ended yet),
            // reuse the same room.
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll(); // Remove the earliest ending meeting from the room
            }
            minHeap.offer(interval.end); // Add the current meeting's end time
        }

        // The number of meeting rooms required is the size of the min-heap at the end.
        System.out.println(minHeap.size());
        return minHeap.size();
    }

     static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

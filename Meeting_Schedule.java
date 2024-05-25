import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Meeting_Schedule {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval interval = new Interval(0,30);
        list.add(interval);
        Interval interval1 = new Interval(5,10);
        list.add(interval);
        Interval interval2 = new Interval(15,20);
        list.add(interval);

        Meeting_Schedule meetingSchedule = new Meeting_Schedule();
        meetingSchedule.canAttendMeetings(list);
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                System.out.println(false);
                return false;
            }
        }

        return true;
    }

    public static class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
   }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Minimum_Interval_To_Include_Each_Query {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{2,4},{3,6},{4,4}};
        int[] nums = {2,3,4,5};
        Minimum_Interval_To_Include_Each_Query minimumIntervalToIncludeEachQuery =
                new Minimum_Interval_To_Include_Each_Query();
        minimumIntervalToIncludeEachQuery.minInterval(arr,nums);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(intervals,(x,y)->(x[0]-y[0]));

        int arr[] = new int[queries.length], i=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->((x[1]-x[0]) - (y[1]-y[0])));

        for(int j=0;j<arr.length;j++)
            arr[j]=queries[j];

        Arrays.sort(arr);

        for(int q : arr) {
            // reuse the HashMap to get values to duplicate queries for further optimizations
            if(map.get(q) != null)
                continue;

            while(i<intervals.length && intervals[i][0]<=q){
                pq.offer(intervals[i++]);
            }
            while(pq.size()!=0 && pq.peek()[1]<q){
                pq.poll();
            }
            map.put(q,(pq.size()==0)?-1:pq.peek()[1]-pq.peek()[0]+1);
        }
        for(i=0;i<queries.length;i++){
            queries[i]=map.get(queries[i]);
        }
        return queries;
    }
}

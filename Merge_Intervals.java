import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        Merge_Intervals mergeIntervals  = new Merge_Intervals();
        mergeIntervals.merge(arr);
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        /*
        1 2 8  15
        3 6 10 18
        */

        for(int i = 0, j = 0; i < n; i++) {
            if(i == n-1 || end[i] < start[i+1]) {
                ans.add(new int[]{start[j], end[i]});
                j = i+1;
            }
        }

        System.out.println(Arrays.deepToString(ans.toArray(new int[ans.size()][])));
        return ans.toArray(new int[ans.size()][]);
    }
}

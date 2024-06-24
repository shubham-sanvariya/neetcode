import java.util.ArrayList;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        Longest_Increasing_Subsequence longestIncreasingSubsequence = new Longest_Increasing_Subsequence();
        longestIncreasingSubsequence.lengthOfLIS(arr);
    }

    public int lengthOfLIS(int[] a) {
        int n = a.length;
        ArrayList<Integer> b = new ArrayList<>();
        b.add(a[0]);
        for ( int i = 1; i < n; ++i ) {
            if ( a[i] > b.get(b.size()-1) ) {
                b.add(a[i]);
            }
            else {
                int l = 0, r = b.size()-1;
                while ( l <= r ) {
                    int m = l + ((r-l)>>1);
                    if ( b.get(m) < a[i] ) {
                        l = m+1;
                    }
                    else r = m-1;
                }
                b.set(l, a[i]);
            }
        }
        System.out.println(b.size());
        return b.size();
    }
}

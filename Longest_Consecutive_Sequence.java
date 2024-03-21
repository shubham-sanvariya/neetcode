import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        Longest_Consecutive_Sequence longestConsecutiveSequence = new Longest_Consecutive_Sequence();
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums3 = {1,2,0,1};
        longestConsecutiveSequence.longestConsecutive(nums);
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1, temp = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Integer[] arrSet = set.toArray(new Integer[set.size()]);
        Arrays.sort(arrSet);
        int cs = arrSet[0];
        for (int i = 1; i < arrSet.length; i++) {
            if(arrSet[i] == cs + 1){
                cs = arrSet[i];
                count++;
            }
            else{
                cs = arrSet[i];
                if(temp < count){
                    temp = count;
                }
                count = 1;
            }
        }
        return Integer.max(count,temp);
    }
}

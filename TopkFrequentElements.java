import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopkFrequentElements {
    public static void main(String[] args) {
        TopkFrequentElements topkFrequentElements = new TopkFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        topkFrequentElements.topKFrequent(nums,2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        // save each element's appearance in a table
        Map<Integer, Integer> bucket1 = new HashMap<>();
        for (int num : nums) {
            bucket1.put(num, bucket1.getOrDefault(num, 0) + 1);
        }

        // Store each element's frequence as the key
        Map<Integer, List<Integer>> bucket2 = new HashMap<>();
        for (Integer num : bucket1.keySet()) {
            Integer elementFreq = bucket1.get(num);
            if (!bucket2.containsKey(elementFreq)) {
                bucket2.put(elementFreq, new ArrayList<>());
            }
            bucket2.get(elementFreq).add(num);
        }
        // Get Top K elements
        int[] res = new int[k];
        for (int n = nums.length; n > 0; n--) {
            if (bucket2.containsKey(n)) {
                List<Integer> list = bucket2.get(n);
                for (Integer integer : list) {
                    res[--k] = integer;
                    if (k == 0)
                        return res;
                }
            }
        }
        return res;
    }
}

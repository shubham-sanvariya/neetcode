import java.util.ArrayList;
import java.util.List;

public class Partition_Labels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Partition_Labels partitionLabels = new Partition_Labels();
        partitionLabels.partitionLabels(s);
    }

        public List<Integer> partitionLabels(String s) {
            int n = s.length();
            List<Integer> result = new ArrayList<>();
            if (n == 0) { return result; }
            if (n == 1) {
                result.add(1);
                return result;
            }

            int[] maxInd = new int[64];
            // O(n)
            for (int i = 0; i < n; i++) {  maxInd[s.charAt(i) - 'a'] = i; }
            int cutLimit = 0;
            int i = 0;

            //O(n)
            while (i <= cutLimit) {
                cutLimit = Math.max(cutLimit, maxInd[s.charAt(i) - 'a']);
                i++;
            }

            String newS = s.substring(i, n);
            result.add(i);
            result.addAll(partitionLabels(newS));
            System.out.println(result);
            return result;
    }
}

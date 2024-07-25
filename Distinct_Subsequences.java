public class Distinct_Subsequences {
    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s,t));
    }

    public static int numDistinct(String source, String target) {

        int[] sums = new int[target.length() + 1]; // 1 indexed
        sums[0] = 1;
        int maxIndex = 0;
        char[] targetArr = target.toCharArray();
        char[] sourceArr = source.toCharArray();
        for (int i = 0; i < sourceArr.length; i++) {
            char sourceChar = sourceArr[i];
            if (maxIndex < targetArr.length - 1 && sourceChar == targetArr[maxIndex]) maxIndex++;
            int minIndex = Math.max(0, i - sourceArr.length + targetArr.length);
            for (int j = maxIndex; j >= minIndex; j--) {
                if (sourceChar == targetArr[j]) {
                    sums[j + 1] += sums[j]; // 1 indexed
                }
            }
        }
        return sums[sums.length - 1];
    }
}

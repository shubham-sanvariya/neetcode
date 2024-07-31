import java.util.Arrays;

public class Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; // There are no 1's in the binary representation of 0

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }
}

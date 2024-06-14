public class Climbing_Stairs {
    public static void main(String[] args) {
        Climbing_Stairs climbingStairs = new Climbing_Stairs();
        climbingStairs.climbStairs(2);
    }

    public int climbStairs(int n) {
        if (n == 1 ) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
        return dp[n];
    }
}

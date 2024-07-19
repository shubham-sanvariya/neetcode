public class Coin_Change_II {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(change(5,coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (final int coin : coins)
            for (int i = coin; i <= amount; ++i)
                dp[i] += dp[i - coin];

        return dp[amount];
    }
}

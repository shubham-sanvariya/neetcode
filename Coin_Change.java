public class Coin_Change {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        Coin_Change coinChange = new Coin_Change();
        coinChange.coinChange(coins,amount);
    }

    public int coinChange(int[] coins, int tar) {
        int []dp=new int[tar+1];
        dp[0]=0;


        for(int amt=1;amt<=tar;amt++){
            int count = Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin<=amt){
                    count = Math.min(dp[amt-coin] , count);
                }
            }
            dp[amt] = count == Integer.MAX_VALUE ? Integer.MAX_VALUE : count+1;
        }
        System.out.println(dp[tar] == Integer.MAX_VALUE ? -1:dp[tar]);
        return dp[tar] == Integer.MAX_VALUE ? -1:dp[tar];
    }
}

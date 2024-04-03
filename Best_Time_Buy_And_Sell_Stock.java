public class Best_Time_Buy_And_Sell_Stock {
    public static void main(String[] args) {
        Best_Time_Buy_And_Sell_Stock bestTimeBuyAndSellStock = new Best_Time_Buy_And_Sell_Stock();
        int[] arr = {7,1,5,3,6,4};
        bestTimeBuyAndSellStock.maxProfit(arr);
    }

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++) {
            if(prices[i] < buy)
                buy = prices[i];
            else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}

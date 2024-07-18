public class Best_Time_Buy_and_Sell_Stock_With_Cooldown {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,2};

        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int sell = 0;
        int hold = Integer.MIN_VALUE;
        int prev = 0;

        for (final int price : prices) {
            final int cache = sell;
            sell = Math.max(sell, hold + price);
            hold = Math.max(hold, prev - price);
            prev = cache;
        }

        return sell;
    }
}

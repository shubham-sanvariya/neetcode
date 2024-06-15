public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        int arr[] = {10,15,20};
        Min_Cost_Climbing_Stairs minCostClimbingStairs = new Min_Cost_Climbing_Stairs();
        minCostClimbingStairs.minCostClimbingStairs(arr);
    }

    public int minCostClimbingStairs(int[] cost) {
        final int n = cost.length;

        for (int i = 2; i < n; ++i)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        System.out.println(Math.min(cost[n - 1], cost[n - 2]));
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}

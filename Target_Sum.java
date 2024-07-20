public class Target_Sum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        target = target<0 ? -target : target;
        if((sum + target) % 2 == 1){
            return 0;
        }
        int v = (sum + target) / 2;
        int[] dp = new int[v + 1];
        dp[0] = 1;
        ways(nums, dp, 0, v);
        return dp[v];
    }

    private static void ways(int[] nums, int[] dp, int i, int t){
        if(i==nums.length){
            return;
        }
        for(int j=t; j>=nums[i]; j--){
            dp[j] = dp[j] + dp[j - nums[i]];
        }
        ways(nums, dp, i+1, t);
    }
}

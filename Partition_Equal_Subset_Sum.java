public class Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        Partition_Equal_Subset_Sum partitionEqualSubsetSum = new Partition_Equal_Subset_Sum();
        partitionEqualSubsetSum.canPartition(arr);
    }

    boolean[][] impossible;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        var target = sum / 2;
        impossible = new boolean[nums.length + 1][target + 1];
        return canPartition(nums, nums.length, target);
    }

    public boolean canPartition(int[] nums, int start, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (start == 0) {
            impossible[start][target] = true;
        }
        if (impossible[start][target]) {
            return false;
        }
        boolean possible = canPartition(nums, start - 1, target - nums[start - 1]) || canPartition(nums, start - 1, target);
        impossible[start][target] = !possible;
        System.out.println(possible);
        return possible;
    }
}

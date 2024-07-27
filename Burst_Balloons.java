public class Burst_Balloons {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[] {3,1,5,8}));
    }

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dpValue = new int[n + 2][n + 2];

        for (int i = n; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                int ij = newNums[i] * newNums[j];
                int tempAns = 0;
                for (int k = i + 1; k < j; k++) {
                    tempAns = Math.max(tempAns, ij * newNums[k] + dpValue[i][k] + dpValue[k][j]);
                }
                dpValue[i][j] = tempAns;
            }
        }

        return dpValue[0][n + 1];
    }
}

public class Jump_Game {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        Jump_Game jumpGame = new Jump_Game();
        jumpGame.canJump(arr);
    }

    public boolean canJump(int[] nums) {
        int i = 0;

        for (int reach = 0; i < nums.length && i <= reach; ++i)
            reach = Math.max(reach, i + nums[i]);

        return i == nums.length;
    }
}

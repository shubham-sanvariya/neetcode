import java.util.Arrays;

public class Last_Stone_Weight {
    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        Last_Stone_Weight lastStoneWeight = new Last_Stone_Weight();
        lastStoneWeight.lastStoneWeight(arr);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        while (stones[stones.length - 2] != 0) {
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        System.out.println(stones[stones.length - 1]);
        return stones[stones.length - 1];
    }
}

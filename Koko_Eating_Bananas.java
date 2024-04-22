import java.util.Arrays;

public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        Koko_Eating_Bananas kokoEatingBananas = new Koko_Eating_Bananas();
        int[] nums = {3,6,7,11};
        kokoEatingBananas.minEatingSpeed(nums,8);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) {
            total += p;
        }
        int left = (int) ((total - 1) / h) + 1;
        int right = (int) ((total - n) / (h - n + 1)) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        return left;
    }
}

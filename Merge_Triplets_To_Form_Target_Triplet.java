import java.util.Arrays;

public class Merge_Triplets_To_Form_Target_Triplet {
    public static void main(String[] args) {
        int[][] arr = {{2,5,3},{1,8,4},{1,7,5}};
        int[] nums = {2,7,5};
        Merge_Triplets_To_Form_Target_Triplet mergeTripletsToFormTargetTriplet =
                new Merge_Triplets_To_Form_Target_Triplet();
        mergeTripletsToFormTargetTriplet.mergeTriplets(arr,nums);
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merged = new int[target.length];

        for (int[] triplet : triplets)
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2])
                for (int i = 0; i < target.length; ++i)
                    merged[i] = Math.max(merged[i], triplet[i]);

        System.out.println(Arrays.equals(merged,target));
        return Arrays.equals(merged, target);
    }
}

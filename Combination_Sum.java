import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Combination_Sum combinationSum = new Combination_Sum();
        combinationSum.combinationSum(candidates,target);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        dfs(ls, new ArrayList<>(), target, arr, 0);
        System.out.println(ls);
        return ls;
    }
    public void dfs(List<List<Integer>> global, List<Integer> current, int target, int[] arr, int index) {
        if (target == 0) {
            global.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] <= target) {
                current.add(arr[i]);
                dfs(global, current, target - arr[i], arr, i);
                current.remove(current.size() - 1);
            }
        }
    }
}

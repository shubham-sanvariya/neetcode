import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Permutations permutations = new Permutations();
        permutations.permute(arr);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
        System.out.println(ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, used, path, ans);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

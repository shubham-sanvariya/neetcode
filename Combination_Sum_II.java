import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        Combination_Sum_II combinationSumIi = new Combination_Sum_II();
        combinationSumIi.combinationSum2(arr,target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, ans, ds, 0);
        System.out.println(ans);
        return ans;
    }
    public void combination(int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds, int index) {
        //base case
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i = index ; i < candidates.length; i++) {

            //not pick
            if(i > index && candidates[i] == candidates[i-1])   continue;
            if(candidates[i] > target) break;

            //pick
            ds.add(candidates[i]);
            combination(candidates, target - candidates[i], ans, ds, i + 1);
            ds.remove(ds.size() - 1);
        }
    }
}

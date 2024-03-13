import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        containsDuplicate.containsDuplicate(nums);
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int a : nums){
            if (map.containsKey(a)){
                System.out.println(true);
                return true;
            }
            map.put(a,0);
        }
        System.out.println(false);
        return false;
    }
}

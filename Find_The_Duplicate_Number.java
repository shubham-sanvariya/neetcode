public class Find_The_Duplicate_Number {
    public static void main(String[] args) {
        Find_The_Duplicate_Number findTheDuplicateNumber = new Find_The_Duplicate_Number();
        findTheDuplicateNumber.findDuplicate(new int[] {1,3,4,2,2});
    }

    public int findDuplicate(int[] nums) {
        boolean visited[] = new boolean[nums.length + 1];
        for(int x : nums) {
            if(visited[x]) {
                return x;
            }
            visited[x] = true;
        }
        return -1;
    }
}

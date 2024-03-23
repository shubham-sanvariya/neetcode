import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        Two_Sum_II_Input_Array_Is_Sorted twoSumIiInputArrayIsSorted = new Two_Sum_II_Input_Array_Is_Sorted();
        int[] nums = {2,7,11,15};
        twoSumIiInputArrayIsSorted.twoSum(nums,13);
    }

    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;// length of given array
        int i=0;//to point left index
        int j=n-1;//to point right index
        int mid=0;//to find mid
        int ans[]=new int[2];//to store result
        while(i < j) {//loop will run till left <right
            mid = (i+j)/2;//find the mid
            int sum = numbers[i] + numbers[j];//to store the addition of left and right element
            if(sum == target) {//if target is equal to sum than return index
                ans[0] = i+1;
                ans[1] = j+1;
                System.out.println(Arrays.toString(ans));
                return ans;
            }
            else if(sum<target)  //if target is greater than sum than
            {
                if(numbers[j]+numbers[mid]<target)//cheak if right and mid element sum is less than target
                {
                    i=mid+1;//than i incraese to mid+1
                }
                else{
                    i++;// else increase i by 1
                }

            }
            else{
                if(numbers[i]+numbers[mid]>target)//else sum is greater than target than cheak if  left element and mid element than set right  j to mid-1
                {
                    j=mid-1;
                }
                else{
                    j--;//else decrease j by 1
                }
            }

        }
        System.out.println(Arrays.toString(ans));
        return ans;// return ans
    }
}

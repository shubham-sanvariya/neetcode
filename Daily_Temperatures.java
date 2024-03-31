import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {
    public static void main(String[] args) {
        Daily_Temperatures dailyTemperatures= new Daily_Temperatures();
        int[] arr = {73,74,75,71,69,72,76,73};
        dailyTemperatures.dailyTemperatures(arr);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int nums[] = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--){

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                nums[i] = stack.peek() - i;
            }

            stack.push(i);
        }
        return nums;
    }
}

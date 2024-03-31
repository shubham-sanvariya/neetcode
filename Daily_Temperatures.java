import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {
    public static void main(String[] args) {
        Daily_Temperatures dailyTemperatures= new Daily_Temperatures();
        int[] arr = {73,74,75,71,69,72,76,73};
        dailyTemperatures.dailyTemperatures(arr);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
            if(temperatures[i]>=max) {
                max = temperatures[i];
            } else {
                int last = i+1;
                while(temperatures[i]>=temperatures[last]) {
                    last += res[last];
                }
                res[i] = last-i;
            }
        }
        return res;
    }
}

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        Maximum_Subarray maximumSubarray = new Maximum_Subarray();
        maximumSubarray.maxSubArray(arr);
    }

    public int maxSubArray(int[] nums) {
        int c=0, m=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            c+=nums[i];
            m=c>m?c:m;
            if(c<0)
                c=0;
        }
        System.out.println(m);
        return m;
    }
}

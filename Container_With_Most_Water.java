public class Container_With_Most_Water {
    public static void main(String[] args) {
        Container_With_Most_Water containerWithMostWater = new Container_With_Most_Water();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        containerWithMostWater.maxArea(arr);
    }

    public int maxArea(int[] height) {
        int max_area = 0;
        int start_pointer = 0;
        int end_pointer = height.length - 1;

        while (start_pointer < end_pointer){
            if (height[start_pointer] < height[end_pointer]){
                max_area = Math.max(max_area, height[start_pointer] * (end_pointer - start_pointer));
                start_pointer += 1;
            } else {
                max_area = Math.max(max_area, height[end_pointer] * (end_pointer - start_pointer));
                end_pointer -= 1;
            }
        }
        return max_area;
    }
}

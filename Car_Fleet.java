import java.util.Arrays;

public class Car_Fleet {
    public static void main(String[] args) {
        Car_Fleet carFleet = new Car_Fleet();
        int[] position = {6,8};
        int[] speed = {3,2};
        carFleet.carFleet(10,position,speed);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        float[] time = new float[target+1];
        for (int i=0; i < position.length; i++) {
            time[position[i]] = (float)(target - position[i]) / speed[i];
            // System.out.println();
        }
        float max = 0;
        int count = 0;
        for (int i=time.length-1; i >= 0; i--) {
            if (time[i] > max) {
                count++;
                max = time[i];
            }
        }

        return count;
    }
}

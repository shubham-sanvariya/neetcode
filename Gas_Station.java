public class Gas_Station {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Gas_Station gasStation = new Gas_Station();
        gasStation.canCompleteCircuit(gas,cost);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int fuel = 0;
        for(int i = 0; i < n; i++){
            fuel += gas[i] - cost[i];
        }

        if(fuel < 0) return -1;

        fuel = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            fuel += gas[i] - cost[i];
            if(fuel < 0){
                fuel = 0;
                start = i+1;
            }
        }
        System.out.println(start);
        return start;
    }
}

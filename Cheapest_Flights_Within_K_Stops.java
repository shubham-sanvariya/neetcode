import java.util.Arrays;

public class Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        Cheapest_Flights_Within_K_Stops cheapestFlightsWithinKStops = new Cheapest_Flights_Within_K_Stops();
        cheapestFlightsWithinKStops.findCheapestPrice(n,flights,src,dst,k);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i <= k; i++) {
            if (isRoutePossible(distance, flights)) {
                break;
            }
        }
        int res = distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
        System.out.println(res);
        return res;
    }

    private boolean isRoutePossible(int[] dist, int[][] flights) {
        int[] copy = Arrays.copyOf(dist, dist.length);
        boolean result = true;

        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int cost = flight[2];

            if (copy[src] != Integer.MAX_VALUE && dist[dst] > copy[src] + cost) {
                dist[dst] = cost + copy[src];
                result = false;
            }
        }
        return result;
    }
}

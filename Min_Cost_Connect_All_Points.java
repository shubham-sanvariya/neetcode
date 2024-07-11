import java.util.Arrays;

public class Min_Cost_Connect_All_Points {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,1},{5,2},{7,0}};
        Min_Cost_Connect_All_Points minCostConnectAllPoints = new Min_Cost_Connect_All_Points();
        minCostConnectAllPoints.minCostConnectPoints(points);
    }

    public int minCostConnectPoints(int[][] points) {
        // dist[i] := the minimum distance to connect the points[i]
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int ans = 0;

        for (int i = 0; i < points.length - 1; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                // Try to connect the points[i] with the points[j].
                dist[j] = Math.min(dist[j], Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]));
                // Swap the points[j] (the point with the mnimum distance) with the
                // points[i + 1].
                if (dist[j] < dist[i + 1]) {
                    final int[] tempPoint = points[j];
                    points[j] = points[i + 1];
                    points[i + 1] = tempPoint;
                    final int tempDist = dist[j];
                    dist[j] = dist[i + 1];
                    dist[i + 1] = tempDist;
                }
            }
            ans += dist[i + 1];
        }
        System.out.println(ans);
        return ans;
    }
}

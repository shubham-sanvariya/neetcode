import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 1}); // return 1. You can choose:
        //   - The first, second, and third points
        detectSquares.count(new int[]{14, 8});  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int[]{11, 2});    // Adding duplicate points is allowed.
        detectSquares.count(new int[]{11, 1});
    }

    private Map<Integer, Map<Integer, Integer>> pointsCount;

    public DetectSquares() {
        pointsCount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int count = 0;

        if (!pointsCount.containsKey(x)) {
            return count;
        }

        Map<Integer, Integer> yCountMap = pointsCount.get(x);

        for (int y1 : yCountMap.keySet()) {
            if (y1 == y) continue;

            int d = Math.abs(y1 - y);

            // Check for squares on the left and right of the current point
            count += getCount(x + d, y, x + d, y1, x, y1);
            count += getCount(x - d, y, x - d, y1, x, y1);
        }

        return count;
    }

    private int getCount(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (pointsCount.containsKey(x1) && pointsCount.containsKey(x2)) {
            Map<Integer, Integer> yCountMap1 = pointsCount.get(x1);
            Map<Integer, Integer> yCountMap2 = pointsCount.get(x2);

            return yCountMap1.getOrDefault(y1, 0) *
                    yCountMap2.getOrDefault(y2, 0) *
                    pointsCount.get(x3).getOrDefault(y3, 0);
        }

        return 0;
    }
}

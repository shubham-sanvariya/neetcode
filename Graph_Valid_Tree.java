import java.util.*;

public class Graph_Valid_Tree {
    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        Graph_Valid_Tree graphValidTree = new Graph_Valid_Tree();
        graphValidTree.validTree(n, arr);
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges.length != n - 1)
            return false;

        List<Integer>[] graph = new List[n];
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(0));
        Set<Integer> seen = new HashSet<>(Arrays.asList(0));

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        while (!q.isEmpty()) {
            final int u = q.poll();
            for (final int v : graph[u])
                if (!seen.contains(v)) {
                    q.offer(v);
                    seen.add(v);
                }
        }
        System.out.println(seen.size() == n);
        return seen.size() == n;
    }
}

public class Network_Delay_Time {
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        Network_Delay_Time networkDelayTime = new Network_Delay_Time();
        networkDelayTime.networkDelayTime(arr,n,k);
    }

    int INF = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        // find sum of min distances of k to others
        if(times.length < n-1)
            return -1;

        int mat[][] = new int[n+1][n+1];
        for(int i = 1; i < n+1; i ++) {
            for(int j = 1; j < n+1; j ++) {
                mat[i][j] = i == j ? 0 : INF;
            }
        }
        for(int t[] : times) {
            mat[t[0]][t[1]] = t[2];
        }

        int dp[] = mat[k];
        boolean visited[] = new boolean[n+1];
        visited[k] = true;
        for(int i = 0; i < n-1; i ++) {
            int minTime = INF;
            int v = 0;

            for(int j = 1; j < n+1; j ++) {
                if(!visited[j] && minTime > dp[j]) {
                    minTime = dp[j];
                    v = j;
                }
            }

            // has no any node can be reached
            if(minTime == INF)
                return -1;

            visited[v] = true;

            for(int j = 1; j < n+1; j ++) {
                // d(k,j) = d(k,v)+d(v,j) when kvj is smaller than kj
                if(mat[k][j] - mat[k][v] > mat[v][j]) {
                    dp[j] = dp[v]+mat[v][j];
                }
            }
        }

        int minTime = 0;
        for(int i = 1; i < n+1; i ++)
            if(i != k)
                minTime = Math.max(minTime, dp[i]);
        int res = minTime == 0 ? -1 : minTime;
        System.out.println(res);
        return res;
    }
}

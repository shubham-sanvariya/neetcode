import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
    public static void main(String[] args) {
        int[][] arr = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        Pacific_Atlantic_Water_Flow pacificAtlanticWaterFlow = new Pacific_Atlantic_Water_Flow();
        pacificAtlanticWaterFlow.pacificAtlantic(arr);
    }

    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;

        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // DFS
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        // preparing the result
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        System.out.println(res);
        return res;
    }

    static void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean){
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;
        if (matrix[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        for(int[] d : dir)
            dfs(matrix, i + d[0], j + d[1], matrix[i][j], ocean);
    }
}

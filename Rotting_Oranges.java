import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    public static void main(String[] args) {
        Rotting_Oranges rottingOranges = new Rotting_Oranges();
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        rottingOranges.orangesRotting(arr);
    }

    public int orangesRotting(int[][] grid) {
        int fre = 0;
        int row = grid.length;
        int col  = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(grid[i][j] == 1)fre++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }

        if(fre == 0) return 0;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0;i<size;i++){
                int[] r =  q.poll();
                for(int j=0;j<4;j++){

                    int x = r[0] + dx[j];
                    int y = r[1] + dy[j];


                    if(x>=0 && y>=0 && x<row && y<col && grid[x][y]==1){

                        fre--;
                        grid[x][y] =2;
                        q.add(new int[]{x,y});
                    }

                }
            }
            count++;
        }

        if(fre!=0) return -1;
        return count-1;

    }
}

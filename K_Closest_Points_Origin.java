import java.util.Arrays;

public class K_Closest_Points_Origin {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{-2,2}};
        K_Closest_Points_Origin kClosestPointsOrigin = new K_Closest_Points_Origin();
        kClosestPointsOrigin.kClosest(arr,1);
    }

    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        int[] dists=new int[n];
        for(int i=0;i<n;i++){
            dists[i]=distance(points[i]);
        }
        int[] unsortedDists=Arrays.copyOf(dists, dists.length);
        Arrays.sort(dists);
        int distK=dists[k-1];

        int[][] ans=new int[k][2];
        int j=0;
        for(int i=0;i<n;i++){
            if(unsortedDists[i]<=distK){
                ans[j++]=points[i];
            }
        }
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }

    private int distance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}

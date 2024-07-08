import java.util.Arrays;

public class Redundant_Connection {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{1,3},{2,3}};
        Redundant_Connection redundantConnection = new Redundant_Connection();
       int[] res =  redundantConnection.findRedundantConnection(arr);
        System.out.println(Arrays.toString(res));
    }

    int[] parent;
    public int find(int i){
        if(i==parent[i])return i;
        return parent[i]=find(parent[i]);
    }
    public boolean union(int a,int b){
        int A=find(a);
        int B=find(b);
        if(A!=B){
            parent[A]=B;
            return false;
        }
        //as cycle exist and A==B they both point to same parent and there is edge
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        //classic union find problem
        int n=edges.length;

        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int ed[]:edges){
            if(union(ed[0],ed[1])){
                return ed;
            }
        }
        return new int[]{0,0};
    }
}

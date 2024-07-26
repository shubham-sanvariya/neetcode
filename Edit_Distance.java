import java.util.Arrays;

public class Edit_Distance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        Edit_Distance editDistance = new Edit_Distance();
        System.out.println(editDistance.minDistance(word1,word2));
    }

    public int minDistance(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s,t,m-1,n-1,dp);
    }
    public int f(String s,String t,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=0+f(s,t,i-1,j-1,dp);
        }else{
            int a=1+f(s,t,i-1,j,dp);
            int b=1+f(s,t,i,j-1,dp);
            int c=1+f(s,t,i-1,j-1,dp);
            return dp[i][j]=Math.min(a,Math.min(b,c));
        }
    }
}

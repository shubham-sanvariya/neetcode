import java.util.Arrays;

public class Decode_Ways {
    public static void main(String[] args) {
        String s = "12";
        Decode_Ways decodeWays = new Decode_Ways();
        decodeWays.numDecodings(s);
    }

    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        dp[n-1]=s.charAt(n-1)=='0'?0:1;
        for(int i=n-2;i>=0;i--){
//             System.out.println(i+" "+s.charAt(i)+" , "+s.charAt(i+1));
            if(s.charAt(i)=='0'){
                dp[i]=0;
            }else
            if(s.charAt(i)<'2' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){  // s.substring(i,i+2).compareTo("26")<=0
                dp[i]=dp[i+2]+dp[i+1];
            }else{
                dp[i]=dp[i+1];
            }
        }
//         System.out.println(Arrays.toString(dp));
        System.out.println(dp[0]);
        return dp[0];
    }
}

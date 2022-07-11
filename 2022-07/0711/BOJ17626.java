import java.util.*;
import java.io.*;
public class BOJ17626 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <N+1 ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i ; j++) {
                int res = i-j*j;
                min= Math.min(min,dp[res]);
            }
            dp[i]=min+1;
        }
        System.out.println(dp[N]);
        

    }
}

import java.util.*;
import java.io.*;

public class BOJ1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N+1];
        DP[0] = 1;
        DP[1] = 1;
        if(N>=2){
            for(int i = 2; i<N+1;i++){
                DP[i] = (DP[i-2]+DP[i-1])%15746;
            }
        }
        System.out.println(DP[N]);
    }
}



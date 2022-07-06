import java.io.*;

public class BOJ2579 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+1];
        int[] DP = new int[N+1];
        for (int i = 1; i <= N; i++) {
            stairs[i]=Integer.parseInt(br.readLine());
        }
        if(N==1){
            DP[1] = stairs[1];
        }else if(N==2){
            DP[2] = stairs[1]+stairs[2];
        }else{
            DP[1] = stairs[1];
            DP[2] = stairs[1]+stairs[2];
            DP[3] = Math.max(stairs[1]+stairs[3],stairs[2]+stairs[3]);
            for (int i = 4; i <= N; i++) {
                DP[i] = Math.max(DP[i-2]+stairs[i],DP[i-3]+stairs[i-1]+stairs[i]);
            }
        }
        System.out.println(DP[N]);
    }
}

